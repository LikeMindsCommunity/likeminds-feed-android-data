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
    val isGuest: Boolean?
) {
    class Builder {
        private var apiKey: String? = null
        private var userName: String? = null
        private var uuid: String? = null
        private var isGuest: Boolean? = null

        fun apiKey(apiKey: String?) = apply { this.apiKey = apiKey }
        fun userName(userName: String?) = apply { this.userName = userName }
        fun uuid(uuid: String?) = apply { this.uuid = uuid }
        fun isGuest(isGuest: Boolean?) = apply { this.isGuest = isGuest }

        fun build() = _InitiateUserRequest_(
            apiKey,
            userName,
            uuid,
            isGuest
        )
    }

    fun toBuilder(): Builder {
        return Builder().isGuest(isGuest)
            .apiKey(apiKey)
            .uuid(uuid)
            .userName(userName)
    }
}