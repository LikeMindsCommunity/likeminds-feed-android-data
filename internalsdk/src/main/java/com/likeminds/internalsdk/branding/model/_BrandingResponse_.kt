package com.likeminds.internalsdk.branding.model

import com.google.gson.annotations.SerializedName

data class _BrandingResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var branding: _Branding_?,
)

data class _Branding_(
    @SerializedName("basic")
    val basic: _BrandingBasic_? = null,
    @SerializedName("advanced")
    val advanced: _BrandingAdvanced_? = null
)