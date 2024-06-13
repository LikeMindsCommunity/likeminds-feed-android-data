package com.likeminds.likemindsfeed.di.poll

import com.likeminds.likemindsfeed.poll.PollClient
import dagger.Subcomponent

@Subcomponent
interface PollSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PollSubComponent
    }

    fun inject(pollClient: PollClient)
}