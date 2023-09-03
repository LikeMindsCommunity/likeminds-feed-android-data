package com.likeminds.internalsdk.community

import com.likeminds.internalsdk.community.model._GetAllMembersRequest_
import com.likeminds.internalsdk.community.model._GetAllMembersResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface CommunityApi {

    // api to get all the members in the community
    suspend fun getAllMembers(
        request: _GetAllMembersRequest_
    ): NetworkResponse<APIResponse<_GetAllMembersResponse_>>
}