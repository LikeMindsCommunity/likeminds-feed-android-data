package com.likeminds.internalsdk.helper

import com.likeminds.internalsdk.helper.model._DecodeUrlRequest_
import com.likeminds.internalsdk.helper.model._DecodeUrlResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
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
}