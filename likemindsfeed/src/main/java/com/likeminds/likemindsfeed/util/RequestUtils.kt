package com.likeminds.likemindsfeed.util

import com.likeminds.likemindsfeed.LMFeedClient

object RequestUtils {

    /**
     * validates whether LMFeedClient is instantiated or not
     * @throws IllegalAccessException - if LMFeedClient is not instantiated
     */
    fun validate() {
        LMFeedClient.getInstance()
    }

    /**
     * @param property - Name of property which is null or empty
     * @throws IllegalAccessException - as required property is empty/null
     */
    fun throwException(property: String) {
        throw IllegalArgumentException("$property is empty.")
    }
}