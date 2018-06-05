package com.example.imsihyun.android_server_hapdong.frag

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imsihyun.android_server_hapdong.MainActivity
import com.example.imsihyun.android_server_hapdong.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_main_menu.*
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

class MainMenuFragment: Fragment(), View.OnClickListener {
    lateinit var mToolBar: Toolbar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.fragment_main_menu, container, false)

        mToolBar = activity!!.main_menu_toolbar
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        mToolBar.setNavigationOnClickListener({
            startActivity(Intent(activity!!.applicationContext, MainActivity::class.java))
        })

        mView.main_menu_hansik.setOnClickListener(this)
        mView.main_menu_chicken.setOnClickListener(this)
        mView.main_menu_pizza.setOnClickListener(this)
        mView.main_menu_yasik.setOnClickListener(this)

        return mView
    }

    override fun onClick(v: View?) {
        when(v) {
            main_menu_hansik -> {
                mToolBar.main_toolbar_tv.setText("한식")
                replaceFragment(MainMenuHansikFragment())
            }
            main_menu_chicken -> {
                mToolBar.main_toolbar_tv.setText("치킨")
                replaceFragment(MainMenuChickenFragment())
            }
            main_menu_pizza -> {
                mToolBar.main_toolbar_tv.setText("피자")
                replaceFragment(MainMenuPizzaFragment())
            }
            main_menu_yasik -> {
                mToolBar.main_toolbar_tv.setText("야식")
                replaceFragment(MainMenuYasikFragment())
            }
//            main_menu_toolbar -> {
//                startActivity(Intent(activity!!.applicationContext, MainActivity::class.java))
//            }
        }
    }

    fun replaceFragment(mFragment: Fragment) {
        val fm = activity!!.supportFragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.replace(R.id.main_menu_fragment, mFragment)
        mTransaction.commit()
    }
}