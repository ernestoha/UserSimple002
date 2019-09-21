package com.eha.usersimple002

import com.eha.usersimple002.controller.User as UserCtrl
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ControllerTest {

    @Test
    fun apiUserParams() {
        var userCtrl = UserCtrl()
        val u1 = userCtrl.getUsers()
        print("init")
//        if (u1 != null) {
//            for (s in u1) print(s.firstName)
//        }
        print("end")
//        assertEquals(UserApi.firstName, "ernesto")
    }
}
