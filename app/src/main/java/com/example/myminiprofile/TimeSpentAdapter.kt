package com.example.myminiprofile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TimeSpentAdapter(
    private val activities: List<ActivityItem>
) : RecyclerView.Adapter<TimeSpentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeSpentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_time_spent, parent, false)
        return TimeSpentViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeSpentViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    override fun getItemCount(): Int = activities.size
}