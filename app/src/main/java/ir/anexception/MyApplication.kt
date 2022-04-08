package ir.anexception

import android.app.Application
import ir.anexception.shamse.utility.AppPreferences

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)
    }
}