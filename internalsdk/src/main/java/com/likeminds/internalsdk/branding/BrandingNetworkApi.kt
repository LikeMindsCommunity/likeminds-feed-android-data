package com.likeminds.internalsdk.branding

import com.likeminds.internalsdk.branding.model._BrandingResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BrandingNetworkApi {

    @GET("api/community/{community_id}/branding")
    suspend fun getBranding(
        @Path("community_id") communityId: String
    ): NetworkResponse<_BrandingResponse_>
}