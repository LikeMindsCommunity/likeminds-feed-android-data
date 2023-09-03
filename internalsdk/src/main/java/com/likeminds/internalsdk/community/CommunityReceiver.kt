package com.likeminds.internalsdk.community

import com.likeminds.internalsdk.community.model._GetAllMembersRequest_
import com.likeminds.internalsdk.community.model._GetAllMembersResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class CommunityReceiver @Inject constructor(
    private val communityNetworkApi: CommunityNetworkApi
) {
    suspend fun getAllMembers(
        request: _GetAllMembersRequest_
    ): NetworkResponse<APIResponse<_GetAllMembersResponse_>> {
        return communityNetworkApi.getAllMembers(request.page)
    }
}