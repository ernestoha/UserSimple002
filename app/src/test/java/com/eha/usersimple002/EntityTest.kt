package com.eha.usersimple002

import com.eha.usersimple002.entity.User as userEntity
import com.eha.usersimple002.api.User as userApi
import org.junit.Assert.assertEquals
import org.junit.Test
//import android.util.Log

//import com.eha.usersimple002.entity

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class EntityTest {

    @Test
    fun constructorUser4ParamsCheckId() {
        var user = userEntity("ernesto@", "ernesto", "herrera", "avatar x")
        assertEquals(user.firstName, "ernesto")
        //Check add id
        user.id = 1
        assertEquals(user.id, 1)
        //Log.i("TAG", "test01")
    }

    @Test
    fun constructorUser5Params() {
        var user = userEntity(1, "ernesto@", "ernesto", "herrera", "avatar x")
        assertEquals(user.firstName, "ernesto")
    }

    @Test
    fun apiUserParams() {
        var userApi = userApi()
        userApi.get(10, 1)
//        assertEquals(userApi.firstName, "ernesto")
    }
}
