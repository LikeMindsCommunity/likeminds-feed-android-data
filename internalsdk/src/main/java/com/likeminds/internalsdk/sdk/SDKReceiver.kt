package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._LogoutRequest_
import com.likeminds.internalsdk.sdk.model._MemberStateResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class SDKReceiver @Inject constructor(private val sdkNetworkApi: SDKNetworkApi) {

    suspend fun initiateUser(
        apiKey: String,
        request: _InitiateUserRequest_
    ): NetworkResponse<APIResponse<_InitiateUserResponse_>> {
        val newRequest = request.toBuilder().apiKey(null).build()
        return sdkNetworkApi.initiateUser(apiKey, newRequest)
    }

    suspend fun logout(
        request: _LogoutRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        val deviceId = request.deviceId ?: ""
        val newRequest = request.toBuilder().deviceId(null).build()
        return sdkNetworkApi.logout(deviceId, newRequest)
    }

    suspend fun getMemberState(): NetworkResponse<APIResponse<_MemberStateResponse_>> {
        return sdkNetworkApi.getMemberState()
    }
}