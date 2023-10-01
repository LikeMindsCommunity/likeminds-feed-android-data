package com.likeminds.likemindsfeed.di.topic

import com.likeminds.likemindsfeed.topic.TopicClient
import dagger.Subcomponent

@Subcomponent
interface TopicSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): TopicSubComponent
    }

    fun inject(topicClient: TopicClient)
}