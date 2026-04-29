package com.tinkoff.android_homework.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tinkoff.android_homework.R
import com.tinkoff.android_homework.presentation.model.operations.OperationItem
import com.tinkoff.android_homework.presentation.model.operations.OperationType

class operationAdapter : RecyclerView.Adapter<operationAdapter.EventViewHolder>() {

    var data: List<OperationItem> = emptyList()
        set(newValue){
            field = newValue
            notifyDataSetChanged()
        }

    fun submitList(newList: List<OperationItem>?) {
        data = newList ?: emptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.operation_recycler_item, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val operationIcon: ImageView = itemView.findViewById(R.id.operation_icon)
        private val operationName: TextView = itemView.findViewById(R.id.operation_name)
        private val operationSum: TextView = itemView.findViewById(R.id.operation_sum)

        fun bind(operation: OperationItem) {
            operationName.text = operation.operationTitle
            operationSum.text = "${operation.operationSum} ₽"

            when (operation.operationType) {
                OperationType.INCOME -> operationIcon.setImageResource(R.drawable.income_icon)
                OperationType.OUTCOME -> operationIcon.setImageResource(R.drawable.spending_icon)
            }
        }
    }
}