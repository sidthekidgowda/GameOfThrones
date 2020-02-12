package com.example.gameofthrones.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.StringUtils
import java.text.SimpleDateFormat
import java.util.*

@Entity (tableName = "books")
data class Book(

    @PrimaryKey
    @SerializedName("isbn") val isbn: String,

    @SerializedName("url") val url: String,

    @SerializedName("name") val bookName: String,

    @SerializedName("authors") val authors: List<String>,

    @ColumnInfo(name = "number_of_pages")
    @SerializedName("numberOfPages") val numberOfPages: Int,

    @ColumnInfo(name = "released")
    @SerializedName("released") val releaseDate: String,

    @SerializedName("characters") val characterList: List<String>) {

    fun getFormattedDate(): String {
        if (!releaseDate.isNullOrEmpty()) {
            val simpleDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

            try {
                val date = simpleDate.parse(releaseDate)
                val formattedDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
                return formattedDateFormat.format(date)
            } catch (e: Exception) {

            }
        }
        return StringUtils.EMPTY
    }
}