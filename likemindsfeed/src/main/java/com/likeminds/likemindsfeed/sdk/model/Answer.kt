package com.likeminds.likemindsfeed.sdk.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Answer private constructor(
    val answer: String,
    val memberId: Int,
    val questionId: Int,
    val communityId: Int,
    val imageUrl: String?
) : Parcelable {
    class Builder {
        private var answer: String = ""
        private var memberId: Int = -1
        private var questionId: Int = -1
        private var communityId: Int = -1
        private var imageUrl: String? = null

        fun answer(answer: String) = apply { this.answer = answer }
        fun memberId(memberId: Int) = apply { this.memberId = memberId }
        fun questionId(questionId: Int) = apply { this.questionId = questionId }
        fun communityId(communityId: Int) = apply { this.communityId = communityId }
        fun imageUrl(imageUrl: String?) = apply { this.imageUrl = imageUrl }

        fun build() = Answer(
            answer,
            memberId,
            questionId,
            communityId,
            imageUrl
        )
    }

    fun toBuilder(): Builder {
        return Builder().answer(answer)
            .memberId(memberId)
            .questionId(questionId)
            .communityId(communityId)
            .imageUrl(imageUrl)
    }
}