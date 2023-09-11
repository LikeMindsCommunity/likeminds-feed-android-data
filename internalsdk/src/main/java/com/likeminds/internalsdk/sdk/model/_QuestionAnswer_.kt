package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class _QuestionAnswer_(
    @SerializedName("question_answer")
    var answer: _Answer_,
    @SerializedName("question")
    var question: _Question_
)