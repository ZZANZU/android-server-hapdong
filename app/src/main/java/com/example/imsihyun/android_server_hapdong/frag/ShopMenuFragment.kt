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
import com.example.imsihyun.android_server_hapdong.*
import com.example.imsihyun.android_server_hapdong.post.PostShopResponse
import com.example.imsihyun.android_server_hapdong.post.PostShopResponseData
import kotlinx.android.synthetic.main.fragment_shop.*
import kotlinx.android.synthetic.main.item_menu_name.*
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ShopMenuFragment : Fragment() {
    lateinit var networkService : NetworkService
    lateinit var requestManager : RequestManager
    lateinit var ShopMenuItems  : ArrayList<PostShopResponseData>
    lateinit var menuNameAdapter: MenuNameAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_shop, container, false)

        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this.activity)

//        val shop_name  = RequestBody.create(MediaType.parse("text/plain"), menu_name_tv.text.toString())
//        val shop_price = RequestBody.create(MediaType.parse("text/plain"), menu_price_tv.text.toString())
//        val postShop = networkService.postShopMenu(shop_name, shop_price)

//        postShop.enqueue(object : Callback<PostShopResponse> {
//            override fun onFailure(call: Call<PostShopResponse>?, t: Throwable?) {
//            }
//
//            override fun onResponse(call: Call<PostShopResponse>?, response: Response<PostShopResponse>?) {
//                if(response!!.isSuccessful) {
//                    ShopMenuItems = response.body().data
//                    menuNameAdapter = MenuNameAdapter(ShopMenuItems, requestManager)
//
//                    shop_rv.adapter = menuNameAdapter
//                    shop_rv.layoutManager = LinearLayoutManager(activity!!.applicationContext)
//                }
//            }
//        })
        return rootView
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): ShopMenuFragment {
            val fragment = ShopMenuFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
