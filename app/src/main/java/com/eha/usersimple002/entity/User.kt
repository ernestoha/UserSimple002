package com.eha.usersimple002.entity

/**
 * Created by eherrera on 2019-09-21.
 */

class User constructor(email: String, firstName: String, lastName: String, avatar: String) {
        var id: Int? = null
        var email: String = email
        var firstName: String = firstName
        var lastName: String = lastName
        var avatar: String = avatar

    constructor(id: Int, email: String, firstName: String, lastName: String, avatar: String)
            : this(email, firstName, lastName, avatar) {
        this.id = id
    }

}
