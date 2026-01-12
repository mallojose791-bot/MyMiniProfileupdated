package com.example.myminiprofile

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val iconApp = itemView.findViewById<ImageView>(R.id.iconApp)
    private val txtAppName = itemView.findViewById<TextView>(R.id.txtAppName)
    private val txtMessage = itemView.findViewById<TextView>(R.id.txtMessage)
    private val txtTime = itemView.findViewById<TextView>(R.id.txtTime)
    private val unreadDot = itemView.findViewById<View>(R.id.unreadDot)

    fun bind(notification: NotificationItem) {
        txtAppName.text = notification.senderName
        txtMessage.text = notification.message
        txtTime.text = notification.time

        // Hide the Instagram icon
        iconApp.visibility = View.GONE

        // Show/hide unread indicator
        unreadDot.visibility = if (notification.isRead) View.GONE else View.VISIBLE

        // Change background color for unread notifications
        itemView.setBackgroundColor(
            if (notification.isRead) Color.WHITE else Color.parseColor("#F0F8FF")
        )

        // Click to open detail
        itemView.setOnClickListener {
            val activity = itemView.context as? FragmentActivity
            val detailFragment = NotificationDetailFragment.newInstance(
                notification.senderName,
                notification.message,
                notification.time
            )

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, detailFragment)
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}