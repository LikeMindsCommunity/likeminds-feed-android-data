package com.likeminds.likemindsfeed.util

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject

object JSONUtil {

    fun JSONObject.toJsonObject(): JsonObject {
        return JsonParser.parseString(this.toString()).asJsonObject
    }

    fun JsonObject.toJSONObject(): JSONObject {
        val jsonString = this.toString()
        return JSONObject(jsonString)
    }
}