package com.example.thibanglaixe.fragment

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thibanglaixe.adapter.AdapterAnswer
import com.example.thibanglaixe.databinding.FragmentQuestionBinding
import com.example.thibanglaixe.m_interface.IOnItemClickListener
import com.example.thibanglaixe.model.QuestionModel

class FragmentQuestion(private val userKey: Int, private val questionModel: QuestionModel): Fragment() {
    private lateinit var binding: FragmentQuestionBinding
    private var selectItem: Int = -1
    private lateinit var adapterAnswer: AdapterAnswer

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.textQuestion.text = questionModel.question
        if(questionModel.isMark){
            binding.textQuestionMark.visibility = View.VISIBLE
            binding.textQuestionMark.text = "* Câu hỏi điểm liệt"
        }
        if(questionModel.image != null){
            Glide.with(requireActivity())
                .load(questionModel.image)
                .into(binding.imageQuestion)
            binding.imageQuestion.visibility = View.VISIBLE
        }
        binding.textExplainDetails.text = questionModel.explain
        adapterAnswer = AdapterAnswer(requireActivity(), userKey, questionModel.key, questionModel.answer,
            object : IOnItemClickListener{
                override fun setOnItemClickListener(position: Int) {
                    selectItem = position
                }
            }
        )
        binding.rcvAnswer.adapter = adapterAnswer
        binding.rcvAnswer.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rcvAnswer.setHasFixedSize(true)
        if(userKey != -1){
            binding.rcvAnswer.isClickable = false
            binding.explain.visibility = View.VISIBLE
        }
        return view
    }

    fun checkResult(): Int{
        return selectItem
    }


}