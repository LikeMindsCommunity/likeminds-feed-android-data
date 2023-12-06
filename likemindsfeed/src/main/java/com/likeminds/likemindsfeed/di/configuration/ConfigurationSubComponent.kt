package com.likeminds.likemindsfeed.di.configuration

import com.likeminds.likemindsfeed.configuration.ConfigurationClient
import dagger.Subcomponent

@Subcomponent
interface ConfigurationSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ConfigurationSubComponent
    }

    fun inject(configurationClient: ConfigurationClient)
}