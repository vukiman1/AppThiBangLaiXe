package com.example.thibanglaixe.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.m_interface.IOnItemClickListener
import com.example.thibanglaixe.model.AnswerModel

class AdapterAnswer (private val activity: Activity, private val userKeyQuestion: Int,private val keyQuestion: Int, private val list: List<AnswerModel>, private val iOnItemClickListener: IOnItemClickListener) : RecyclerView.Adapter<AdapterAnswer.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textNumber: TextView
        var textQuestion: TextView
        init {
            textNumber = itemView.findViewById(R.id.text_number)
            textQuestion = itemView.findViewById(R.id.text_answer)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_answer, parent, false)
        return ViewHolder(view)
    }

    private var userKey: Int = if(userKeyQuestion != -1) userKeyQuestion else -1

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("InflateParams", "SetTextI18n", "NotifyDataSetChanged",
        "UseCompatLoadingForDrawables"
    )
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.textNumber.text = "${position+1}"
        holder.textQuestion.text = list[position].value

        if(userKey==position){
            holder.textQuestion.setTextColor(Color.RED)
            holder.textNumber.setTextColor(Color.RED)
            holder.textNumber.background = activity.resources.getDrawable(R.drawable.circle_text_select)
        }
        else{
            holder.textQuestion.setTextColor(activity.resources.getColor(R.color.unselected_color))
            holder.textNumber.setTextColor(activity.resources.getColor(R.color.unselected_color))
            holder.textNumber.background = activity.resources.getDrawable(R.drawable.circle_text)
        }

        if(userKeyQuestion != -1){
            holder.itemView.setOnClickListener(null)
            if(keyQuestion - 1 == position){
                holder.textQuestion.setTextColor(activity.resources.getColor(R.color.selected_color))
                holder.textNumber.setTextColor(activity.resources.getColor(R.color.selected_color))
                holder.textNumber.background = activity.resources.getDrawable(R.drawable.circle_text_key)
            }
        } else {
            holder.itemView.setOnClickListener {
                userKey = position
                iOnItemClickListener.setOnItemClickListener(position)
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int = list.size
}