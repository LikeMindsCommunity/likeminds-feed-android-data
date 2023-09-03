package com.likeminds.internalsdk.community

import com.likeminds.internalsdk.community.model._GetAllMembersResponse_
import com.likeminds.internalsdk.community.model._SearchMembersResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.*

interface CommunityNetworkApi {

    @GET("community/member")
    suspend fun getAllMembers(
        @Query("page") page: Int
    ): NetworkResponse<APIResponse<_GetAllMembersResponse_>>

    @GET("community/member/search")
    suspend fun searchMembers(
        @QueryMap queries: HashMap<String, Any>
    ): NetworkResponse<APIResponse<_SearchMembersResponse_>>
}