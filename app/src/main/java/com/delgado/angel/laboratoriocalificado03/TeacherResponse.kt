package com.delgado.angel.laboratoriocalificado03

import com.google.gson.annotations.SerializedName

data class TeacherResponse(
    val name: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("phone_number") val phoneNumber: String,
    val email: String
)
