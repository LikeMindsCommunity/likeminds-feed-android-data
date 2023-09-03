package com.likeminds.internalsdk.community

import com.likeminds.internalsdk.community.model.*
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

    suspend fun searchMembers(
        request: _SearchMembersRequest_
    ): NetworkResponse<APIResponse<_SearchMembersResponse_>> {
        val queries = HashMap<String, Any>()
        queries["page"] = request.page
        queries["page_size"] = request.pageSize
        queries["search"] = request.search
        queries["search_type"] = request.searchType

        return communityNetworkApi.searchMembers(queries)
    }
}