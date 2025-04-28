package com.vik.cal.db.helpers

import com.vik.cal.db.documents.User
import com.vik.cal.db.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    suspend fun createUser(user: User): User {
        return userRepository.save(user).awaitSingle()
    }

    suspend fun getUserById(id: String): User? {
        return userRepository.findById(id).awaitSingleOrNull()
    }

    fun getAllUsers(): Flow<User> {
        return userRepository.findAll().asFlow()
    }

    suspend fun deleteUser(id: String) {
        userRepository.deleteById(id).awaitSingleOrNull()
    }
}
