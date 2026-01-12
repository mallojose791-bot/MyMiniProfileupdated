package com.example.myminiprofile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(
    private val items: List<ProfileItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

    // Header ViewHolder
    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvHeaderTitle)
    }

    // Regular Item ViewHolder
    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val arrow: ImageView = itemView.findViewById(R.id.ivArrow)
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].isHeader) TYPE_HEADER else TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_profile_header, parent, false)  // Keep this as is
            HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_profile, parent, false)
            ProfileViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is HeaderViewHolder) {
            // Bind header
            holder.title.text = item.title
        } else if (holder is ProfileViewHolder) {
            // Bind regular item
            holder.title.text = item.title

            // Click handler for regular items only
            holder.itemView.setOnClickListener {
                when (item.title) {
                    "Personal Information" -> {
                        holder.itemView.context.startActivity(
                            Intent(holder.itemView.context, PersonalInformationActivity::class.java)
                        )
                    }
                    "Notifications" -> {
                        holder.itemView.context.startActivity(
                            Intent(holder.itemView.context, NotificationsActivity::class.java)
                        )
                    }
                    "Time Spent" -> {
                        holder.itemView.context.startActivity(
                            Intent(holder.itemView.context, TimeSpentActivity::class.java)
                        )
                    }
                    "Following" -> {
                        holder.itemView.context.startActivity(
                            Intent(holder.itemView.context, FollowingActivity::class.java)
                        )
                    }
                    "Privacy Policy" -> {
                        holder.itemView.context.startActivity(
                            Intent(holder.itemView.context, PrivacyPolicyActivity::class.java)
                        )
                    }
                    "Terms and Condition" -> {
                        holder.itemView.context.startActivity(
                            Intent(holder.itemView.context, TermsConditionActivity::class.java)
                        )
                    }
                }
            }
        }
    }

    override fun getItemCount() = items.size
}