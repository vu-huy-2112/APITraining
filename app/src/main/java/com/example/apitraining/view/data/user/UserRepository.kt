package com.example.apitraining.view.data.user

import com.example.apitraining.view.data.RetrofitBuilder

class UserRepository private constructor(){
    private var userApi: UserAPI = RetrofitBuilder.getRetrofit().create(UserAPI::class.java)

    companion object{
        val instance: UserRepository = UserRepository()
    }

    suspend fun getUser() =userApi.getUsers()
}