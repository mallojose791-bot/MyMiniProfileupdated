package com.example.myminiprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class NotificationDetailFragment : Fragment() {

    companion object {
        private const val ARG_SENDER_NAME = "sender_name"
        private const val ARG_MESSAGE = "message"
        private const val ARG_TIME = "time"

        fun newInstance(senderName: String, message: String, time: String): NotificationDetailFragment {
            val fragment = NotificationDetailFragment()
            val args = Bundle().apply {
                putString(ARG_SENDER_NAME, senderName)
                putString(ARG_MESSAGE, message)
                putString(ARG_TIME, time)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get data from arguments
        val senderName = arguments?.getString(ARG_SENDER_NAME) ?: ""
        val message = arguments?.getString(ARG_MESSAGE) ?: ""
        val time = arguments?.getString(ARG_TIME) ?: ""

        // Back button
        view.findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Set data to views - FIX THE IDs HERE!
        view.findViewById<TextView>(R.id.tvSenderName).text = senderName
        view.findViewById<TextView>(R.id.tvDetailMessage).text = message
        view.findViewById<TextView>(R.id.tvDetailTime).text = time
    }
}