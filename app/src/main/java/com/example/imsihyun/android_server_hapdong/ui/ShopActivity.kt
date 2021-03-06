package com.example.imsihyun.android_server_hapdong.ui

import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.example.imsihyun.android_server_hapdong.R

import kotlinx.android.synthetic.main.activity_shop.*

class ShopActivity : AppCompatActivity() {
    lateinit var mToolBar: Toolbar

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        shop_name_tv.text = intent.getStringExtra("name")

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        mToolBar = shop_toolbar
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        mToolBar.setNavigationOnClickListener({
            this.finish()
            // startActivity(Intent(this, MainActivity::class.java))
        })

        var shopName: String = intent.getStringExtra("shop_name")
        mToolBar.setTitle(shopName)
        mToolBar.setTitleTextColor(resources.getColor(R.color.white))

        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_shop, menu)
        return true
    }

    // 상단바 메뉴
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return ShopMenuFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            return 3
        }
    }
}
