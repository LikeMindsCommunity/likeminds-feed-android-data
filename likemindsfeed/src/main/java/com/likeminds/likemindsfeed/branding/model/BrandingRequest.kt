package com.likeminds.likemindsfeed.branding.model

class BrandingRequest private constructor(
    var communityId: String
) {
    class Builder {
        private var communityId: String = ""

        fun communityId(communityId: String) = apply { this.communityId = communityId }

        fun build() = BrandingRequest(communityId)
    }

    fun toBuilder(): Builder {
        return Builder().communityId(communityId)
    }
}