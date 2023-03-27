package com.likeminds.internalsdk.helper

import com.likeminds.internalsdk.helper.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface HelperApi {

    // api to fetch ogTags of url
    suspend fun decodeUrl(
        request: _DecodeUrlRequest_
    ): NetworkResponse<APIResponse<_DecodeUrlResponse_>>

    //api to register device id and fcm token for the user
    suspend fun registerDevice(request: _RegisterDeviceRequest_): NetworkResponse<APIResponse<BaseResponse>>

    //api to fetch taggingList
    suspend fun getTaggingList(
        request: _GetTaggingListRequest_
    ): NetworkResponse<APIResponse<_GetTaggingListResponse_>>
}