package com.likeminds.likemindsfeed.sdk.model

class User private constructor(
    val id: Int,
    val imageUrl: String,
    val isGuest: Boolean,
    val name: String,
    val organisationName: String?,
    val sdkClientInfo: SDKClientInfo,
    val isDeleted: Boolean?,
    val customTitle: String?,
    val updatedAt: Long,
    val userUniqueId: String,
    val uuid: String,
    val state: Int,
    val customIntroText: String?,
    val memberSince: String?,
    val questionAnswers: List<QuestionAnswer>?
) {
    class Builder {
        private var id: Int = 0
        private var imageUrl: String = ""
        private var isGuest: Boolean = false
        private var name: String = ""
        private var organisationName: String? = null
        private var sdkClientInfo: SDKClientInfo = SDKClientInfo.Builder().build()
        private var isDeleted: Boolean? = null
        private var customTitle: String? = ""
        private var updatedAt: Long = 0L
        private var userUniqueId: String = ""
        private var uuid: String = ""
        private var state: Int = 1
        private var customIntroText: String? = null
        private var memberSince: String? = null
        private var questionAnswers: List<QuestionAnswer>? = null

        fun id(id: Int) = apply { this.id = id }
        fun imageUrl(imageUrl: String) = apply { this.imageUrl = imageUrl }
        fun isGuest(isGuest: Boolean) = apply { this.isGuest = isGuest }
        fun name(name: String) = apply { this.name = name }
        fun organisationName(organisationName: String?) =
            apply { this.organisationName = organisationName }

        fun sdkClientInfo(sdkClientInfo: SDKClientInfo) =
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
        fun questionAnswers(questionAnswers: List<QuestionAnswer>?) =
            apply { this.questionAnswers = questionAnswers }

        fun build() = User(
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