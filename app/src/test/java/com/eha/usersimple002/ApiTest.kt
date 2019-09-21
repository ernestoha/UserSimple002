package com.eha.usersimple002

import com.eha.usersimple002.api.User as UserApi
import com.eha.usersimple002.api.model.User as UserModel
import com.eha.usersimple002.entity.User as UserEntity
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ApiTest {

    @Test
    fun apiUserParams() {
        var userApi : UserApi = UserApi()
        val data : UserModel? = userApi.get(10, 1)
        if (data != null) {
            println("data page = $data.page")
//            for (s : UserEntity in data.data) {
            for (s in data.data) {
//                println(s.page)
//                println(s.firstName())
                println(s.first_name)
            }
        }
        assertNotNull(data)
    }
}
