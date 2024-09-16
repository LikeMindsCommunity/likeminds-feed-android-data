package com.likeminds.internalsdk.search

import com.likeminds.internalsdk.search.model._GetSearchPostsRequest_
import com.likeminds.internalsdk.search.model._GetSearchPostsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class SearchReceiver @Inject constructor(
    private val searchNetworkApi: SearchNetworkApi
) {
    companion object {
        const val PAGE_QUERY = "page"
        const val PAGE_SIZE_QUERY = "page_size"
        const val SEARCH_QUERY = "search"
        const val SEARCH_TYPE_QUERY = "search_type"
    }


    suspend fun searchPosts(request: _GetSearchPostsRequest_): NetworkResponse<APIResponse<_GetSearchPostsResponse_>{
        // INCOMPLETE

        return searchNetworkApi.searchPosts()
    }
}