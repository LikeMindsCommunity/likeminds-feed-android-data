package com.likeminds.likemindsfeed.di.moderation

import com.likeminds.likemindsfeed.moderation.ModerationClient
import dagger.Subcomponent

@Subcomponent
interface ModerationSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ModerationSubComponent
    }

    fun inject(moderationClient: ModerationClient)
}