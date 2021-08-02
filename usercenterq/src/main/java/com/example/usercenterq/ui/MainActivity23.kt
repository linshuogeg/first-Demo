package com.example.usercenterq.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usercenterq.R
import kotlinx.android.synthetic.main.activity_main23.*

class MainActivity23 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main23)

        cancel_search.setOnClickListener {
            search_history.btuInit(search.text.toString())
            search_history.btu_Build()
            search.build_Edit()
        }
    }
}