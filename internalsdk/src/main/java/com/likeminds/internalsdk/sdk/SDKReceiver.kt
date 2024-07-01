package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._LogoutRequest_
import com.likeminds.internalsdk.sdk.model._GetMemberStateResponse_
import com.likeminds.internalsdk.sdk.model._ValidateUserRequest_
import com.likeminds.internalsdk.sdk.model._ValidateUserResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.Header
import javax.inject.Inject

class SDKReceiver @Inject constructor(private val sdkNetworkApi: SDKNetworkApi) {

    suspend fun initiateUser(
        apiKey: String,
        request: _InitiateUserRequest_
    ): NetworkResponse<APIResponse<_InitiateUserResponse_>> {
        val newRequest = request.toBuilder().apiKey(null).build()
        return sdkNetworkApi.initiateUser(apiKey, newRequest)
    }

    suspend fun validateUser(): NetworkResponse<APIResponse<_ValidateUserResponse_>> {
        return sdkNetworkApi.validateUser()
    }

    suspend fun logout(
        request: _LogoutRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        val deviceId = request.deviceId ?: ""
        val newRequest = request.toBuilder().deviceId(null).build()
        return sdkNetworkApi.logout(deviceId, newRequest)
    }

    suspend fun getMemberState(): NetworkResponse<APIResponse<_GetMemberStateResponse_>> {
        return sdkNetworkApi.getMemberState()
    }
}