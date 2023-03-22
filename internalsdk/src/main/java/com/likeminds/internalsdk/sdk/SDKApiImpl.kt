package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._LogoutRequest_
import com.likeminds.internalsdk.sdk.model._MemberStateResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class SDKApiImpl @Inject constructor(private val sdkReceiver: SDKReceiver) : SDKApi {
    override suspend fun initiateUser(
        apiKey: String,
        request: _InitiateUserRequest_
    ): NetworkResponse<APIResponse<_InitiateUserResponse_>> {
        return sdkReceiver.initiateUser(apiKey, request)
    }

    override suspend fun logout(
        request: _LogoutRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return sdkReceiver.logout(request)
    }

    override suspend fun getMemberState(): NetworkResponse<APIResponse<_MemberStateResponse_>> {
        return sdkReceiver.getMemberState()
    }
}