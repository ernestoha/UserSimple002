package com.eha.usersimple002.api

/**
 * Created by eherrera on 2019-09-21.
 */

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL
import com.eha.usersimple002.api.model.User as UserModel

//import android.util.Log

class User () {

    private val URL = "https://reqres.in/api/users" //DEV URL
//    private val url = "https://reqres.in/api/users" //TEST URL
//    private val url = "https://reqres.in/api/users" //PROD URL

    fun getObject(page: Int, per_page: Int):UserModel? {
        val dataString : String? = get(page, per_page)
        return mapFromJson(dataString)
    }

    fun get(page: Int, per_page: Int):String? {
//        return null
//        val testJson = """{"page":1,"per_page":6,"total":12,"total_pages":2,"data":[{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"},{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"},{"id":3,"email":"emma.wong@reqres.in","first_name":"Emma","last_name":"Wong","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"},{"id":4,"email":"eve.holt@reqres.in","first_name":"Eve","last_name":"Holt","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"},{"id":5,"email":"charles.morris@reqres.in","first_name":"Charles","last_name":"Morris","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"},{"id":6,"email":"tracey.ramos@reqres.in","first_name":"Tracey","last_name":"Ramos","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"}]}"""
//        val testJson = """{"page":1,"per_page":1,"total":1,"total_pages":12,"data":[{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/senior_android_engineer_kaushik_gopal.png"}]}"""
//        val test : UserModel? = this.mapFromJson(testJson)
//        return test
        val client = OkHttpClient()
        val url = URL("$URL?page=$page&per_page=$per_page")
        val request = Request.Builder()
            .url(url)
            .get()
            .build()
        val response = client.newCall(request).execute()
        var responseBody = response.body!!.string()
        return responseBody
    }

    fun mapFromJson(json : String?) : UserModel?{
        val gson = Gson()
        var data : UserModel = gson.fromJson(json, UserModel::class.java)
        return data
    }
}
