package com.likeminds.likemindsfeed.branding.model

data class BrandingResponse(
    var success: Boolean,
    var errorMessage: String?,
    var branding: Branding? = null,
)

data class Branding(
    val basic: BrandingBasic? = null,
    val advanced: BrandingAdvanced? = null
)