package com.example.thibanglaixe.network

import com.example.thibanglaixe.model.QuestionModel
import retrofit2.http.GET

interface ApiClient {
    @GET("question")
    suspend fun apiQuestion(): List<QuestionModel>
}