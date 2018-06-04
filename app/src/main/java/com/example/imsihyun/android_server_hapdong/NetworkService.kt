package com.example.imsihyun.android_server_hapdong

import com.example.imsihyun.android_server_hapdong.post.RegisterResponse
import com.example.imsihyun.android_server_hapdong.post.SigninResponse
import com.example.imsihyun.android_server_hapdong.post.SignupResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    // 회원가입
    @FormUrlEncoded
    @POST("signup")
    fun postSignup (
            @Field("user_id")    user_id        : RequestBody,
            @Field("user_pw")    user_pwd       : RequestBody
    ) : Call<SignupResponse>

    // 로그인
    @POST("singin")
    fun postSignin (
            @Field("user_id")    user_id         : RequestBody,
            @Field("user_pw")    user_pwd        : RequestBody
    ) : Call<SigninResponse>

    // 샵 등록하기
    @Multipart
    @POST("register/shop")
    fun postRegister (
            @Part("shop_name")     shop_name            : RequestBody,
            @Part("shop_category") shop_category        : RequestBody,
            @Part("shop_content")  shop_content         : RequestBody,
            @Part registerImag                                : MultipartBody.Part?,
            @Part("shop_info")     shop_info            : RequestBody,
            @Part("menu_name")     menu_name            : RequestBody,
            @Part("menu_price")    menu_price           : RequestBody
    ) : Call<RegisterResponse>
}