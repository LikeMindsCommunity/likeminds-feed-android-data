package com.likeminds.internalsdk.branding

import com.likeminds.internalsdk.branding.model._BrandingRequest_
import com.likeminds.internalsdk.branding.model._BrandingResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class BrandingReceiver @Inject constructor(
    private val brandingNetworkApi: BrandingNetworkApi
) {
    suspend fun getBranding(request: _BrandingRequest_): NetworkResponse<_BrandingResponse_> {
        return brandingNetworkApi.getBranding(
            request.communityId
        )
    }
}