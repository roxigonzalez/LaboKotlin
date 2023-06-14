package com.example.laboratorio11.network.dto.register

// Create RegisterRequest data class
data class RegisterRequest(
    val email: String,
    val name: String,
    val password: String
)