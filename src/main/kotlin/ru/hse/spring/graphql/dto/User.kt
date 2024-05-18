package ru.hse.spring.graphql.dto

class User(
    val id: String,
    val name: String,
    email: String?

){
    val email: String? = email
        get() {
            println("I was called")
            return field
        }
}