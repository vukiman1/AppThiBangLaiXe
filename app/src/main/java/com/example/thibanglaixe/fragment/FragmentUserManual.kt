package com.example.thibanglaixe.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.fragment.app.Fragment
import com.example.thibanglaixe.activity.MainActivity
import com.example.thibanglaixe.databinding.FragmentChangeLicenseBinding
import com.example.thibanglaixe.databinding.FragmentUserManualBinding

class FragmentUserManual: Fragment() {
    private lateinit var binding: FragmentUserManualBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserManualBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.toolbarBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }

        Handler().postDelayed({
            scaleView(binding.tvIntro);
            Handler().postDelayed({
                scaleView(binding.tvDetail1)
                Handler().postDelayed({
                    scaleView(binding.tvDetail2)
                    Handler().postDelayed({
                        scaleView(binding.tvDetail3)
                        Handler().postDelayed({
                            scaleView(binding.tvDetail4)
                            Handler().postDelayed({
                                scaleView(binding.buttonBack)
                            }, 2500)
                        }, 2500)
                    }, 2500)
                }, 2500)
            }, 2500)
        }, 0)

        binding.buttonBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
        return view
    }

    private fun scaleView(v: View) {
        val anim: Animation = ScaleAnimation(
            1f, 1f,
//            startScale, endScale,
            0f,1f,
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 1f
        )
        anim.fillAfter = true
        anim.duration = 2000
        v.startAnimation(anim)
    }
}