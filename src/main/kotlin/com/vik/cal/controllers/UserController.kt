package com.vik.cal.controllers

import com.vik.cal.db.documents.User
import com.vik.cal.db.helpers.UserService
import com.vik.cal.utils.Constants
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping(Constants.ApiPaths.USERS)
    suspend fun createUser(@RequestBody user: User): User {
        return userService.createUser(user)
    }

    @GetMapping(Constants.ApiPaths.USER_BY_ID)
    suspend fun getUserById(@PathVariable id: String): User? {
        return userService.getUserById(id)
    }

    @GetMapping(Constants.ApiPaths.USERS)
    fun getAllUsers(): Flow<User> {
        return userService.getAllUsers()
    }

    @DeleteMapping(Constants.ApiPaths.USER_BY_ID)
    suspend fun deleteUser(@PathVariable id: String) {
        userService.deleteUser(id)
    }
}