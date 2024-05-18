package ru.hse.spring.graphql.controller

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import ru.hse.spring.graphql.dto.User
import java.util.UUID

@Controller
class UserController{
    val mutableMap: MutableMap<String, User> = mutableMapOf()

    @QueryMapping
    fun findAllUsers():List<User> {
        return mutableMap.values.toList()
    }

    @QueryMapping
    fun findUserById(@Argument id: String): User {
        return mutableMap[id]!!
    }

    @MutationMapping
    fun createUser(@Argument name: String, @Argument email: String?): User {
        var id = UUID.randomUUID().toString()

        val user = User(id = id, name = name, email = email)

        mutableMap[name] = user

        return user
    }

}