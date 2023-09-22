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
    val sdkClientInfo: _SDKClientInfo_,
    @SerializedName("is_deleted")
    val isDeleted: Boolean?,
    @SerializedName("custom_title")
    val customTitle: String?,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("user_unique_id")
    val userUniqueId: String,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("state")
    val state: Int,
    @SerializedName("custom_intro_text")
    val customIntroText: String?,
    @SerializedName("member_since")
    val memberSince: String?,
    @SerializedName("question_answers")
    val questionAnswers: List<_QuestionAnswer_>?
) {
    class Builder {
        private var id: Int = 0
        private var imageUrl: String = ""
        private var isGuest: Boolean = false
        private var name: String = ""
        private var organisationName: String? = null
        private var sdkClientInfo: _SDKClientInfo_ = _SDKClientInfo_.Builder().build()
        private var isDeleted: Boolean? = null
        private var customTitle: String? = null
        private var updatedAt: Long = 0L
        private var userUniqueId: String = ""
        private var uuid: String = ""
        private var state: Int = 1
        private var customIntroText: String? = null
        private var memberSince: String? = null
        private var questionAnswers: List<_QuestionAnswer_>? = null

        fun id(id: Int) = apply { this.id = id }
        fun imageUrl(imageUrl: String) = apply { this.imageUrl = imageUrl }
        fun isGuest(isGuest: Boolean) = apply { this.isGuest = isGuest }
        fun name(name: String) = apply { this.name = name }
        fun organisationName(organisationName: String?) =
            apply { this.organisationName = organisationName }

        fun sdkClientInfo(sdkClientInfo: _SDKClientInfo_) =
            apply { this.sdkClientInfo = sdkClientInfo }

        fun isDeleted(isDeleted: Boolean?) = apply { this.isDeleted = isDeleted }
        fun customTitle(customTitle: String?) = apply { this.customTitle = customTitle }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun userUniqueId(userUniqueId: String) = apply { this.userUniqueId = userUniqueId }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun state(state: Int) = apply { this.state = state }
        fun customIntroText(customIntroText: String?) =
            apply { this.customIntroText = customIntroText }

        fun memberSince(memberSince: String?) = apply { this.memberSince = memberSince }
        fun questionAnswers(questionAnswers: List<_QuestionAnswer_>?) =
            apply { this.questionAnswers = questionAnswers }

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
            uuid,
            state,
            customIntroText,
            memberSince,
            questionAnswers
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
            .state(state)
            .customIntroText(customIntroText)
            .memberSince(memberSince)
            .questionAnswers(questionAnswers)
    }
}
