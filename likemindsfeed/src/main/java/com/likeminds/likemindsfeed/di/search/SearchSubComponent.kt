package com.likeminds.likemindsfeed.di.search

import dagger.Subcomponent

@Subcomponent
interface SearchSubComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():SearchSubComponent
    }

//    fun inject(searchClient: SearchClient)
}


//@Subcomponent
//interface PostSubComponent {
//
//    @Subcomponent.Factory
//    interface Factory {
//        fun create(): PostSubComponent
//    }
//
//    fun inject(postClient: PostClient)
//}