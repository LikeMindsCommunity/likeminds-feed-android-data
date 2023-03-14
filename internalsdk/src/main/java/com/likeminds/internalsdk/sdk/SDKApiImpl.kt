package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponseData_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class SDKApiImpl @Inject constructor(private val sdkReceiver: SDKReceiver) : SDKApi {
    override suspend fun initiate(
        apiKey: String,
        request: _InitiateUserRequest_
    ): NetworkResponse<APIResponse<_InitiateUserResponseData_>> {
        return sdkReceiver.initiateUser(apiKey, request)
    }
}