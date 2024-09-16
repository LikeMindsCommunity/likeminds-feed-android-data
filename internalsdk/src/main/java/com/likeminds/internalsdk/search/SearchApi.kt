package com.likeminds.internalsdk.search

import com.likeminds.internalsdk.search.model._GetSearchPostsRequest_
import com.likeminds.internalsdk.search.model._GetSearchPostsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse


interface SearchApi {
    suspend fun searchPosts(
        request: _GetSearchPostsRequest_
    ): NetworkResponse<APIResponse<_GetSearchPostsResponse_>>
}