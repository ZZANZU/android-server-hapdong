package com.example.imsihyun.android_server_hapdong

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.imsihyun.android_server_hapdong.get.GetShopResponseData


class MenuShopAdapter(var shopItems : ArrayList<GetShopResponseData>, var requestManager: RequestManager)
    : RecyclerView.Adapter<MenuShopViewHolder>() {

     lateinit var onItemClick : View.OnClickListener // 액션 변수

    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l // 액션 함수
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuShopViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_shop_menu, parent, false)

         mainView.setOnClickListener(onItemClick) // 아이템 클릭

        return MenuShopViewHolder(mainView)
    }

    override fun getItemCount(): Int = shopItems.size

    override fun onBindViewHolder(holder: MenuShopViewHolder, position: Int) {
        holder!!.shopName.text = shopItems[position].shop_name
        holder!!.shopContent.text = shopItems[position].shop_content
        holder!!.shopReviewCount.text = shopItems[position].review_count.toString()

        requestManager.load(shopItems[position].shop_image).into(holder!!.shopImg) // 이미지
    }
}