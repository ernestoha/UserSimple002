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
    fun apiUserParamsOBJECT() {
        var userApi : UserApi = UserApi()
        val data : UserModel? = userApi.getObject(1, 6)
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

    fun apiUserParamsJSONSTRING() {
        var userApi : UserApi = UserApi()
        val data : String? = userApi.get(1, 6)
        println(data)
        assertNotNull(data)
    }
}
