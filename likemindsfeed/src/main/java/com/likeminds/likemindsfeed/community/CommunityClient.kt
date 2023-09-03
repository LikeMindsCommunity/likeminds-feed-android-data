package com.likeminds.likemindsfeed.community

import com.likeminds.internalsdk.community.model._GetAllMembersRequest_
import com.likeminds.internalsdk.community.model._SearchMembersRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.community.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class CommunityClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().communityComponent()?.inject(this)
    }

    private val communityApi by lazy {
        collabmatesSDK.getCommunityApi()
    }

    companion object {
        @JvmStatic
        private var communityClient: CommunityClient? = null

        fun getInstance(): CommunityClient {
            if (communityClient == null) {
                communityClient = CommunityClient()
            }
            return communityClient!!
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getAllMembersRequest - client request model to fetch paginated community member
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return GetAllMembersResponse - GetAllMembersResponse model for getAllMembersRequest
     */
    suspend fun getAllMembers(getAllMembersRequest: GetAllMembersRequest): LMResponse<GetAllMembersResponse> {
        // validates the client request
        RequestUtils.validate()

        // builds internal request model
        val request = _GetAllMembersRequest_.Builder()
            .page(getAllMembersRequest.page)
            .build()

        // calls api and processes the response accordingly
        return when (val response = communityApi.getAllMembers(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                ModelConverter.convertGetAllMembersAPIResponse(response.body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param searchMembersRequest - client request model to search community members
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return SearchMembersResponse - SearchMembersResponse model for searchMembersRequest
     */
    suspend fun searchMember(searchMembersRequest: SearchMembersRequest): LMResponse<SearchMembersResponse> {
        // validates the client request
        RequestUtils.validate()
        validateSearchMembersRequest(searchMembersRequest)

        // builds internal request model
        val request = _SearchMembersRequest_.Builder()
            .page(searchMembersRequest.page)
            .pageSize(searchMembersRequest.pageSize)
            .search(searchMembersRequest.search)
            .build()

        // calls api and processes the response accordingly
        return when (val response = communityApi.searchMembers(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                ModelConverter.convertSearchMembersAPIResponse(response.body)
            }
        }
    }

    /**
     * validates [searchMembersRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateSearchMembersRequest(searchMembersRequest: SearchMembersRequest) {
        if (searchMembersRequest.search.isEmpty()) {
            RequestUtils.throwException("search")
        }
    }
}