package com.delgado.angel.laboratoriocalificado03

import retrofit2.Response
import retrofit2.http.GET

interface TeacherApi {

    @GET("list/teacher-b")
    suspend fun getTeachers(): Response<TeacherListResponse>

}