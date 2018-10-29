package tasos.grigoris.unitcurrencyconverter.Database

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream

//  http://www.ajsofts.com/2017/11/android-sqlite-database-handling-with.html


open class MyDB constructor(_context: Context) : SQLiteOpenHelper(_context, "LjDatabase", null, 1) {

    var context : Context = _context

    companion object {

        var database: SQLiteDatabase? = null


        fun initDatabase(context: Context) {
            database = MyDB(
                context
            ).writableDatabase

        }

    }

    override fun onCreate(db: SQLiteDatabase?) {}

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}


    @SuppressLint("WrongConstant")
    private fun copyDatabase(dbFile: File) {

        val `is` = context.assets.open(databaseName)
        val os = FileOutputStream(dbFile)

        val buffer = ByteArray(1024)
        while (`is`.read(buffer) > 0) {
            os.write(buffer)
            Log.d("#DB", "writing>>")
        }

        os.flush()
        os.close()
        `is`.close()
        Log.d("#DB", "completed..")

    }


}