package com.example.imsihyun.android_server_hapdong

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_menu.*
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

class MainMenuFragment: Fragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.fragment_main_menu, container, false)

        mView.main_menu_hansik.setOnClickListener(this)
        mView.main_menu_chicken.setOnClickListener(this)
        mView.main_menu_pizza.setOnClickListener(this)
        mView.main_menu_yasik.setOnClickListener(this)

        return mView
    }

    override fun onClick(v: View?) {
        when(v) {
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

    fun replaceFragment(mFragment: Fragment) {
        val fm = activity!!.supportFragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.replace(R.id.main_menu_fragment, mFragment)
        mTransaction.commit()
    }
}