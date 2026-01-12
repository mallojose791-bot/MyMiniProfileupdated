package com.example.myminiprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Back button
        view.findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Set up RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewNotifications)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Sample notifications
        val notifications = listOf(
            NotificationItem(
                senderName = "Marifel Mallo",
                message = "Hey! How are you?",
                time = "2 min ago",
                isRead = false
            ),
            NotificationItem(
                senderName = "Mark Jason Morales",
                message = "Thanks for the follow!",
                time = "15 min ago",
                isRead = false
            ),
            NotificationItem(
                senderName = "Skyler Jace ",
                message = "Check out my new post 🔥",
                time = "1 hour ago",
                isRead = false
            ),
            NotificationItem(
                senderName = "John Dale Bernardo",
                message = "Nice pic! 😍",
                time = "2 hours ago",
                isRead = true
            ),
            NotificationItem(
                senderName = "Ivan rae",
                message = "Can we meet tomorrow?",
                time = "3 hours ago",
                isRead = true
            )
        )

        recyclerView.adapter = NotificationsAdapter(notifications)
    }
}