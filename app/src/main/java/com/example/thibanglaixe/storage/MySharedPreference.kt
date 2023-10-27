package com.example.thibanglaixe.storage

import android.content.Context
import android.content.SharedPreferences


class MySharedPreference(private val context: Context) {
    companion object{
        private val MY_SHARE_PREFERENCES = "MY_SHARE_PREFERENCES"
    }

    fun putStringValue(key: String, value: String){
        val sharedPreference = context.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringValue(key: String): String? {
        val sharedPreference = context.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreference.getString(key, "")
    }

    fun getAllKey(): MutableMap<String, *>? {
        val sharedPreference =
            context.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreference.all
    }

    fun findKey(value: String): String? {
        val sharedPreference = context.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE)
        for ((key, value1) in sharedPreference.all) {
            if (value == value1) {
                return key
            }
        }
        return null // not found
    }
}