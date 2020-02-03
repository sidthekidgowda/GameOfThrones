package com.example.gameofthrones.model

import com.google.gson.annotations.SerializedName

data class Book(@SerializedName("isbn") val isbn: String,
                @SerializedName("url") val url: String,
                @SerializedName("name") val bookName: String,
                @SerializedName("authors") val authors: List<String>,
                @SerializedName("numberOfPages") val numberOfPages: Int,
                @SerializedName("releasedDate") val releaseDate: String,
                @SerializedName("characters") val characterList: List<String>)