package com.example.myminiprofile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimeSpentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val txtIcon = itemView.findViewById<TextView>(R.id.txtIcon)
    private val txtTime = itemView.findViewById<TextView>(R.id.txtTime)
    private val txtTimeRange = itemView.findViewById<TextView>(R.id.txtTimeRange)
    private val txtActivity = itemView.findViewById<TextView>(R.id.txtActivity)
    private val txtDuration = itemView.findViewById<TextView>(R.id.txtDuration)

    fun bind(activity: ActivityItem) {
        txtIcon.text = activity.icon
        txtTime.text = activity.time
        txtTimeRange.text = activity.timeRange
        txtActivity.text = activity.activity
        txtDuration.text = activity.duration
    }
}