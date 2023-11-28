package com.likeminds.likemindsfeed.configuration

import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.configuration.model.GetCommunityConfiguration
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class ConfigurationClient @Inject constructor() : BaseClient() {
    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().configurationComponent()?.inject(this)
    }

    private val configurationApi by lazy {
        feedSDK.getConfigurationApi()
    }

    companion object {

        @JvmStatic
        private var configurationClient: ConfigurationClient? = null

        fun getInstance(): ConfigurationClient {
            if (configurationClient == null) {
                configurationClient = ConfigurationClient()
            }

            return configurationClient!!
        }
    }

    /****
     * Calls the APIs
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return [GetCommunityConfiguration] - [GetCommunityConfiguration] model
     */
    suspend fun getCommunityConfiguration(): LMResponse<GetCommunityConfiguration> {
        // validates the client request
        RequestUtils.validate()

        return when (val response = configurationApi.getCommunityConfiguration()) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                ModelConverter.convertGetCommunityConfigurationAPIResponse(response.body)
            }
        }
    }
}