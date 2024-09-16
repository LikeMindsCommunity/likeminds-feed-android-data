package com.likeminds.likemindsfeed.search

import com.likeminds.internalsdk.search.model._GetSearchPostsRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.search.model.GetSearchPostsRequest
import com.likeminds.likemindsfeed.search.model.GetSearchPostsResponse
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

    suspend fun searchPosts(getSearchPostsRequest: GetSearchPostsRequest):LMResponse<GetSearchPostsResponse>{
        RequestUtils.validate()

        val request = _GetSearchPostsRequest_.Builder()
            .page(getSearchPostsRequest.page)
            .pageSize(getSearchPostsRequest.pageSize)
            .search(getSearchPostsRequest.search)
            .searchType(getSearchPostsRequest.searchType)
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

}