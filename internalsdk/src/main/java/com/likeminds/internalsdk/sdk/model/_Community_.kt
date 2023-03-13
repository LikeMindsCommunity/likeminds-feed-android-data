package com.likeminds.internalsdk.sdk.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class _Community_ private constructor(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("members_count")
    var membersCount: Int?,
    @SerializedName("updated_at")
    var updatedAt: String?
) : Parcelable {

    class Builder {
        private var id: String = ""
        private var name: String = ""
        private var imageUrl: String? = null
        private var membersCount: Int? = null
        private var updatedAt: String? = null

        fun id(id: String) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun imageUrl(imageUrl: String?) = apply { this.imageUrl = imageUrl }
        fun membersCount(membersCount: Int?) = apply { this.membersCount = membersCount }
        fun updatedAt(updatedAt: String?) = apply { this.updatedAt = updatedAt }

        //
        fun build() = _Community_(
            id,
            name,
            imageUrl,
            membersCount,
            updatedAt
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .name(name)
            .imageUrl(imageUrl)
            .updatedAt(updatedAt)
    }
}