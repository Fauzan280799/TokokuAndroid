package com.fauzan.tokoku.fargment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.fauzan.tokoku.R
import com.fauzan.tokoku.helper.SharedPref

class AkunFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btnLogout:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)
        btnLogout = view.findViewById(R.id.btn_logout)

        s = SharedPref(activity!!)

        btnLogout.setOnClickListener{
            s.setStatusLogin(false)
    }
        return view
    }
}