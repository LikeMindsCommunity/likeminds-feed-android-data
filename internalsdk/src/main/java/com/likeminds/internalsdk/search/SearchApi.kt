package com.likeminds.internalsdk.search

import com.likeminds.internalsdk.search.model._GetSearchPostsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse


// INCOMPLETE
interface SearchApi {
    suspend fun searchPosts(): NetworkResponse<APIResponse<_GetSearchPostsResponse_>>
}