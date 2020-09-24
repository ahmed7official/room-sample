package com.android.roomsample.ui.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.roomsample.data.local.User
import com.android.roomsample.databinding.ListitemUserBinding

class UsersAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UsersAdapter.Companion.UserHolder>() {

    companion object {

        class UserHolder(val binding: ListitemUserBinding) : RecyclerView.ViewHolder(binding.root)

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = ListitemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return UserHolder(binding)
    }//onCreateViewHolder()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

        holder.binding.user = users[position]

    }//onBindViewHolder()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun getItemCount() = users.size

}