package com.likeminds.likemindsfeed.di.universalfeed

import com.likeminds.likemindsfeed.feed.FeedClient
import dagger.Subcomponent

@Subcomponent
interface UniversalFeedSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UniversalFeedSubComponent
    }

    fun inject(feedClient: FeedClient)
}