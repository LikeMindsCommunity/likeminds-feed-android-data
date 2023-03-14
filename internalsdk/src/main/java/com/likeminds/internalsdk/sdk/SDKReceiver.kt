package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponseData_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class SDKReceiver @Inject constructor(private val sdkNetworkApi: SDKNetworkApi) {

    suspend fun initiateUser(
        apiKey: String,
        request: _InitiateUserRequest_
    ): NetworkResponse<APIResponse<_InitiateUserResponseData_>> {
        return sdkNetworkApi.initiate(apiKey, request)
    }
}