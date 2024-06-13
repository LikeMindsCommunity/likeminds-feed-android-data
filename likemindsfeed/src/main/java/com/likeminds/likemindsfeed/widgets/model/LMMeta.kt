package com.likeminds.likemindsfeed.widgets.model

import com.likeminds.likemindsfeed.post.model.PollOption

class LMMeta private constructor(
    val options: List<PollOption>?,
    val pollAnswerText: String?,
    val toShowResults: Boolean?
) {
    class Builder {
        private var options: List<PollOption>? = null
        private var pollAnswerText: String? = null
        private var toShowResults: Boolean? = null

        fun options(options: List<PollOption>?) = apply { this.options = options }
        fun pollAnswerText(pollAnswerText: String?) = apply { this.pollAnswerText = pollAnswerText }
        fun toShowResults(toShowResults: Boolean?) = apply { this.toShowResults = toShowResults }

        fun build() = LMMeta(
            options,
            pollAnswerText,
            toShowResults
        )
    }

    fun toBuilder(): Builder {
        return Builder().options(options)
            .pollAnswerText(pollAnswerText)
            .toShowResults(toShowResults)
    }
}