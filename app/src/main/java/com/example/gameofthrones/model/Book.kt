package com.example.gameofthrones.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "books")
data class Book(@PrimaryKey @SerializedName("isbn") val isbn: String,
                @SerializedName("url") val url: String,
                @SerializedName("name") val bookName: String,
                @SerializedName("authors") val authors: List<String>,
                @ColumnInfo(name = "number_of_pages") @SerializedName("numberOfPages") val numberOfPages: Int,
                @ColumnInfo(name = "released_date") @SerializedName("releasedDate") val releaseDate: String,
                @SerializedName("characters") val characterList: List<String>)