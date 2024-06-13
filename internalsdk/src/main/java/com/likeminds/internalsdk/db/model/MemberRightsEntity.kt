package com.likeminds.internalsdk.db.model

import androidx.room.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Entity(tableName = LMFeedDbConstants.MEMBER_RIGHTS_TABLE, primaryKeys = ["user_unique_id", "id"])
class MemberRightsEntity(
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "is_locked", defaultValue = "0")
    val isLocked: Boolean?,
    @ColumnInfo(name = "is_selected", defaultValue = "1")
    val isSelected: Boolean,
    @ColumnInfo(name = "state")
    val state: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "subtitle")
    val subtitle: String?,
    @ColumnInfo(name = "user_unique_id")
    var userUniqueId: String
) {
    class Builder {
        private var id: Int = 0
        private var isLocked: Boolean? = null
        private var isSelected: Boolean = true
        private var state: Int = -1
        private var title: String = ""
        private var subtitle: String? = null
        private var userUniqueId: String = ""

        fun id(id: Int) = apply { this.id = id }
        fun isLocked(isLocked: Boolean?) = apply { this.isLocked = isLocked }
        fun isSelected(isSelected: Boolean) = apply { this.isSelected = isSelected }
        fun state(state: Int) = apply { this.state = state }
        fun title(title: String) = apply { this.title = title }
        fun subtitle(subtitle: String?) = apply { this.subtitle = subtitle }
        fun userUniqueId(userUniqueId: String) = apply { this.userUniqueId = userUniqueId }

        fun build() = MemberRightsEntity(
            id,
            isLocked,
            isSelected,
            state,
            title,
            subtitle,
            userUniqueId
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .isLocked(isLocked)
            .isSelected(isSelected)
            .state(state)
            .title(title)
            .subtitle(subtitle)
            .userUniqueId(userUniqueId)
    }
}