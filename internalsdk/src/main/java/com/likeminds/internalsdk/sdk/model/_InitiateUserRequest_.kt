package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

class _InitiateUserRequest_ private constructor(
    @SerializedName("user_name")
    var userName: String?,
    @SerializedName("user_unique_id")
    var userId: String?,
    @SerializedName("is_guest")
    var isGuest: Boolean?
) {
    class Builder {
        private var userName: String? = ""
        private var userId: String? = null
        private var isGuest: Boolean? = null

        fun userName(userName: String?) = apply { this.userName = userName }
        fun userId(userId: String?) = apply { this.userId = userId }
        fun isGuest(isGuest: Boolean?) = apply { this.isGuest = isGuest }

        fun build() = _InitiateUserRequest_(userName, userId, isGuest)
    }

    fun toBuilder():Builder{
        return Builder().isGuest(isGuest)
            .userId(userId)
            .userName(userName)
    }
}