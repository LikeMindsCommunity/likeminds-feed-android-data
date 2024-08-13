package com.likeminds.likemindsfeed.util

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject

object JSONUtil {

    //convert JSONObject to JsonObject
    fun JSONObject.toJsonObject(): JsonObject {
        return JsonParser().parse(this.toString()).asJsonObject
    }

    //convert JsonObject to JSONObject
    fun JsonObject.toJSONObject(): JSONObject {
        val jsonString = this.toString()
        return JSONObject(jsonString)
    }
}