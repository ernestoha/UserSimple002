package com.eha.usersimple002.api

import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL
import android.media.MediaCodecInfo
//import android.util.Log

class User constructor() {

    val URL = "https://reqres.in/api/users" //DEV URL
//    val url = "https://reqres.in/api/users" //TEST URL
//    val url = "https://reqres.in/api/users" //PROD URL

    fun get(page: Int, per_page: Int):String {
        val client = OkHttpClient()
//        "https://reqres.in/api/users?page=2"
//        val url = "$URL=?page=$page&per_page=$per_page"
        val url = URL("$URL?page=$page&per_page=$per_page")
        println(url)

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        val response = client.newCall(request).execute()

        val responseBody = response.body!!.string()

        //Response
        println("Response Body: " + responseBody)

        //we could use jackson if we got a JSON
        /*val mapperAll = ObjectMapper()
        val objData = mapperAll.readTree(responseBody)

        objData.get("data").forEachIndexed { index, jsonNode ->
            println("$index $jsonNode")
        }*/
        return responseBody
    }
}
