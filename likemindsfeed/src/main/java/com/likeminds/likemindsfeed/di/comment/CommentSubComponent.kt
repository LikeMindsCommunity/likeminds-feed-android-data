package com.likeminds.likemindsfeed.di.comment

import com.likeminds.likemindsfeed.comment.CommentClient
import dagger.Subcomponent

@Subcomponent
interface CommentSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CommentSubComponent
    }

    fun inject(commentClient: CommentClient)
}