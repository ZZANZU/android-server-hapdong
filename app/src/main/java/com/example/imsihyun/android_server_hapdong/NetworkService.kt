package com.example.imsihyun.android_server_hapdong

import com.example.imsihyun.android_server_hapdong.post.SigninResponse
import com.example.imsihyun.android_server_hapdong.post.SignupResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface NetworkService {
    // 회원가입
    @Multipart
    @POST("signup")
    fun postSignup (
            @Part("user_id")    user_id        : RequestBody,
            @Part("user_pw")    user_pwd       : RequestBody
    ) : Call<SignupResponse>

    // 로그인
    @POST("singin")
    fun postSignin (
            @Part("user_id")    user_id         : RequestBody,
            @Part("user_pw")    user_pwd        : RequestBody
    ) : Call<SigninResponse>
}