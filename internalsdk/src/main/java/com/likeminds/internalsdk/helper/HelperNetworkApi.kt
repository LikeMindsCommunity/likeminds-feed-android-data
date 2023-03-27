package com.likeminds.internalsdk.helper

import com.likeminds.internalsdk.helper.model._DecodeUrlResponse_
import com.likeminds.internalsdk.helper.model._GetTaggingListResponse_
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
        @Header("x-device-id") deviceId: String,
        @Body request: _RegisterDeviceRequest_
    ): NetworkResponse<APIResponse<BaseResponse>>

    @GET("community/tag")
    suspend fun getTaggingList(
        @Query("page") page: Int?,
        @Query("page") pageSize: Int?,
        @Query("searchName") searchName: String?,
    ): NetworkResponse<APIResponse<_GetTaggingListResponse_>>
}