package com.example.studio2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val CHANGE_BALANCE_REQUEST = 1
    private var balance = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        balance = intent!!.getIntExtra("total", 0)
        value_display.text = "$" + balance.toString()
    }

    fun changeBalance(view: View) {
        val addNameIntent = Intent(this, ChangeActivity::class.java)
        intent?.extras?.putInt("total", balance)
        startActivityForResult(addNameIntent, CHANGE_BALANCE_REQUEST)
    }

}
