package com.likeminds.likemindsfeed.post.model

class MenuItem private constructor(
    var title: String
) {

    class Builder {

        private var title: String = ""

        fun title(title: String) = apply { this.title = title }

        fun build() = MenuItem(title)
    }

    fun toBuilder(): Builder {
        return Builder().title(title)
    }
}