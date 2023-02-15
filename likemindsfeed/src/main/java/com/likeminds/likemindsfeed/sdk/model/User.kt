package com.likeminds.likemindsfeed.sdk.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

data class User (
    var id: String,
    var imageUrl: String,
    var isGuest: Boolean,
    var name: String,
    var organisationName: String?,
    var sdkClientInfo: SDKClientInfo?,
    var updatedAt: Long,
    var userUniqueId: String
)

data class SDKClientInfo(
    @SerializedName("community")
    var community: Int,
    @SerializedName("user")
    var user: Int,
    @SerializedName("user_unique_id")
    var userUniqueId: String
)
