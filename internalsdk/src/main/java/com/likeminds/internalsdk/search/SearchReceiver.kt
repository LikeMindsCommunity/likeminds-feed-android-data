package com.likeminds.internalsdk.search

import com.likeminds.internalsdk.search.model._GetSearchPostsRequest_
import com.likeminds.internalsdk.search.model._GetSearchPostsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class SearchReceiver @Inject constructor(
    private val searchNetworkApi: SearchNetworkApi
) {

    suspend fun searchPosts(
        request: _GetSearchPostsRequest_
    ): NetworkResponse<APIResponse<_GetSearchPostsResponse_>>{
        val queries = HashMap<String, Any?>()
        queries["page"] = request.page
        queries["page_size"] = request.pageSize
        queries["search"] = request.search
        queries["search_type"] = request.searchType

        return searchNetworkApi.searchPosts(queries)
    }
}