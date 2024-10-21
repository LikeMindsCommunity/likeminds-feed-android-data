package com.likeminds.internalsdk.search

import com.likeminds.internalsdk.search.model._SearchPostsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface SearchNetworkApi {

    @GET("search/post")
    suspend fun searchPosts(
        @QueryMap queries: HashMap<String, Any?>
    ):NetworkResponse<APIResponse<_SearchPostsResponse_>>
}