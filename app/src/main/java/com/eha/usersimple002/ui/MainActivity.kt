package com.eha.usersimple002.ui

/**
 * Created by eherrera on 2019-09-21.
 */

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eha.usersimple002.R
import com.eha.usersimple002.adapter.UserRecycler
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL
import com.eha.usersimple002.api.User as UserApi
import com.eha.usersimple002.entity.User as UserEntity
import com.eha.usersimple002.api.model.User as UserModel

class MainActivity : AppCompatActivity() {

    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.context = this

        initBtn()
        getUsers().execute()
    }

    private fun initBtn(){
        var addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.apply {
            setOnClickListener   {
                callAddUserActivity()
            }
        }
    }

    private fun callAddUserActivity() {
         val intent = Intent(this, AddUserActivity::class.java)
         startActivity(intent);
     }

    internal inner class getUsers : AsyncTask<Void, Void,String>(){
        lateinit var progressDialog : ProgressDialog
        private lateinit var userAdapter : UserRecycler
        private val userApi : UserApi = UserApi()
        private var page : Int = 1
        private var per_page : Int = 100
        private var hasInternet = false

        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(context)
            progressDialog.setMessage(getString(R.string.loading_user_msg))
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        override fun doInBackground(vararg p0: Void?): String? {
            if (isNetworkAvailable()){
                hasInternet = true
                return userApi.get(page, per_page)
            } else {
                return null //"No Intenet"
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            progressDialog.dismiss()
            if (hasInternet && result!=null){
//                this.userAdapter.submitList(result.data)
                val data = userApi.mapFromJson(result)
                if (data != null){
                    this.initRecyclerView()
                    this.userAdapter.submitList(data.data)
                    var txtFoot = findViewById<TextView>(R.id.txtFoot)
                    txtFoot.setText("Page: " + data.page  + ". Total: " + data.total)
                }
            }
        }

        private fun isNetworkAvailable() : Boolean {
            //TODO https://youtu.be/lzqG4DAAork?t=329
            return true
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
    }

}
