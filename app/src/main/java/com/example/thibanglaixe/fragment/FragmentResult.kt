package com.example.thibanglaixe.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thibanglaixe.activity.MainActivity
import com.example.thibanglaixe.databinding.FragmentResultBinding
import com.example.thibanglaixe.model.QuestionModel

class FragmentResult(
    private val listResult: List<Int>,
    private val listQuestion: List<QuestionModel>,
                     ): Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        var numberInCorrect = 0
        var numberMarkInCorrect = 0

        for(i in listQuestion.indices){
            if(listResult[i] != listQuestion[i].key){
                ++numberInCorrect
                if(listQuestion[i].isMark){
                    ++numberMarkInCorrect
                }
            }
        }

        binding.textNotification.text = if(numberInCorrect <= 4){
            if(numberMarkInCorrect !=0){
                "Ôi! Bạn chưa vượt qua bài thi"
            } else {
                "Chúc mừng! Bạn đã vượt qua bài thi"
            }
        } else {
            "Ôi! Bạn chưa vượt qua bài thi"
        }
        binding.textDetails.text = if(numberInCorrect == 0){
            "Bạn đã trả lời đúng toàn bộ câu hỏi"
        } else {
            val mark = if(numberMarkInCorrect == 0) {
                "trong đó không có câu điểm liệt"
            } else {
                "bao gồm cả $numberMarkInCorrect câu điểm liệt"
            }
            "Bạn đã trả lời sai tất cả $numberInCorrect câu hỏi $mark"
        }
        binding.textNumberCorrect.text = "${25 - numberInCorrect}"
        binding.textNumberIncorrect.text = "$numberInCorrect"

        binding.buttonReview.setOnClickListener {
            (activity as MainActivity).onBackPressed()
            val fragmentContest = FragmentContest(listResult, listQuestion)
            (context as MainActivity).addFragment(fragmentContest, "Contest")
        }
        binding.buttonRemake.setOnClickListener {
            (activity as MainActivity).onBackPressed()
            val fragmentContest = FragmentContest(listOf(), listQuestion)
            (context as MainActivity).addFragment(fragmentContest, "Contest")
        }
        binding.buttonBackFragmentTopics.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }

        return view
    }
}