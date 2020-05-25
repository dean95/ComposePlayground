package com.dean.composeplayground.exam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ExamActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, ExamActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}