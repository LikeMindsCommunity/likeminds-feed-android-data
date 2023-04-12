package com.likeminds.likemindsfeed.di.post

import com.likeminds.likemindsfeed.post.PostClient
import dagger.Subcomponent

@Subcomponent
interface PostSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PostSubComponent
    }

    fun inject(postClient: PostClient)
}