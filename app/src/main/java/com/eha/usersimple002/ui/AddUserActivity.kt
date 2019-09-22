package com.eha.usersimple002.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.eha.usersimple002.R

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_user_dialog_fragment)

        initBtn()
    }

    private fun initBtn(){
        var cancelBtn = findViewById<Button>(R.id.cancelBtn)
        cancelBtn.apply {
            setOnClickListener {
                finish()
            }
        }
    }

}
