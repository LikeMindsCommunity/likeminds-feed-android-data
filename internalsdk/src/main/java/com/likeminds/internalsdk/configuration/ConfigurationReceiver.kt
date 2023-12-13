package com.likeminds.internalsdk.configuration

import com.likeminds.internalsdk.configuration.model._GetCommunityConfiguration_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class ConfigurationReceiver @Inject constructor(
    private val configurationNetworkApi: ConfigurationNetworkApi
) {

    suspend fun getCommunityConfiguration(): NetworkResponse<APIResponse<_GetCommunityConfiguration_>> {
        return configurationNetworkApi.getCommunityConfiguration()
    }
}