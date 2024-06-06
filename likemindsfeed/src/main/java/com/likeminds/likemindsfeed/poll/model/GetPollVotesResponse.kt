package com.likeminds.likemindsfeed.poll.model

import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.widgets.model.Widget

data class GetPollVotesResponse(
    val votes: List<PollVote>,
    val users: Map<String, User>,
    val widgets: Map<String, Widget>,
)
