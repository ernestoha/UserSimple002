package com.eha.usersimple002.controller

/**
 * Created by eherrera on 2019-09-21.
 */

import com.eha.usersimple002.api.User as UserApi
import com.eha.usersimple002.api.model.User as UserModel

class User () {

    private var userApi = UserApi()

//    mutableListOf(
    fun getUsers() : UserModel? {
        val data = this.getUserList()
        return null
    }

    private fun getUserList() : UserModel?{
        return this.userApi.get(1,1)
    }

}