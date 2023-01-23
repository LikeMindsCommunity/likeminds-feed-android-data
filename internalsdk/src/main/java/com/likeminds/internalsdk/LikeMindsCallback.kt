package com.likeminds.internalsdk

import androidx.annotation.Keep

@Keep
interface LikeMindsCallback {
    //to trigger analytics events
    fun eventFiredCallback(eventKey: String, propertiesMap: HashMap<String, String?>) {}
}