package com.likeminds.likemindsfeed.di.initiateUser

import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import dagger.Subcomponent

@Subcomponent
interface InitiateUserSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): InitiateUserSubComponent
    }

    fun inject(initiateUserClient: InitiateUserClient)
}