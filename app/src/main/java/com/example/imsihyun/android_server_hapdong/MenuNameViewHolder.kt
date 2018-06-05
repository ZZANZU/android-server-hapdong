package com.example.imsihyun.android_server_hapdong

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MenuNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var menu_name : TextView = itemView!!.findViewById(R.id.menu_name_tv)
    var menu_price : TextView = itemView!!.findViewById(R.id.menu_price_tv)
}