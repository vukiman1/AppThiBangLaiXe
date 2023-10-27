package com.example.thibanglaixe.resposity

import com.example.thibanglaixe.network.ApiService
import com.example.thibanglaixe.model.QuestionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class QuestionRepository {
    companion object{
        fun fetchDataApiQuestion(): Flow<List<QuestionModel>> = flow {
            val response = ApiService.api.apiQuestion()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}