package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val githubService = retrofit.create(GithubInfraService::class.java)

    suspend fun getUsersData() : List<User> {
        return githubService.getList()
    }

}