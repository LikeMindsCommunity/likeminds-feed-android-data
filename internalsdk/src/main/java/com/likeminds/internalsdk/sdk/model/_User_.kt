package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

class _User_ private constructor(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("is_guest")
    val isGuest: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("organisation_name")
    val organisationName: String?,
    @SerializedName("sdk_client_info")
    val sdkClientInfo: _SDKClientInfo_?,
    @SerializedName("is_deleted")
    val isDeleted: Boolean?,
    @SerializedName("custom_title")
    val customTitle: String?,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("user_unique_id")
    val userUniqueId: String,
    @SerializedName("uuid")
    val uuid: String
) {
    class Builder {
        private var id: Int = 0
        private var imageUrl: String = ""
        private var isGuest: Boolean = false
        private var name: String = ""
        private var organisationName: String? = null
        private var sdkClientInfo: _SDKClientInfo_? = null
        private var isDeleted: Boolean? = null
        private var customTitle: String? = null
        private var updatedAt: Long = 0L
        private var userUniqueId: String = ""
        private var uuid: String = ""
        fun id(id: Int) = apply { this.id = id }
        fun imageUrl(imageUrl: String) = apply { this.imageUrl = imageUrl }
        fun isGuest(isGuest: Boolean) = apply { this.isGuest = isGuest }
        fun name(name: String) = apply { this.name = name }
        fun organisationName(organisationName: String?) =
            apply { this.organisationName = organisationName }

        fun sdkClientInfo(sdkClientInfo: _SDKClientInfo_?) =
            apply { this.sdkClientInfo = sdkClientInfo }

        fun isDeleted(isDeleted: Boolean?) = apply { this.isDeleted = isDeleted }
        fun customTitle(customTitle: String?) = apply { this.customTitle = customTitle }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun userUniqueId(userUniqueId: String) = apply { this.userUniqueId = userUniqueId }
        fun uuid(uuid: String) = apply { this.uuid = uuid }

        fun build() = _User_(
            id,
            imageUrl,
            isGuest,
            name,
            organisationName,
            sdkClientInfo,
            isDeleted,
            customTitle,
            updatedAt,
            userUniqueId,
            uuid
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .imageUrl(imageUrl)
            .isGuest(isGuest)
            .name(name)
            .organisationName(organisationName)
            .sdkClientInfo(sdkClientInfo)
            .isDeleted(isDeleted)
            .customTitle(customTitle)
            .updatedAt(updatedAt)
            .userUniqueId(userUniqueId)
            .uuid(uuid)
    }
}
