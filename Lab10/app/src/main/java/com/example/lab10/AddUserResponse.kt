package com.example.lab10

import com.google.gson.annotations.SerializedName

data class AddUserResponse (
    @SerializedName("id")
    var id: Int,
)