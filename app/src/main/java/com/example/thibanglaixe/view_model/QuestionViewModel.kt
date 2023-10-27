package com.example.thibanglaixe.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thibanglaixe.model.QuestionModel
import com.example.thibanglaixe.resposity.QuestionRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class QuestionViewModel: ViewModel(){
    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean>
        get() = _showLoading

    fun getDataApiQuestion(): MutableLiveData<List<QuestionModel>>{
        val responseLiveData:MutableLiveData<List<QuestionModel>> = MutableLiveData()
        viewModelScope.launch {
            QuestionRepository.fetchDataApiQuestion()
                .catch { e ->
                    Log.e("api", "getDataApi: ${e.message}")
                }.collect{ response ->
                    responseLiveData.value = response
                }
        }
        _showLoading.value = true
        return responseLiveData
    }
}