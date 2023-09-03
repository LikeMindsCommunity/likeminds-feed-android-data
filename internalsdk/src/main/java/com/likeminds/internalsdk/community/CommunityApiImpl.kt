package com.likeminds.internalsdk.community

import com.likeminds.internalsdk.community.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class CommunityApiImpl @Inject constructor(
    private val communityReceiver: CommunityReceiver
) : CommunityApi {

    override suspend fun getAllMembers(
        request: _GetAllMembersRequest_
    ): NetworkResponse<APIResponse<_GetAllMembersResponse_>> {
        return communityReceiver.getAllMembers(request)
    }

    override suspend fun searchMembers(
        request: _SearchMembersRequest_
    ): NetworkResponse<APIResponse<_SearchMembersResponse_>> {
        return communityReceiver.searchMembers(request)
    }
}