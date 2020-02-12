package com.example.gameofthrones.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BooksTypeConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun stringToList(data: String): List<String> {
            if (data == null) return emptyList()

            val gson = Gson()
            val typeToken = object : TypeToken<List<String>>() {}.type
            return Gson().fromJson(data, typeToken)
        }

        @TypeConverter
        @JvmStatic
        fun listToString(strings: List<String>): String {
            return Gson().toJson(strings)
        }
    }
}