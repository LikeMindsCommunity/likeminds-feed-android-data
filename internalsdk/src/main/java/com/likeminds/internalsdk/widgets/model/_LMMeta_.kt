package com.likeminds.internalsdk.widgets.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._PollOption_

class _LMMeta_ private constructor(
    @SerializedName("options")
    val options: List<_PollOption_>?,
    @SerializedName("poll_answer_text")
    val pollAnswerText: String?,
    @SerializedName("to_show_results")
    val toShowResults: Boolean?
) {
    class Builder {
        private var options: List<_PollOption_>? = null
        private var pollAnswerText: String? = null
        private var toShowResults: Boolean? = null

        fun options(options: List<_PollOption_>?) = apply { this.options = options }
        fun pollAnswerText(pollAnswerText: String?) = apply { this.pollAnswerText = pollAnswerText }
        fun toShowResults(toShowResults: Boolean?) = apply { this.toShowResults = toShowResults }

        fun build() = _LMMeta_(
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