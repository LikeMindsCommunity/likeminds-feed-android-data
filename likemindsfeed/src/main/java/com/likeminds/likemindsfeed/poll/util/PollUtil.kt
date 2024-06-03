package com.likeminds.likemindsfeed.poll.util

import com.likeminds.likemindsfeed.post.model.PollMultiSelectState
import com.likeminds.likemindsfeed.post.model.PollType

object PollUtil {

    //return [PollMultiSelectState] enum based on its value
    fun String.getPollMultiSelectState(): PollMultiSelectState {
        return when (this) {
            PollMultiSelectState.EXACTLY.value -> PollMultiSelectState.EXACTLY
            PollMultiSelectState.AT_MAX.value -> PollMultiSelectState.AT_MAX
            PollMultiSelectState.AT_LEAST.value -> PollMultiSelectState.AT_LEAST
            else -> PollMultiSelectState.EXACTLY
        }
    }

    //return value of [PollMultiSelectState] enum
    fun PollMultiSelectState.getPollMultiSelectStateValue(): String {
        return when (this) {
            PollMultiSelectState.EXACTLY -> PollMultiSelectState.EXACTLY.value
            PollMultiSelectState.AT_MAX -> PollMultiSelectState.AT_MAX.value
            PollMultiSelectState.AT_LEAST -> PollMultiSelectState.AT_LEAST.value
        }
    }

    //return [PollType] enum based on its value
    fun String.getPollType(): PollType {
        return when (this) {
            PollType.INSTANT.value -> PollType.INSTANT
            PollType.DEFERRED.value -> PollType.DEFERRED
            else -> PollType.INSTANT
        }
    }

    //return value of [PollType] enum
    fun PollType.getPollTypeValue(): String {
        return when (this) {
            PollType.INSTANT -> PollType.INSTANT.value
            PollType.DEFERRED -> PollType.DEFERRED.value
        }
    }
}