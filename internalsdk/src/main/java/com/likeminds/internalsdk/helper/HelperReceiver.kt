package com.likeminds.internalsdk.helper

import com.likeminds.internalsdk.helper.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class HelperReceiver @Inject constructor(
    private val helperNetworkApi: HelperNetworkApi
) {
    suspend fun decodeUrl(
        request: _DecodeUrlRequest_
    ): NetworkResponse<APIResponse<_DecodeUrlResponse_>> {
        return helperNetworkApi.decodeUrl(request.url)
    }

    suspend fun registerDevice(request: _RegisterDeviceRequest_): NetworkResponse<APIResponse<BaseResponse>> {
        val deviceId = request.deviceId ?: ""
        val newRequest = request.toBuilder().deviceId(null)
            .build()
        return helperNetworkApi.registerDevice(deviceId, newRequest)
    }

    suspend fun getTaggingList(
        request: _GetTaggingListRequest_
    ): NetworkResponse<APIResponse<_GetTaggingListResponse_>> {
        return helperNetworkApi.getTaggingList(
            request.page,
            request.pageSize,
            request.searchName,
        )
    }
}