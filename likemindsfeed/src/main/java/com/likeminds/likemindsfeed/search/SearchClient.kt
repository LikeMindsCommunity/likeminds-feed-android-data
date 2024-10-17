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

    /**
     * Converts clients models to queries map and calls the api
     * @param searchPostsRequest - client request model to search posts
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return [SearchPostsResponse] - SearchPostsResponse model for searchPostsRequest
     * */
    suspend fun searchPosts(searchPostsRequest: SearchPostsRequest): LMResponse<SearchPostsResponse> {
        // validates the client request
        RequestUtils.validate()
        validateSearchPostRequest(searchPostsRequest)

        // builds internal request model
        val request = _SearchPostsRequest_.Builder()
            .page(searchPostsRequest.page)
            .pageSize(searchPostsRequest.pageSize)
            .search(searchPostsRequest.search)
            .searchType(searchPostsRequest.searchType.value)
            .build()

        // calls api and processes the response accordingly
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

    /**
     * validates [searchPostsRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateSearchPostRequest(searchPostsRequest: SearchPostsRequest) {
        if (searchPostsRequest.search.isNullOrEmpty()) {
            RequestUtils.throwException("search")
        }
    }
}