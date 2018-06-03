package com.example.imsihyun.android_server_hapdong

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.imsihyun.android_server_hapdong.data.ShopInfo
import kotlinx.android.synthetic.main.item_shop_menu.view.*

class MenuShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ShopInfo) {
        itemView.shop_img.setImageResource(item.shopImg)
        itemView.shop_name.text = item.shopName
        itemView.shop_content.text = item.shopContent
        itemView.shop_review_count.text = item.shopReviewCount.toString() // int to string
    }
}