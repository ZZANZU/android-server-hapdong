package com.example.imsihyun.android_server_hapdong

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.imsihyun.android_server_hapdong.post.RegisterResponse
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import kotlinx.android.synthetic.main.activity_register.*
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.InputStream

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var networkService     : NetworkService
    lateinit var data               : Uri
    lateinit var requestManager     : RequestManager
    private  var registerImag       : MultipartBody.Part? = null
    private var REQ_CODE_SELECT_IMAGE  = 100


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this)
        val toolbar     = findViewById(R.id.register_toolbar) as Toolbar

        // 액션바에 툴바 입히기
        setSupportActionBar(toolbar)

        register_img_btn.setOnClickListener(this)
        register_complete_btn.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v) {
            register_img_btn -> {
                changeImage()
            }
            register_complete_btn -> {
                postRegister()
            }
            register_add_btn -> {
                // plusEdit()
                // 메뉴 설명에서 + 클릭 시, edittext 추가 동작
            }
        }
    }

    // 액션버튼 메뉴 액션바에 배치하기
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.register_menu, menu)
        return true
    }

    // 액션버튼 클릭했을 때
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_add -> {
                //추가 버튼 눌렀을 때
                Toast.makeText(applicationContext, "No Action!", Toast.LENGTH_SHORT).show()
                return super.onOptionsItemSelected(item)
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    // 등록하기
    fun postRegister() {
        val shop_category   = RequestBody.create(MediaType.parse("text/plain"), register_category_et.text.toString())
        val shop_name       = RequestBody.create(MediaType.parse("text/plain"), register_name_et.text.toString())
        val shop_content    = RequestBody.create(MediaType.parse("text/plain"), register_content_et.text.toString())
        val shop_info       = RequestBody.create(MediaType.parse("text/plain"), register_info_et.text.toString())
        val menu_name       = RequestBody.create(MediaType.parse("text/plain"), register_menu_name_et.text.toString())
        val menu_price      = RequestBody.create(MediaType.parse("text/plain"), register_menu_price_et.text.toString())

        val postRegisterResponse = networkService.postRegister(shop_name, shop_category, shop_content,
                registerImag, shop_info, menu_name, menu_price)

        postRegisterResponse.enqueue(object : Callback<RegisterResponse> {
            override fun onFailure(call: Call<RegisterResponse>?, t: Throwable?) {
                Log.d("TAG", "register failure")
            }

            override fun onResponse(call: Call<RegisterResponse>?, response: Response<RegisterResponse>?) {
                Log.d("TAG", "register post response")
                if(response!!.isSuccessful) {
                    Log.d("TAG", "register post response!!.isSuccessful")
                    Toast.makeText(applicationContext, "Register Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }
            }

        })
    }

    // Image
    fun changeImage(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)
    }

    // Image 동작
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    this.data = data!!.data
                    Log.v("이미지", this.data.toString())

                    val options = BitmapFactory.Options()

                    var input: InputStream? = null
                    try {
                        input = contentResolver.openInputStream(this.data)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    val bitmap = BitmapFactory.decodeStream(input, null, options) // InputStream 으로부터 Bitmap 을 만들어 준다.
                    val baos = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos)
                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray())
                    val photo = File(this.data.toString())

                    registerImag = MultipartBody.Part.createFormData("photo", photo.name, photoBody)

                    //body = MultipartBody.Part.createFormData("image", photo.getName(), profile_pic);

                    Glide.with(this)
                            .load(data.data)
                            .centerCrop()
                            .into(register_img_btn)

                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun plusEdit() {

    }

}