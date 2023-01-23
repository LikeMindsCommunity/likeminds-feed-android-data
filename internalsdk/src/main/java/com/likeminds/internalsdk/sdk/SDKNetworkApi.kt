package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model.InitiateResponse
import com.likeminds.internalsdk.utils.retrofit.NetworkResponse
import retrofit2.http.POST

interface SDKNetworkApi {

    @POST("sdk/initiate")
    suspend fun initiateUser(): NetworkResponse<InitiateResponse>
}