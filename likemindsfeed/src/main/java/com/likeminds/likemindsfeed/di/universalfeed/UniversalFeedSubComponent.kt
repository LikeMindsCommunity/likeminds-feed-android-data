package com.likeminds.likemindsfeed.di.universalfeed

import com.likeminds.likemindsfeed.universalfeed.UniversalFeedClient
import dagger.Subcomponent

@Subcomponent
interface UniversalFeedSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UniversalFeedSubComponent
    }

    fun inject(universalFeedClient: UniversalFeedClient)
}