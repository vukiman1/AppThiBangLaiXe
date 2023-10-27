package com.example.thibanglaixe.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.thibanglaixe.R
import com.example.thibanglaixe.activity.MainActivity
import com.example.thibanglaixe.adapter.AdapterViewPager2Question
import com.example.thibanglaixe.databinding.FragmentContestBinding
import com.example.thibanglaixe.model.QuestionModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.concurrent.TimeUnit
import kotlin.math.abs


class FragmentContest(private val listUserKey: List<Int>, private val list: List<QuestionModel>): Fragment() {
    private lateinit var binding: FragmentContestBinding
    private lateinit var adapterViewPager2: AdapterViewPager2Question
    private var currentIndex = -1

    private val MAX_SCALE = 1f
    private val SCALE_PERCENT = 0.5f
    private val MIN_SCALE = SCALE_PERCENT * MAX_SCALE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContestBinding.inflate(inflater, container, false)
        val view = binding.root

        adapterViewPager2 = AdapterViewPager2Question(requireActivity().supportFragmentManager, lifecycle)
        for (i in list.indices){
            val userKey = if(listUserKey.isEmpty()) -1 else if (listUserKey[i] == -1) 5  else listUserKey[i]
            adapterViewPager2.addFragmentViewPager2(FragmentQuestion(userKey , list[i]))
        }
        if(listUserKey.isNotEmpty()){
            binding.textCountdown.visibility = View.GONE
            binding.textEnd.visibility = View.GONE
        }
        binding.viewPager2.adapter = adapterViewPager2
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentIndex = position
                binding.textNumericalOrder.text = "(Câu ${currentIndex+1}/25)"
            }
        })
        binding.viewPager2.offscreenPageLimit = 25
        binding.viewPager2.setPageTransformer { view, position ->
            val absPosition = abs(position)
            val scale = MAX_SCALE - (MAX_SCALE - MIN_SCALE) * absPosition
            view.scaleY = scale
            view.scaleX = scale
        }
        binding.toolbarBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
        timerCountdown()
        finish()

        return view
    }

    private fun finish(){
        val viewEnd: View = LayoutInflater.from(requireActivity()).inflate(R.layout.bottom_end, null)
        val bottomSheetEnd = BottomSheetDialog(requireActivity())
        bottomSheetEnd.setContentView(viewEnd)
        bottomSheetEnd.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        binding.textEnd.setOnClickListener {
            bottomSheetEnd.show()
        }
        val buttonCancel: TextView = viewEnd.findViewById(R.id.button_cancel)
        val buttonAgree: TextView = viewEnd.findViewById(R.id.button_agree)
        buttonCancel.setOnClickListener {
            bottomSheetEnd.hide()
        }
        buttonAgree.setOnClickListener {
            nextResult()
            bottomSheetEnd.hide()
        }
    }

    private fun nextResult(){
        val listResult = adapterViewPager2.fragments.map {
            it.checkResult()
        }.toList()
        (activity as MainActivity).onBackPressed()
        val fragmentResult = FragmentResult(listResult, list)
        (activity as MainActivity).addFragment(fragmentResult, "Result")
    }

    private fun timerCountdown(){
        object : CountDownTimer(1140000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val text = String.format(
                    "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                            TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(
                                    millisUntilFinished
                                )
                            ))
                binding.textCountdown.text = text
            }
            override fun onFinish() {
                if(listUserKey.isNotEmpty()) {
                    return
                }
                nextResult()
            }
        }.start()
    }
}