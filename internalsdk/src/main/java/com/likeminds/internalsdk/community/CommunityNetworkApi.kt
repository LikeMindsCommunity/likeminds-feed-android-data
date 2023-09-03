package com.likeminds.internalsdk.community

import com.likeminds.internalsdk.community.model._GetAllMembersResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CommunityNetworkApi {

    @GET("community/member")
    suspend fun getAllMembers(
        @Query("page") page: Int
    ): NetworkResponse<APIResponse<_GetAllMembersResponse_>>
}