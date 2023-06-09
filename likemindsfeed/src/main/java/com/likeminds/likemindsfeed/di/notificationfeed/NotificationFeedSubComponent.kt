package com.likeminds.likemindsfeed.di.notificationfeed

import com.likeminds.likemindsfeed.notificationfeed.NotificationFeedClient
import dagger.Subcomponent

@Subcomponent
interface NotificationFeedSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotificationFeedSubComponent
    }

    fun inject(notificationFeedClient: NotificationFeedClient)
}