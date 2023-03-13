package com.likeminds.internalsdk.branding.model

import com.google.gson.annotations.SerializedName

class _BrandingRequest_ private constructor(
    @SerializedName("community_id")
    var communityId: String
) {

    class Builder {
        private var communityId: String = ""

        fun communityId(communityId: String) = apply { this.communityId = communityId }

        fun build() = _BrandingRequest_(communityId)
    }

    fun toBuilder(): Builder {
        return Builder().communityId(communityId)
    }
}