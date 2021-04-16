package com.example.dagger_kotlin_retrofit.data.share_pref

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharedPrefsUtils {
    var activity: Context? = null
    private var pref: SharedPreferences? = null
    private var utility: SharedPrefsUtils? = null
    private var editor: SharedPreferences.Editor? = null
    private var autoCommit = true

    fun getInstance(context: Context): SharedPrefsUtils? {
        if (utility == null) {
            utility = SharedPrefsUtils(context.applicationContext)
        }
        return utility
    }

    private fun SharedPrefsUtils(activity: Context, mode: Int) {
        autoCommit = true
        this.activity = activity
        pref = activity.getSharedPreferences(activity.packageName + "_preferences", mode)
        editor = pref?.edit()
    }

    constructor(activity: Context) {
        autoCommit = true
        this.activity = activity
        pref = activity.getSharedPreferences(
            activity.packageName + "_preferences",
            Context.MODE_PRIVATE
        )
        editor = pref?.edit();

    }

    constructor(activity: Activity, autoCommit: Boolean) {
        this.autoCommit = autoCommit
        this.activity = activity
        pref = PreferenceManager.getDefaultSharedPreferences(activity)
        editor = pref?.edit()
    }

    fun removeValue(key: String?) {
        editor!!.remove(key)
        if (autoCommit) commit()
    }

    fun putString(key: String?, value: String?) {
        editor!!.putString(key, value)
        if (autoCommit) {
            commit()
        }
    }

    fun getString(key: String?): String? {
        val defaultValue = ""
        return pref!!.getString(key, defaultValue)
    }

    fun putInt(key: String?, value: Int) {
        editor!!.putInt(key, value)
        if (autoCommit) {
            commit()
        }
    }

    fun getInt(key: String?): Int {
        val defaultValue = 0
        return pref!!.getInt(key, defaultValue)
    }

    fun putLong(key: String?, value: Long) {
        editor!!.putLong(key, value)
        if (autoCommit) {
            commit()
        }
    }

    fun getLong(key: String?): Long {
        val defaultValue: Long = 0
        return pref!!.getLong(key, defaultValue)
    }

    fun commit() {
        editor!!.commit()
    }

    fun getBoolean(key: String?): Boolean {
        val defaultValue = false
        return pref!!.getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String?, value: Boolean) {
        editor!!.putBoolean(key, value)
        if (autoCommit) {
            commit()
        }
    }

    fun putDouble(key: String?, value: Double) {
        editor!!.putString(key, value.toString())
        if (autoCommit) {
            commit()
        }
    }

    fun getDouble(key: String?): Double {
        var value = 0.0
        val valueStr = pref!!.getString(key, "0")
        if (valueStr != null) {
            value = java.lang.Double.valueOf(valueStr)
        }
        return value
    }

    fun isAutoCommit(): Boolean {
        return autoCommit
    }

    fun setAutoCommit(autoCommit: Boolean) {
        this.autoCommit = autoCommit
    }

    fun containsKey(key: String?): Boolean {
        return pref!!.contains(key)
    }

    private fun SharedPrefsUtils() {}
}