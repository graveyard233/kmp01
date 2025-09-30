package org.lyd.kmp01.dataStore

interface KeyValuesStorage {
    fun putString(key: String, value: String)
    fun getString(key: String, default: String?): String?
    fun putInt(key: String, value: Int)
    fun getInt(key: String, default: Int): Int
    fun putBoolean(key: String, value: Boolean)
    fun getBoolean(key: String, default: Boolean): Boolean
    fun remove(key: String)
    fun clear()
}

internal const val dataStoreFileName = "dice.preferences_pb"