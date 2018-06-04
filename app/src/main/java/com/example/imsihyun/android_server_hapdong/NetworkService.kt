package com.example.imsihyun.android_server_hapdong

import com.example.imsihyun.android_server_hapdong.get.GetShopResponse
import com.example.imsihyun.android_server_hapdong.post.SigninResponse
import com.example.imsihyun.android_server_hapdong.post.SignupResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    // 회원가입
    @FormUrlEncoded
    @POST("signup")
    fun postSignup (
            @Field("user_id") user_id : RequestBody,
            @Field("user_pw") user_pwd : RequestBody
    ) : Call<SignupResponse>

    // 로그인
    @POST("singin")
    fun postSignin (
            @Field("user_id") user_id : RequestBody,
            @Field("user_pw") user_pwd : RequestBody
    ) : Call<SigninResponse>

    // 가게(샵) 목록 불러오기, 테스트를 위해 한식만 불러옴
    @GET("shop/1")
    fun getShopContent() : Call<GetShopResponse>
}