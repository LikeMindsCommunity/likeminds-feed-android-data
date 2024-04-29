package com.likeminds.internalsdk.poll.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.widgets.model._Widget_

data class _GetPollVotesResponse_(
    @SerializedName("votes")
    val votes: List<_PollVote_>,
    @SerializedName("users")
    val users: Map<String, _User_>,
    @SerializedName("widgets")
    val widgets: Map<String, _Widget_>,
)