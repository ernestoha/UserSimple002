package com.eha.usersimple002.ui

/**
 * Created by eherrera on 2019-09-21.
 */

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eha.usersimple002.R
import com.eha.usersimple002.adapter.UserRecycler
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import com.eha.usersimple002.api.User as UserApi
import com.eha.usersimple002.api.model.User as UserModel

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter : UserRecycler
    private var page : Int = 1
    private var per_page : Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBtn()
        initRecyclerView()
        addDataSet()

    }

    private fun initBtn(){
        var addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.apply {
            setOnClickListener {
                callAddUserActivity()
            }
        }
    }

    private fun addDataSet(){
        var userApi : UserApi = UserApi()
        val data : UserModel? = userApi.get(this.page, this.per_page)

        if (data != null) {
            userAdapter.submitList(data.data)
        } /*else {
//           TODO when NO_DATA_FOUND
        }*/
    }

    private fun initRecyclerView(){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            userAdapter = UserRecycler()
            adapter = userAdapter
        }
    }

     private fun callAddUserActivity() {
         val intent = Intent(this, AddUserActivity::class.java)
         startActivity(intent);
     }

}
