package com.vik.cal.utils

class Constants {
    object ApiPaths {
        const val BASE_API = "/api/1.0"
        const val USERS = "$BASE_API/users"
        const val USER_BY_ID = "$USERS/{id}"
    }
    object HeaderKeys {
        const val AUTHORIZATION = "Authorization"
    }
}