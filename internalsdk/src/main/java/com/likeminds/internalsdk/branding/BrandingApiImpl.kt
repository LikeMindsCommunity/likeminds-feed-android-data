package com.likeminds.internalsdk.branding

import com.likeminds.internalsdk.branding.model._BrandingRequest_
import com.likeminds.internalsdk.branding.model._BrandingResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class BrandingApiImpl @Inject constructor(
    private val brandingReceiver: BrandingReceiver
) : BrandingApi {
    override suspend fun branding(
        request: _BrandingRequest_
    ): NetworkResponse<_BrandingResponse_> {
        return brandingReceiver.getBranding(request)
    }
}