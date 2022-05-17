package com.example.myapplication

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("id") val id : String,
    @SerializedName("login") val login : String
)