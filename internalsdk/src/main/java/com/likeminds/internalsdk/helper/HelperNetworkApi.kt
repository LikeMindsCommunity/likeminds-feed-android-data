package com.likeminds.internalsdk.helper

import com.likeminds.internalsdk.helper.model._DecodeUrlResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HelperNetworkApi {

    @GET("helper/url")
    suspend fun decodeUrl(
        @Query("url") url: String,
    ): NetworkResponse<APIResponse<_DecodeUrlResponse_>>
}