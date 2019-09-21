package com.eha.usersimple002.api.model

/**
 * Created by eherrera on 2019-09-21.
 */


data class UserData (val id: Int, val email: String, val first_name: String, val last_name: String, val avatar: String) {
    /*public val firstName() : String {
        return this.first_name
    }*/
}

data class User (val page: Int, val per_page: Int, val total: Int, val total_page: Int, val data: List<UserData>) {
//data class User (val page: Int, val per_page: Int, val total: Int, val total_page: Int, val data: Collection<UserEntity>) {
//data class User (val page: Int, val per_page: Int, val total: Int, val total_page: Int, val data: MutableList<UserEntity>) {
}

