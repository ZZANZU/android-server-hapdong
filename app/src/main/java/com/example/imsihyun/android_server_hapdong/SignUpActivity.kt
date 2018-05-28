package com.example.imsihyun.android_server_hapdong

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.imsihyun.android_server_hapdong.post.SignupResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        lateinit var networkService: NetworkService

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        networkService = ApplicationController.instance.networkService
        val user_id = RequestBody.create(MediaType.parse("signup"), signup_id_edit.text.toString())
        val user_pwd = RequestBody.create(MediaType.parse("signup"), signup_pw_edit.text.toString())
        val postSignupResponse = networkService.postSignup(user_id, user_pwd)

         postSignupResponse.enqueue(object : Callback<SignupResponse> {
            override fun onFailure(call: Call<SignupResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<SignupResponse>?, response: Response<SignupResponse>?) {
                if(response!!.isSuccessful) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }
            }

        })
    }
}
