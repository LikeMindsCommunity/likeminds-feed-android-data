package com.likeminds.internalsdk.configuration

import com.likeminds.internalsdk.configuration.model._GetCommunityConfiguration_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface ConfigurationApi {

    //api to get all community configuration
    suspend fun getCommunityConfiguration(): NetworkResponse<APIResponse<_GetCommunityConfiguration_>>
}