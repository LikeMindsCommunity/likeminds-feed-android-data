package com.likeminds.internalsdk.sdk.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
class _Community_ private constructor(
    var id: String,
    var name: String,
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("members_count")
    var membersCount: Int?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("created_by")
    var createdBy: String?,
    @SerializedName("managed_by")
    var managedBy: String?,
    @SerializedName("menu")
    var menu: List<String>?
) : Parcelable {

    class Builder {
        private var id: String = ""
        private var name: String = ""
        private var imageUrl: String? = null
        private var membersCount: Int? = null
        private var updatedAt: String? = null
        private var createdBy: String? = null
        private var managedBy: String? = null
        private var menu: List<String>? = null

        fun id(id: String) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun imageUrl(imageUrl: String?) = apply { this.imageUrl = imageUrl }
        fun membersCount(membersCount: Int?) = apply { this.membersCount = membersCount }
        fun updatedAt(updatedAt: String?) = apply { this.updatedAt = updatedAt }
        fun createdBy(createdBy: String?) = apply { this.createdBy = createdBy }
        fun managedBy(managedBy: String?) = apply { this.managedBy = managedBy }
        fun menu(menu: List<String>?) = apply { this.menu = menu }

        //
        fun build() = _Community_(
            id,
            name,
            imageUrl,
            membersCount,
            updatedAt,
            createdBy,
            managedBy,
            menu,
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .name(name)
            .imageUrl(imageUrl)
            .updatedAt(updatedAt)
            .createdBy(createdBy)
            .managedBy(managedBy)
    }
}