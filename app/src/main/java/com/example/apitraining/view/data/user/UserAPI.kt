package com.example.apitraining.view.data.user

import retrofit2.http.GET

interface UserAPI {

    @GET("users")
    suspend fun getUsers() : List<UserModel>
}