package com.likeminds.likemindsfeed.di

import android.app.Application
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.di.initiateUser.InitiateUserModule
import com.likeminds.likemindsfeed.di.initiateUser.InitiateUserSubComponent
import com.likeminds.likemindsfeed.di.internalsdk.SDKModule
import com.likeminds.likemindsfeed.di.internalsdk.SharedModule
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedModule::class, SDKModule::class, InitiateUserModule::class])
internal interface LikeMindsFeedComponent {

    fun inject(likeMindsFeedApplication: LikeMindsFeedApplication)
    fun inject(lmFeedClient: LMFeedClient)

    fun initiateUserComponent(): InitiateUserSubComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): LikeMindsFeedComponent
    }
}