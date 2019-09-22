package com.eha.usersimple002

import com.eha.usersimple002.entity.User as UserEntity
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class EntityTest {

    /*@Test
    fun constructorUser4ParamsCheckId() {
        var user = UserEntity("ernesto@", "ernesto", "herrera", "avatar x")
        assertEquals(user.firstName, "ernesto")
        //Check add id
        user.id = 1
        assertEquals(user.id, 1)
        //Log.i("TAG", "test01")
    }*/

    @Test
    fun constructorUser5Params() {
        var user = UserEntity(1, "ernesto@", "ernesto", "herrera", "avatar x")
//        assertEquals(user.firstName, "ernesto")
        assertEquals(user.first_name, "ernesto")
    }

}
