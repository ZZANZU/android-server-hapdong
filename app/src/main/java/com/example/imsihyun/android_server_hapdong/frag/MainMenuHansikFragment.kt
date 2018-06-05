package com.example.imsihyun.android_server_hapdong.frag

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.imsihyun.android_server_hapdong.ApplicationController
import com.example.imsihyun.android_server_hapdong.MenuShopAdapter
import com.example.imsihyun.android_server_hapdong.NetworkService
import com.example.imsihyun.android_server_hapdong.R
import com.example.imsihyun.android_server_hapdong.get.GetShopResponse
import com.example.imsihyun.android_server_hapdong.get.GetShopResponseData
import kotlinx.android.synthetic.main.fragment_main_hansik.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMenuHansikFragment: Fragment() {
    lateinit var networkService : NetworkService
    lateinit var requestManager : RequestManager

    lateinit var mShopItems : ArrayList<GetShopResponseData>
    lateinit var mMenuShopAdapter : MenuShopAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.fragment_main_hansik, container, false)

        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this.activity)

        val getShopResponse = networkService.getShopContent()
        getShopResponse.enqueue(object : Callback<GetShopResponse> {
            override fun onFailure(call: Call<GetShopResponse>?, t: Throwable?) {
                Log.d("ZZANZU", "getting shop data / failure")
            }

            override fun onResponse(call: Call<GetShopResponse>?, response: Response<GetShopResponse>?) {
                if(response!!.isSuccessful) {
                    mShopItems = response.body().data
                    mMenuShopAdapter = MenuShopAdapter(mShopItems, requestManager)

                    shop_list_rv.adapter = mMenuShopAdapter
                    shop_list_rv.layoutManager = LinearLayoutManager(activity!!.applicationContext)
                }
            }

        })

        return mView

    }
}