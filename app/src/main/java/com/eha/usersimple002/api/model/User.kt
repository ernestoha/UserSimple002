package com.eha.usersimple002.api.model

/**
 * Created by eherrera on 2019-09-21.
 */
import com.eha.usersimple002.entity.User as UserEntity

data class User (
    val page: Int,
    val per_page: Int,
    val total: Int, val
    total_page: Int,
    val data: List<UserEntity>)
{
}

