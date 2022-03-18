package ir.anexception.shamse.utility

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {

    private const val NAME = "ShamsePreferences"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val STATE_NAME = Pair("state_name", "")
    private val STATE_LATITUDE = Pair("state_latitude", -1.0)
    private val STATE_LONGITUDE = Pair("state_longitude", -1.0)





    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    var stateName: String?
        get() = preferences.getString(STATE_NAME.first, STATE_NAME.second)
        set(value) = preferences.edit() {
            it.putString(STATE_NAME.first, value)
        }

    var stateLatitude: Long
        get() = preferences.getLong(STATE_LATITUDE.first, STATE_LATITUDE.second.toLong())
        set(value) = preferences.edit() {
            it.putLong(STATE_LATITUDE.first, value)
        }

    var stateLongitude: Long
        get() = preferences.getLong(STATE_LONGITUDE.first, STATE_LONGITUDE.second.toLong())
        set(value) = preferences.edit() {
            it.putLong(STATE_LONGITUDE.first, value)
        }
}