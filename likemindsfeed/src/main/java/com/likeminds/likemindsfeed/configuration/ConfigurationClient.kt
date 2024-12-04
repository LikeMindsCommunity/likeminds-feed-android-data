package com.likeminds.likemindsfeed.configuration

import com.likeminds.internalsdk.configuration.model._Configuration_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.configuration.model.ConfigurationType
import com.likeminds.likemindsfeed.configuration.model.GetCommunityConfigurationRequest
import com.likeminds.likemindsfeed.configuration.model.GetCommunityConfigurationResponse
import com.likeminds.likemindsfeed.configuration.model.GetCommunityConfigurationsResponse
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

    private val configurationDao by lazy {
        feedSDK.getConfigurationDao()
    }

    private var postAsVariableValue: String? = null

    companion object {

        @JvmStatic
        private var configurationClient: ConfigurationClient? = null

        const val POST_KEY = "post"
        const val LIKE_ENTITY_VARIABLE_KEY = "like_entity_variable"
        const val COMMENT_KEY = "comment"

        fun getInstance(): ConfigurationClient {
            if (configurationClient == null) {
                configurationClient = ConfigurationClient()
            }

            return configurationClient!!
        }
    }

    /****
     * Calls the community configuration API and
     * convert internal response model to exposed response model
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return [GetCommunityConfigurationsResponse] - [GetCommunityConfigurationsResponse] model
     */
    suspend fun getCommunityConfigurations(): LMResponse<GetCommunityConfigurationsResponse> {
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
                val configurations = response.body.data?.configurations

                //update db
                configurations?.let {
                    insertConfigurations(it)
                }

                ModelConverter.convertGetCommunityConfigurationAPIResponse(response.body)
            }
        }
    }

    //inserts all the configuration from api response to db
    private suspend fun insertConfigurations(configurations: List<_Configuration_>) {
        val configurationEntities = ModelConverter.createConfigurationEntities(configurations)

        configurationDao.insertConfigurations(configurationEntities)
    }

    /**
     * Get the a single community configuration using type
     * Convert internal db model to exposed response model
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @param request: [GetCommunityConfigurationRequest] which have type of configuration
     * @return [GetCommunityConfigurationResponse] - [GetCommunityConfigurationResponse] model
     */
    suspend fun getCommunityConfiguration(request: GetCommunityConfigurationRequest): LMResponse<GetCommunityConfigurationResponse> {
        // validates the client request
        RequestUtils.validate()
        validateGetCommunityConfigurationRequest(request)

        val configuration = configurationDao.getConfiguration(request.type.value)

        return if (configuration == null) {
            LMResponse(
                success = false,
                errorMessage = "Community Configuration with respect to ${request.type.value} not found."
            )
        } else {
            ModelConverter.convertGetCommunityConfiguration(configuration)
        }
    }

    //validate the request of the [GetCommunityConfigurationRequest]
    private fun validateGetCommunityConfigurationRequest(request: GetCommunityConfigurationRequest) {
        if (request.type == ConfigurationType.NONE) {
            RequestUtils.throwException("type not mentioned")
        }
    }
}