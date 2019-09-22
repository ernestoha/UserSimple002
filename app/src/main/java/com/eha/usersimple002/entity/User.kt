package com.eha.usersimple002.entity

/**
 * Created by eherrera on 2019-09-21.
 */

data class User (
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
) {
    /*public val firstName() : String {
        return this.first_name
    }*/
}
