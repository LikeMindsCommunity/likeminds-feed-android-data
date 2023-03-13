package com.likeminds.likemindsfeed.di.branding

import com.likeminds.likemindsfeed.branding.BrandingClient
import dagger.Subcomponent

@Subcomponent
interface BrandingSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): BrandingSubComponent
    }

    fun inject(brandingClient: BrandingClient)
}