package com.example.imsihyun.android_server_hapdong

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.imsihyun.android_server_hapdong.R.layout.fragment_main_menu
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_menu.*
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(MainMenuFragment())

        main_home_btn.setOnClickListener(this)
        main_bookmark_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            main_home_btn -> {
                replaceFragment(MainMenuFragment())
            }
            main_bookmark_btn -> {
                replaceFragment(MainBookmarkFragment())
            }


            main_menu_hansik -> {
                replaceFragment(MainMenuHansikFragment())
            }
            main_menu_chicken -> {
                replaceFragment(MainMenuChickenFragment())
            }
            main_menu_pizza -> {
                replaceFragment(MainMenuPizzaFragment())
            }
            main_menu_yasik -> {
                replaceFragment(MainMenuYasikFragment())
            }
        }
    }

    // 프래그먼트 적용
    fun addFragment(mFragment: Fragment) {  // Unit == void, 생략 가능
        val fm = supportFragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.add(R.id.main_menu_fragment, mFragment)
        mTransaction.addToBackStack(null)
        mTransaction.commit()
    }

    fun replaceFragment(mFragment: Fragment) {
        val fm = supportFragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.replace(R.id.main_menu_fragment, mFragment)
        mTransaction.commit()
    }
}
