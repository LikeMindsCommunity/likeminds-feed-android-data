package com.likeminds.internalsdk.helper

import com.likeminds.internalsdk.helper.model._DecodeUrlResponse_
import com.likeminds.internalsdk.helper.model._RegisterDeviceRequest_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.*

interface HelperNetworkApi {
    @GET("helper/url")
    suspend fun decodeUrl(
        @Query("url") url: String,
    ): NetworkResponse<APIResponse<_DecodeUrlResponse_>>

    @POST("user/device/push")
    suspend fun registerDevice(
        @Header("x-device_id") deviceId: String,
        @Body request: _RegisterDeviceRequest_
    ): NetworkResponse<APIResponse<BaseResponse>>
}