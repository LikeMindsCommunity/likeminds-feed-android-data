package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

class _InitiateUserRequest_ private constructor(
    @SerializedName("api_key")
    val apiKey: String?,
    @SerializedName("user_name")
    val userName: String?,
    @SerializedName("uuid")
    val uuid: String?,
    @SerializedName("is_guest")
    val isGuest: Boolean?,
    @SerializedName("token_expiry_beta")
    val tokenExpiryBeta: Int?,
    @SerializedName("rtm_token_expiry_beta")
    val rtmTokenExpiryBeta: Int?
) {
    class Builder {
        private var apiKey: String? = null
        private var userName: String? = null
        private var uuid: String? = null
        private var isGuest: Boolean? = null
        private var tokenExpiryBeta: Int? = null
        private var rtmTokenExpiryBeta: Int? = null

        fun apiKey(apiKey: String?) = apply { this.apiKey = apiKey }
        fun userName(userName: String?) = apply { this.userName = userName }
        fun uuid(uuid: String?) = apply { this.uuid = uuid }
        fun isGuest(isGuest: Boolean?) = apply { this.isGuest = isGuest }
        fun tokenExpiryBeta(tokenExpiryBeta: Int?) =
            apply { this.tokenExpiryBeta = tokenExpiryBeta }

        fun rtmTokenExpiryBeta(rtmTokenExpiryBeta: Int?) =
            apply { this.rtmTokenExpiryBeta = rtmTokenExpiryBeta }

        fun build() = _InitiateUserRequest_(
            apiKey,
            userName,
            uuid,
            isGuest,
            tokenExpiryBeta,
            rtmTokenExpiryBeta
        )
    }

    fun toBuilder(): Builder {
        return Builder().isGuest(isGuest)
            .apiKey(apiKey)
            .uuid(uuid)
            .userName(userName)
            .tokenExpiryBeta(tokenExpiryBeta)
            .rtmTokenExpiryBeta(rtmTokenExpiryBeta)
    }
}