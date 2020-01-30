package com.example.studio2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_deposit.*

class DepositFragment : Fragment() {

    var total = 0

override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)

    val intent = activity!!.intent
    total = intent!!.getIntExtra("total", 0)
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deposit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        deposit_button.setOnClickListener {
            val deposit_amt = Integer.parseInt(deposit_value.text.toString())

            val intent = Intent (activity, MainActivity::class.java)
            intent.putExtra("total", deposit_amt+total)
            activity!!.startActivity(intent)

        }
    }


}
