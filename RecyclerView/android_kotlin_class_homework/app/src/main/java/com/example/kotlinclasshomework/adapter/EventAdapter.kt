package com.example.kotlinclasshomework.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.kotlinclasshomework.event.Event
import com.example.kotlinclasshomework.R


class EventAdapter : Adapter<EventAdapter.EventViewHolder>() {

    var data: List<Event> = emptyList()
        set(newValue){
            field = newValue
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.ivent_item,parent,false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: EventViewHolder,
        position: Int
    ) {
        data[position].let {
            holder.eventImage.setImageResource(it.imageResId)
            holder.eventName.text = it.name
            holder.eventTime.text = it.time
        }
    }

    override fun getItemCount(): Int = data.size

    class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val eventImage: ImageView = itemView.findViewById(R.id.eventImage)
        val eventName: TextView = itemView.findViewById(R.id.eventName)
        val eventTime : TextView = itemView.findViewById(R.id.eventTime)

    }
}