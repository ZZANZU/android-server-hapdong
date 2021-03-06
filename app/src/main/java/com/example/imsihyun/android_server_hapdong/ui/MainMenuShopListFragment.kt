package com.example.imsihyun.android_server_hapdong.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.imsihyun.android_server_hapdong.*
import com.example.imsihyun.android_server_hapdong.adapter.MenuShopAdapter
import com.example.imsihyun.android_server_hapdong.get.GetShopResponse
import com.example.imsihyun.android_server_hapdong.get.GetShopResponseData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_menus_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMenuShopListFragment: Fragment() {
    lateinit var mToolBar: Toolbar

    lateinit var networkService : NetworkService
    lateinit var requestManager : RequestManager

    lateinit var mShopItems : ArrayList<GetShopResponseData>
    lateinit var mMenuShopAdapter : MenuShopAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.fragment_main_menus_list, container, false)

        mToolBar = activity!!.main_menu_toolbar
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        mToolBar.setNavigationOnClickListener({
            startActivity(Intent(activity!!.applicationContext, MainActivity::class.java))
            activity!!.finish()
        })

        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this.activity)

        if(arguments!!.getInt("shop category") != null) {
            var shopCategory = arguments!!.getInt("shop category")

            val getShopResponse = networkService.getShopContent(shopCategory)
            getShopResponse.enqueue(object : Callback<GetShopResponse>, View.OnClickListener {
                override fun onClick(v: View?) {
                    val idx : Int = shop_list_rv.getChildAdapterPosition(v)
                    val shop_name : String = mShopItems[idx].shop_name

                    val intent : Intent = Intent(activity!!.applicationContext, ShopActivity::class.java)
                    intent.putExtra("shop_name", shop_name)
                    startActivity(intent)
                }

                override fun onFailure(call: Call<GetShopResponse>?, t: Throwable?) {
                    Log.d("ZZANZU", "getting shop data / failure")
                }

                override fun onResponse(call: Call<GetShopResponse>?, response: Response<GetShopResponse>?) {
                    if(response!!.isSuccessful) {
                        mShopItems = response.body().data
                        mMenuShopAdapter = MenuShopAdapter(mShopItems, requestManager)
                        mMenuShopAdapter.setOnItemClickListener(this) // 아이템 클릭

                        shop_list_rv.adapter = mMenuShopAdapter
                        shop_list_rv.layoutManager = LinearLayoutManager(activity!!.applicationContext)
                    }
                }

            })
        }

        return mView

    }
}