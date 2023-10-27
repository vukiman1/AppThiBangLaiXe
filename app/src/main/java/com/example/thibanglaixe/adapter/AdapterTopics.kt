package com.example.thibanglaixe.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.activity.MainActivity
import com.example.thibanglaixe.fragment.FragmentContest
import com.example.thibanglaixe.model.TopicModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class AdapterTopics(private val context: Context, private val list: List<TopicModel>) :RecyclerView.Adapter<AdapterTopics.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemTextNumber: TextView
        var itemTextTime: TextView
        var itemTextButton: TextView
        init {
            itemTextNumber = itemView.findViewById(R.id.item_text_number)
            itemTextTime = itemView.findViewById(R.id.item_text_time)
            itemTextButton = itemView.findViewById(R.id.item_text_button)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_topic, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTextNumber.text = "Đề số ${position+1}"
        holder.itemTextTime.text = list[position].title

        holder.itemView.setOnClickListener{
            val fragmentContest = FragmentContest(listOf(), list[position].listQuestion)
            val viewMore: View = LayoutInflater.from(context).inflate(R.layout.bottom_start, null)
            val dialogMore = BottomSheetDialog(context)
            dialogMore.setContentView(viewMore)
            dialogMore.behavior.state = BottomSheetBehavior.STATE_EXPANDED
            dialogMore.show()
            viewMore.setBackgroundResource(R.drawable.bg_bottom_sheet)
            val buttonStart: TextView = viewMore.findViewById(R.id.button_start)
            buttonStart.setOnClickListener {
                dialogMore.hide()
                (context as MainActivity).addFragment(fragmentContest, "Contest")
            }
        }
    }

    override fun getItemCount(): Int = list.size
}