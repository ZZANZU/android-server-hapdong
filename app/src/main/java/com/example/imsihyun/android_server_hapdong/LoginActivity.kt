package com.example.imsihyun.android_server_hapdong

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.imsihyun.android_server_hapdong.post.SignupResponse
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var networkService: NetworkService

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        networkService = ApplicationController.instance.networkService
        val user_id = RequestBody.create(MediaType.parse("signin"), login_id_edi.text.toString())
        val user_pwd = RequestBody.create(MediaType.parse("signin"), login_pw_edi.text.toString())
        val postSigninResponse = networkService.postSignup(user_id, user_pwd)

        val intent = Intent(Intent.ACTION_PICK)
        postSigninResponse.enqueue(object : Callback<SignupResponse> {
            override fun onFailure(call: Call<SignupResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<SignupResponse>?, response: Response<SignupResponse>?) {
                login_check_btn.setOnClickListener {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }
            }

        })


        login_signup_btn.setOnClickListener {
            val nextIntent = Intent(this, SignUpActivity::class.java)
            startActivity(nextIntent)
        }
    }
}
