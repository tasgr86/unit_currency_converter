package tasos.grigoris.unitcurrencyconverter

import android.app.Application
import tasos.grigoris.unitcurrencyconverter.Database.MyDB

class MyApplication : Application() {

    override fun onCreate() {

        super.onCreate()
        MyDB.initDatabase(this)

    }

}