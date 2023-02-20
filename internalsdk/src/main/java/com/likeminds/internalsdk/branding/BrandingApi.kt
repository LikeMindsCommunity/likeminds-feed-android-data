package com.likeminds.internalsdk.branding

import com.likeminds.internalsdk.branding.model._BrandingRequest_
import com.likeminds.internalsdk.branding.model._BrandingResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface BrandingApi {

    suspend fun branding(
        request: _BrandingRequest_
    ): NetworkResponse<_BrandingResponse_>
}