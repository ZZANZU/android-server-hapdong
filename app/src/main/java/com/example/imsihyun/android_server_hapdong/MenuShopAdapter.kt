package com.example.imsihyun.android_server_hapdong

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imsihyun.android_server_hapdong.data.ShopInfo

class MenuShopAdapter(private var shopItems : ArrayList<ShopInfo>)
    : RecyclerView.Adapter<MenuShopViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuShopViewHolder {
        val mainView : View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_shop_menu, parent, false)

        return MenuShopViewHolder(mainView)
    }

    override fun getItemCount(): Int = shopItems.size

    override fun onBindViewHolder(holder: MenuShopViewHolder, position: Int) {
        holder.bind(shopItems[position])
    }
}