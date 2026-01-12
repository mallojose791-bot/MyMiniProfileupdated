package com.example.myminiprofile

import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.txtTitle)
    private val arrow = itemView.findViewById<ImageView>(R.id.iconArrow)

    fun bind(item: ProfileItem) {
        title.text = item.title

        when {
            item.isHeader -> {
                title.setTextColor(Color.parseColor("#9E9E9E"))
                title.textSize = 14f
                arrow.visibility = View.GONE
                itemView.isClickable = false
            }
            item.isLogout -> {
                title.setTextColor(Color.parseColor("#D32F2F"))
                title.textSize = 16f
                arrow.visibility = View.GONE
                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "Logout clicked", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                title.setTextColor(Color.parseColor("#000000"))
                title.textSize = 16f
                arrow.visibility = View.VISIBLE
                itemView.setOnClickListener {
                    when (item.title) {
                        "Personal information" -> {
                            itemView.context.startActivity(
                                Intent(itemView.context, PersonalInformationActivity::class.java)
                            )
                        }
                        "Notifications" -> {
                            itemView.context.startActivity(
                                Intent(itemView.context, NotificationsActivity::class.java)
                            )
                        }
                        "Time spent" -> {
                            itemView.context.startActivity(
                                Intent(itemView.context, TimeSpentActivity::class.java)
                            )
                        }
                        "Following" -> {
                            itemView.context.startActivity(
                                Intent(itemView.context, FollowingActivity::class.java)
                            )
                        }
                        "Privacy policy" -> {
                            itemView.context.startActivity(
                                Intent(itemView.context, PrivacyPolicyActivity::class.java)
                            )
                        }
                        "Terms & Conditions" -> {
                            itemView.context.startActivity(
                                Intent(itemView.context, TermsConditionActivity::class.java)
                            )
                        }
                        else -> {
                            Toast.makeText(itemView.context, "${item.title} clicked", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}