package com.example.laboratorio11.network.dto.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("ms") val message: String
)