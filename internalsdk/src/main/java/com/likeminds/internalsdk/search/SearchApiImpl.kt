package com.likeminds.internalsdk.search

import com.likeminds.internalsdk.search.model._SearchPostsRequest_
import com.likeminds.internalsdk.search.model._SearchPostsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class SearchApiImpl @Inject constructor(
    private val searchReceiver: SearchReceiver
) : SearchApi {

    override suspend fun searchPosts(
        request: _SearchPostsRequest_
    ): NetworkResponse<APIResponse<_SearchPostsResponse_>> {
        return searchReceiver.searchPosts(request)
    }
}