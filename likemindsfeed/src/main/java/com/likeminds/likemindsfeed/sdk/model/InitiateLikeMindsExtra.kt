package com.likeminds.likemindsfeed.sdk.model

import android.app.Application
import androidx.annotation.Keep
import com.likeminds.internalsdk.LikeMindsCallback

@Keep
class InitiateLikeMindsExtra private constructor(
    var application: Application, //instance of application of client
    var likeMindsCallback: LikeMindsCallback?, //callback for sdk login and callback
) {
    class Builder {
        private lateinit var application: Application
        private var likeMindsCallback: LikeMindsCallback? = null

        fun application(application: Application) = apply { this.application = application }
        fun likeMindsCallback(likeMindsCallback: LikeMindsCallback?) =
            apply { this.likeMindsCallback = likeMindsCallback }

        fun build() = InitiateLikeMindsExtra(
            application,
            likeMindsCallback
        )
    }

    fun toBuilder(): Builder {
        return Builder().application(application)
            .likeMindsCallback(likeMindsCallback)
    }
}