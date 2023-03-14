package com.likeminds.likemindsfeed.util

import com.likeminds.likemindsfeed.LMFeedClient

object RequestUtils {
    fun validate() {
        LMFeedClient.getInstance()
    }

    fun validateRequest(property: String) {
        throw IllegalAccessException("$property is empty.")
    }
}