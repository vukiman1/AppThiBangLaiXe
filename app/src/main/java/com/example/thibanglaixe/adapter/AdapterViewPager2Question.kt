package com.example.thibanglaixe.adapter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.thibanglaixe.fragment.FragmentQuestion

class AdapterViewPager2Question(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    var fragments: MutableList<FragmentQuestion> = mutableListOf()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): FragmentQuestion = fragments[position]

    fun addFragmentViewPager2(fragment: FragmentQuestion){
        fragments.add(fragment)
    }
}