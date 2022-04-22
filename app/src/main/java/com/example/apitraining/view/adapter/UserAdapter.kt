package com.example.apitraining.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.apitraining.R
import com.example.apitraining.view.data.user.UserModel
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val context: FragmentActivity?, val listUser: List<UserModel>) : RecyclerView.Adapter<UserAdapter.ViewHodelUser>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onClick(position: Int)
    }

    fun setOnClick(lister : onItemClickListener){
        mListener = lister
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodelUser {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return ViewHodelUser(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHodelUser, position: Int) {
        holder.bindData(listUser.get(position))
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    class ViewHodelUser(itemView: View, lister: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var userName = itemView.tvName
        var userEmail = itemView.tvEmail
        var userGender = itemView.tvGender
        var userStatus = itemView.tvStatus

        init {
            itemView.setOnClickListener {
                lister.onClick(adapterPosition)
            }
        }

        fun bindData(user : UserModel){
            userName.text = user.name
            userEmail.text = user.email
            userGender.text = user.gender
            userStatus.text = user.status
        }


    }
}