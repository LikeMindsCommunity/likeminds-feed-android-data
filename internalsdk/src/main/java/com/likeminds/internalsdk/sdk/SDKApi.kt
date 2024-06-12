package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._LogoutRequest_
import com.likeminds.internalsdk.sdk.model._GetMemberStateResponse_
import com.likeminds.internalsdk.sdk.model._ValidateUserRequest_
import com.likeminds.internalsdk.sdk.model._ValidateUserResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface SDKApi {

    // api to initiate user
    suspend fun initiateUser(
        apiKey: String,
        request: _InitiateUserRequest_,
    ): NetworkResponse<APIResponse<_InitiateUserResponse_>>

    // api to validate user
    suspend fun validateUser(
        request: _ValidateUserRequest_
    ): NetworkResponse<APIResponse<_ValidateUserResponse_>>

    // api to logout user
    suspend fun logout(
        request: _LogoutRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to fetch member state
    suspend fun getMemberState(): NetworkResponse<APIResponse<_GetMemberStateResponse_>>
}