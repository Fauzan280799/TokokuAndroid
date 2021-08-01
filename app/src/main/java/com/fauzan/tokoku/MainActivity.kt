package com.fauzan.tokoku

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.fauzan.tokoku.activity.MasukActivity
import com.fauzan.tokoku.fargment.AkunFragment
import com.fauzan.tokoku.fargment.HomeFragment
import com.fauzan.tokoku.fargment.KeranjangFragment
import com.fauzan.tokoku.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //pemanggilan Fragment
    private val fragmentHome: Fragment = HomeFragment ()
    private val fragmentKeranjang: Fragment = KeranjangFragment ()
    private val fragmentAkun: Fragment = AkunFragment ()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentHome  // untuk menandai fragment default

    //membuat variabel menu
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var boottomNavigationView: BottomNavigationView

    private var statusLogin = false
    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setUpBottomNav()
    }
    fun setUpBottomNav(){
        //memasukkan fragment ke fragment manager
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang).hide(fragmentKeranjang).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()

        //untuk inisalisai boottom navigasi
        boottomNavigationView = findViewById(R.id.nav_view)
        menu = boottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        //membuat list perulangan array
        boottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_home ->{
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_keranjang ->{
                    callFragment(1, fragmentKeranjang)
                }
                R.id.navigation_akun ->{
                    if (s.getStatusLogin()){
                        callFragment(2, fragmentAkun)
                    }else{
                        startActivity(Intent(this, MasukActivity::class.java))
                    }
                }
            }
            false
        }
    }
    //pemanggilan fungsi array
    fun callFragment(int: Int, fragment: Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}