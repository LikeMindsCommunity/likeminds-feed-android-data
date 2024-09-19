package com.likeminds.likemindsfeed.search

import com.likeminds.internalsdk.search.model._SearchPostsRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.search.model.SearchPostsRequest
import com.likeminds.likemindsfeed.search.model.SearchPostsResponse
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class SearchClient @Inject constructor() : BaseClient() {
    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().searchComponent()?.inject(this)
    }

    private val searchApi by lazy {
        feedSDK.getSearchApi()
    }

    // Converts client request model to internal model and calls the api
    suspend fun searchPosts(searchPostsRequest: SearchPostsRequest): LMResponse<SearchPostsResponse> {
        RequestUtils.validate()
        validateSearchPostRequest(searchPostsRequest)

        val request = _SearchPostsRequest_.Builder()
            .page(searchPostsRequest.page)
            .pageSize(searchPostsRequest.pageSize)
            .search(searchPostsRequest.search)
            .searchType(searchPostsRequest.searchType.value)
            .build()

        // Api call
        return when (val response = searchApi.searchPosts(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                val data = response.body
                ModelConverter.convertSearchPostAPIResponse(data)
            }
        }
    }

    private fun validateSearchPostRequest(searchPostsRequest: SearchPostsRequest) {
        if (searchPostsRequest.search.isNullOrEmpty()) {
            RequestUtils.throwException("search")
        }
    }
}