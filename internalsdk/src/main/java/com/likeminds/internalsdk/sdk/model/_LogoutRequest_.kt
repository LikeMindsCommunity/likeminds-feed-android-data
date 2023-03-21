package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

class _LogoutRequest_ private constructor(
    @SerializedName("refresh_token")
    var refreshToken: String
) {

    class Builder {

        private var refreshToken: String = ""

        fun refreshToken(refreshToken: String) = apply { this.refreshToken = refreshToken }

        fun build() = _LogoutRequest_(refreshToken)
    }

    fun toBuilder(): Builder {
        return Builder().refreshToken(refreshToken)
    }
}