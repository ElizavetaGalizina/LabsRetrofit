package com.example.labsretrofit

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.labsretrofit.models.Quote

class Adapter (private val context: Context, private val quoteList: List<Quote>) :
    RecyclerView.Adapter<Adapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_quotes, parent, false)

        return UserViewHolder(itemView)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = quoteList[position]
        print(user)
        holder.userName.text = user.author
        holder.userEmail.text = user.content

    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userName: TextView
        var userEmail: TextView


        init {
            userName = view.findViewById(R.id.layout_list_user_day_name)
            userEmail = view.findViewById(R.id.layout_list_user_email)

        }
    }

}