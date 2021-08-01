package com.fauzan.tokoku.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fauzan.tokoku.R
import com.fauzan.tokoku.helper.SharedPref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPref(this)
        btn_proseslogin.setOnClickListener{
            s.setStatusLogin(true)
        }
    }
}