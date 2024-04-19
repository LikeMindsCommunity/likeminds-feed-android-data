package com.likeminds.likemindsfeed.di.initiateUser

import com.likeminds.likemindsfeed.user.UserClient
import dagger.Subcomponent

@Subcomponent
interface InitiateUserSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): InitiateUserSubComponent
    }

    fun inject(userClient: UserClient)
}