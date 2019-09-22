package com.eha.usersimple002.adapter


import com.eha.usersimple002.R
import com.eha.usersimple002.entity.User as UserEntity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_user_list_item.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.collections.ArrayList


class UserRecycler : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private val TAG: String = "AppDebug"

    private var items: List<UserEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_user_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is UserViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(userList: List<UserEntity>){
        items = userList
    }

    class UserViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val avatar = itemView.avatar
        val full_name = itemView.full_name
        val email = itemView.email

        fun bind(userData: UserEntity){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(userData.avatar)
                .into(avatar)
            full_name.setText("${userData.first_name} ${userData.last_name}")
            email.setText(userData.email)

        }

    }

}
