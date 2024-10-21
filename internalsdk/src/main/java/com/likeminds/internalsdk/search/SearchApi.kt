package com.likeminds.internalsdk.search

import com.likeminds.internalsdk.search.model._SearchPostsRequest_
import com.likeminds.internalsdk.search.model._SearchPostsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse


interface SearchApi {

    // api to search posts
    suspend fun searchPosts(
        request: _SearchPostsRequest_
    ): NetworkResponse<APIResponse<_SearchPostsResponse_>>
}