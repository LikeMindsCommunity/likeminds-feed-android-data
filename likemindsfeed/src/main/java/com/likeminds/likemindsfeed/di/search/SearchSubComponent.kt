package com.likeminds.likemindsfeed.di.search

import com.likeminds.likemindsfeed.search.SearchClient
import dagger.Subcomponent

@Subcomponent
interface SearchSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SearchSubComponent
    }

    fun inject(searchClient: SearchClient)
}