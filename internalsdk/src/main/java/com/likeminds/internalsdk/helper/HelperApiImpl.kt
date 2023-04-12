package com.likeminds.internalsdk.helper

import com.likeminds.internalsdk.helper.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class HelperApiImpl @Inject constructor(
    private val helperReceiver: HelperReceiver
) : HelperApi {

    override suspend fun decodeUrl(
        request: _DecodeUrlRequest_
    ): NetworkResponse<APIResponse<_DecodeUrlResponse_>> {
        return helperReceiver.decodeUrl(request)
    }

    override suspend fun registerDevice(
        request: _RegisterDeviceRequest_
    ): NetworkResponse<APIResponse<BaseResponse>> {
        return helperReceiver.registerDevice(request)
    }

    override suspend fun getTaggingList(
        request: _GetTaggingListRequest_
    ): NetworkResponse<APIResponse<_GetTaggingListResponse_>> {
        return helperReceiver.getTaggingList(request)
    }
}