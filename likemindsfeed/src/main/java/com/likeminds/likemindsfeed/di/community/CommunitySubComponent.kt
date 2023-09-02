package com.likeminds.likemindsfeed.di.community

import com.likeminds.likemindsfeed.community.CommunityClient
import dagger.Subcomponent

@Subcomponent
interface CommunitySubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CommunitySubComponent
    }

    fun inject(communityClient: CommunityClient)
}