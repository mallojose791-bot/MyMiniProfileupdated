package com.example.myminiprofile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotificationsAdapter(
    private val notifications: List<NotificationItem>
) : RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.txtAppName)      // ← FIXED
        val tvMessage: TextView = itemView.findViewById(R.id.txtMessage)    // ← FIXED
        val tvTime: TextView = itemView.findViewById(R.id.txtTime)          // ← FIXED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notifications[position]
        holder.tvTitle.text = notification.senderName
        holder.tvMessage.text = notification.message
        holder.tvTime.text = notification.time

        // Change background if unread
        if (!notification.isRead) {
            holder.itemView.setBackgroundColor(0xFFF5F5F5.toInt())
        }
    }

    override fun getItemCount() = notifications.size
}
