package com.likeminds.internalsdk.sdk.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class User private constructor(
    @SerializedName("id")
    var id: String,
    @SerializedName("image_url")
    var imageUrl: String,
    @SerializedName("is_guest")
    var isGuest: Boolean,
    @SerializedName("name")
    var name: String,
    @SerializedName("organisation_name")
    var organisationName: String?,
    @SerializedName("sdk_client_info")
    var sdkClientInfo: SDKClientInfo?,
    @SerializedName("updated_at")
    var updatedAt: Long,
    @SerializedName("user_unique_id")
    var userUniqueId: String
) {
    class Builder {
        private var id: String = ""
        private var imageUrl: String = ""
        private var isGuest: Boolean = false
        private var name: String = ""
        private var organisationName: String? = null
        private var sdkClientInfo: SDKClientInfo? = null
        private var updatedAt: Long = 0L
        private var userUniqueId: String = ""

        fun id(id: String) = apply { this.id = id }
        fun imageUrl(imageUrl: String) = apply { this.imageUrl = imageUrl }
        fun isGuest(isGuest: Boolean) = apply { this.isGuest = isGuest }
        fun name(name: String) = apply { this.name = name }
        fun organisationName(organisationName: String?) =
            apply { this.organisationName = organisationName }

        fun sdkClientInfo(sdkClientInfo: SDKClientInfo?) =
            apply { this.sdkClientInfo = sdkClientInfo }

        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun userUniqueId(userUniqueId: String) = apply { this.userUniqueId = userUniqueId }

        fun build() = User(
            id,
            imageUrl,
            isGuest,
            name,
            organisationName,
            sdkClientInfo,
            updatedAt,
            userUniqueId
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .imageUrl(imageUrl)
            .isGuest(isGuest)
            .name(name)
            .organisationName(organisationName)
            .sdkClientInfo(sdkClientInfo)
            .updatedAt(updatedAt)
            .userUniqueId(userUniqueId)
    }
}

@Keep
data class SDKClientInfo(
    @SerializedName("community")
    var community: Int,
    @SerializedName("user")
    var user: Int,
    @SerializedName("user_unique_id")
    var userUniqueId: String
)
