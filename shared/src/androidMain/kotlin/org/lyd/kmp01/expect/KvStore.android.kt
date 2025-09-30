package org.lyd.kmp01.expect

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import org.lyd.kmp01.dataStore.KeyValuesStorage
//
//class AndroidKvStore(
//    private val dataStore: DataStore<Preferences>
//): KeyValuesStorage {
//    override fun putString(key: String, value: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getString(key: String, default: String?): String? {
//        TODO("Not yet implemented")
//    }
//
//    override fun putInt(key: String, value: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getInt(key: String, default: Int): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun putBoolean(key: String, value: Boolean) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getBoolean(key: String, default: Boolean): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun remove(key: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun clear() {
//        TODO("Not yet implemented")
//    }
//
//}
//
//fun getAndroidContext(): Context
//
//actual fun getKvStore(): KeyValuesStorage {
//    val androidDataStore = PreferenceDataStoreFactory.create {
//
//    }
//}