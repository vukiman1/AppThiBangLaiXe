package com.example.thibanglaixe.model

data class QuestionModel (
    val question: String,
    val isMark: Boolean,
    val image: String? = null,
    val answer: List<AnswerModel>,
    val key: Int,
    val explain: String
)
