package com.likeminds.likemindsfeed.di.helper

import com.likeminds.likemindsfeed.helper.HelperClient
import dagger.Subcomponent

@Subcomponent
interface HelperSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HelperSubComponent
    }

    fun inject(helperClient: HelperClient)
}