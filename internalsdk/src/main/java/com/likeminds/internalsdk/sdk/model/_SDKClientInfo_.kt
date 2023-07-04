package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

class _SDKClientInfo_ private constructor(
    @SerializedName("community")
    val community: Int,
    @SerializedName("user")
    val user: Int,
    @SerializedName("user_unique_id")
    val userUniqueId: String,
    @SerializedName("uuid")
    val uuid: String
) {

    class Builder {
        private var community: Int = 0
        private var user: Int = 0
        private var userUniqueId: String = ""
        private var uuid: String = ""

        fun community(community: Int) = apply { this.community = community }
        fun user(user: Int) = apply { this.user = user }
        fun userUniqueId(userUniqueId: String) = apply { this.userUniqueId = userUniqueId }
        fun uuid(uuid: String) = apply { this.uuid = uuid }

        fun build() = _SDKClientInfo_(community, user, userUniqueId, uuid)
    }

    fun toBuilder(): Builder {
        return Builder().community(community)
            .user(user)
            .userUniqueId(userUniqueId)
            .uuid(uuid)
    }
}