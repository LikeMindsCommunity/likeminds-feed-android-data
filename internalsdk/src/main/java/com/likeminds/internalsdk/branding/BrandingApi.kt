package com.likeminds.internalsdk.branding

import com.likeminds.internalsdk.branding.model._BrandingRequest_
import com.likeminds.internalsdk.branding.model._BrandingResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface BrandingApi {

    // api to fetch branding data
    suspend fun getBranding(
        request: _BrandingRequest_
    ): NetworkResponse<_BrandingResponse_>
}