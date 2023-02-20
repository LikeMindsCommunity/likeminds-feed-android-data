package com.likeminds.internalsdk.branding.model

import com.google.gson.annotations.SerializedName

data class _BrandingAdvanced_(
    @SerializedName("header_colour")
    val headerColor: String? = null,
    @SerializedName("buttons_icons_colour")
    val buttonsIconsColor: String? = null,
    @SerializedName("text_links_colour")
    val textLinksColor: String? = null
)