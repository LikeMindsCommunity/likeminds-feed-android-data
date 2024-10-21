package com.likeminds.internalsdk.search

import com.likeminds.internalsdk.search.model._SearchPostsRequest_
import com.likeminds.internalsdk.search.model._SearchPostsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class SearchReceiver @Inject constructor(
    private val searchNetworkApi: SearchNetworkApi
) {
    suspend fun searchPosts(
        request: _SearchPostsRequest_
    ): NetworkResponse<APIResponse<_SearchPostsResponse_>> {
        // create queries map
        val queries = HashMap<String, Any?>()

        // add page, page size, search and search type
        queries["page"] = request.page
        queries["page_size"] = request.pageSize
        queries["search"] = request.search
        queries["search_type"] = request.searchType

        return searchNetworkApi.searchPosts(queries)
    }
}