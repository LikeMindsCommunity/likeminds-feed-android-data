package com.likeminds.likemindsfeed.poll.util

import com.likeminds.likemindsfeed.post.model.PollMultiSelectState
import com.likeminds.likemindsfeed.post.model.PollType

object PollUtil {
    fun String.getPollMultiSelectState(): PollMultiSelectState {
        return when (this) {
            PollMultiSelectState.EXACTLY.value -> PollMultiSelectState.EXACTLY
            PollMultiSelectState.AT_MAX.value -> PollMultiSelectState.AT_MAX
            PollMultiSelectState.AT_LEAST.value -> PollMultiSelectState.AT_LEAST
            else -> PollMultiSelectState.EXACTLY
        }
    }

    fun PollMultiSelectState.getPollMultiSelectStateValue(): String {
        return when (this) {
            PollMultiSelectState.EXACTLY -> PollMultiSelectState.EXACTLY.value
            PollMultiSelectState.AT_MAX -> PollMultiSelectState.AT_MAX.value
            PollMultiSelectState.AT_LEAST -> PollMultiSelectState.AT_LEAST.value
        }
    }

    fun String.getPollType(): PollType {
        return when (this) {
            PollType.INSTANT.value -> PollType.INSTANT
            PollType.DEFERRED.value -> PollType.DEFERRED
            else -> PollType.INSTANT
        }
    }

    fun PollType.getPollTypeValue(): String {
        return when (this) {
            PollType.INSTANT -> PollType.INSTANT.value
            PollType.DEFERRED -> PollType.DEFERRED.value
        }
    }
}