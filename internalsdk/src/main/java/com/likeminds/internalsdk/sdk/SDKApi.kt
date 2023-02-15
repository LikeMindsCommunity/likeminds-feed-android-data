package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface SDKApi {
    suspend fun initiate(
        apiKey: String,
        request: _InitiateUserRequest_,
    ): NetworkResponse<_InitiateUserResponse_>
}