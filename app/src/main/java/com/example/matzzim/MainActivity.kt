package com.example.matzzim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.matzzim.httpMessage.HttpHelper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val httpHelper : HttpHelper = HttpHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInBtn.setOnClickListener{
            var email : String = emailPlainText.text.toString()
            var password : String = pwdPlainText.text.toString()

            println(email + password)
            httpHelper.getProductList()
        }

    }
}
