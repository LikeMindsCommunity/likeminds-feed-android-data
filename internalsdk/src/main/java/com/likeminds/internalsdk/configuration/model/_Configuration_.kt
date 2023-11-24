package com.likeminds.internalsdk.configuration.model

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

class _Configuration_ private constructor(
    @SerializedName("type")
    val type: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("value")
    val value: JSONObject
)
