package com.likeminds.likemindsfeed.branding

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.branding.model._BrandingRequest_
import com.likeminds.internalsdk.sdk.SDKPreferences
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.branding.model.BrandingResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import javax.inject.Inject

class BrandingClient @Inject constructor() {

    init {
        attachDagger()
    }

    @Inject
    lateinit var sdkPreferences: SDKPreferences

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    private fun attachDagger() {
        LikeMindsFeedApplication.getInstance().brandingComponent()?.inject(this)
    }

    companion object {
        @JvmStatic
        private var brandingClient: BrandingClient? = null

        fun getInstance(): BrandingClient {
            if (brandingClient == null) {
                brandingClient = BrandingClient()
            }
            return brandingClient!!
        }
    }

    suspend fun getBranding(brandingRequest: BrandingRequest): BrandingResponse? {
        val request =
            _BrandingRequest_.Builder().communityId(brandingRequest.communityId)
                .build()
        val api = collabmatesSDK.getBrandingApi()
        return when (val response = api.branding(request)) {
            is NetworkResponse.Error -> {
                null
            }
            is NetworkResponse.Success -> {
                val body = response.body
                return ModelConverter.convertBrandingResponse(body)
            }
        }
    }
}