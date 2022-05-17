package com.example.myapplication

import retrofit2.http.GET


interface GithubInfraService {

    @GET("users")
    suspend fun getList() : List<User>
}