package com.example.graphqltutorial.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.graphqltutorial.TripRepository
import com.example.graphqltutorial.model.User
import com.example.graphqltutorial.UserRepository
import org.springframework.stereotype.Component

@Component
class Query(val userRepository: UserRepository, val tripRepository: TripRepository) : GraphQLQueryResolver {
    fun version() = "1.0.0"

    fun user(id: String): User? =
        userRepository.findUser(id).let {
            if(it != null) {
                return it.getUser()
            }
            return null
        }

    fun users(): List<User> =
        userRepository.findUsers().map {
            it.getUser()
        }

}

