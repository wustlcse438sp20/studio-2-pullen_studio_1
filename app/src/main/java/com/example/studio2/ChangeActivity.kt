package com.example.studio2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_change.*

class ChangeActivity : AppCompatActivity() {

    private var currentState = 0
    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)
        var bundle: Bundle ?=intent.extras
        total = bundle!!.getInt("total")
    }

    override fun onStart() {
        super.onStart()
        //set the initial fragment
        val fragment = DepositFragment()
        var bundle = Bundle()
        bundle.putInt("total", total)
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    fun switchView(view: View){
        if (currentState == 0){
            currentState = 1
            val fragment = WithdrawFragment()
            var bundle = Bundle()
            bundle.putInt("total", total)
            fragment.arguments = bundle
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
        }else{
            currentState = 0
            val fragment = DepositFragment()
            var bundle = Bundle()
            bundle.putInt("total", total)
            fragment.arguments = bundle
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
        }
    }


}
