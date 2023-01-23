package com.likeminds.likemindsfeed.sdk.model

import android.app.Application
import androidx.annotation.Keep
import com.likeminds.internalsdk.LikeMindsCallback

@Keep
class InitiateLikeMindsExtra private constructor(
    var application: Application, //instance of application of client
    var apiKey: String, //api key of the client
    var notificationIcon: Int?, //notification icon of the client
    var domain: String?, //domain of the client
    var likeMindsCallback: LikeMindsCallback?, //callback for sdk login and callback
) {
    class Builder {
        private lateinit var application: Application
        private var apiKey: String = ""
        private var notificationIcon: Int? = null
        private var domain: String? = null
        private var likeMindsCallback: LikeMindsCallback? = null

        fun application(application: Application) = apply { this.application = application }
        fun apiKey(apiKey: String) = apply { this.apiKey = apiKey }

        fun notificationIcon(notificationIcon: Int?) =
            apply { this.notificationIcon = notificationIcon }

        fun domain(domain: String?) = apply { this.domain = domain }
        fun likeMindsCallback(likeMindsCallback: LikeMindsCallback?) =
            apply { this.likeMindsCallback = likeMindsCallback }

        fun build() = InitiateLikeMindsExtra(
            application,
            apiKey,
            notificationIcon,
            domain,
            likeMindsCallback
        )
    }

    fun toBuilder(): Builder {
        return Builder().application(application)
            .apiKey(apiKey)
            .domain(domain)
            .notificationIcon(notificationIcon)
            .likeMindsCallback(likeMindsCallback)
    }
}