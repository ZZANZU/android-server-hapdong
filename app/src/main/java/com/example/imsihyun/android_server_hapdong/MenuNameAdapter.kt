package com.example.imsihyun.android_server_hapdong

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.imsihyun.android_server_hapdong.post.PostShopResponseData

class MenuNameAdapter(var menuItems : ArrayList<PostShopResponseData>, var requestManager: RequestManager)
    : RecyclerView.Adapter<MenuNameViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuNameViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_menu_name, parent, false)

        return MenuNameViewHolder(mainView)
    }

    override fun getItemCount(): Int = menuItems.size

    override fun onBindViewHolder(holder: MenuNameViewHolder, position: Int) {
        holder!!.menu_name.text = menuItems[position].menu_name
        holder!!.menu_price.text = menuItems[position].menu_price.toString()
    }
}
