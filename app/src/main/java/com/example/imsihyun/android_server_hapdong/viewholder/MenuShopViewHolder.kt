package com.example.imsihyun.android_server_hapdong.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.imsihyun.android_server_hapdong.R

class MenuShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var shopName : TextView = itemView!!.findViewById(R.id.shop_name)
    var shopContent : TextView = itemView!!.findViewById(R.id.shop_content)
    var shopImg : ImageView = itemView!!.findViewById(R.id.shop_img) as ImageView
    var shopReviewCount : TextView = itemView!!.findViewById(R.id.shop_review_count)
}