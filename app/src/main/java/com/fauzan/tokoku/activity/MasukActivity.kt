package com.fauzan.tokoku.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fauzan.tokoku.R
import com.fauzan.tokoku.helper.SharedPref
import kotlinx.android.synthetic.main.activity_masuk.*

class MasukActivity : AppCompatActivity() {

    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        s = SharedPref(this)
        mainButton()
    }
    private fun mainButton(){
        btn_proseslogin.setOnClickListener{
            s.setStatusLogin(true)
        }
        btn_register.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}