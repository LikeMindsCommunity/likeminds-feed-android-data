package com.likeminds.likemindsfeed.branding

import com.likeminds.internalsdk.branding.model._BrandingRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.branding.model.BrandingResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import javax.inject.Inject

class BrandingClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
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

    /**
     * Converts client request model to internal model and calls the api
     * @param brandingRequest - client request model to fetch branding
     * @return BrandingResponse - client response model for brandingRequest
     */
    suspend fun getBranding(brandingRequest: BrandingRequest): BrandingResponse {
        // builds internal request model
        val request =
            _BrandingRequest_.Builder().communityId(brandingRequest.communityId)
                .build()
        val api = collabmatesSDK.getBrandingApi()
        // calls api and processes the response accordingly
        return when (val response = api.getBranding(request)) {
            is NetworkResponse.Error -> {
                BrandingResponse(
                    success = false,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body
                return ModelConverter.convertBrandingResponse(body)
            }
        }
    }
}