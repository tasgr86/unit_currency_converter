package tasos.grigoris.unitcurrencyconverter

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserSelections(context: Context){

    private val prefs : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val type = object : TypeToken<HashMap<FRS, MyEnums>>() {}.type
    private var gson = Gson()
    private lateinit var map : HashMap<FRS, MyEnums>

    init {

        if (!prefs.contains("users_selections"))
            storeSelections(initMap())
        else
            map = getMap()

    }

    private fun storeSelections(map : HashMap<FRS, MyEnums>) {

        val hashMapString = Gson().toJson(map)
        prefs.edit().putString("users_selections", hashMapString).apply()

    }


    fun storeCurrency(currency : String) {

        prefs.edit().putString("last_currency", currency).apply()

    }


    fun getCurrency() : String {

        return prefs.getString("last_currency", "USD")

    }


    fun updateSelections(frsType: FRS, selection : MyEnums){

        map[frsType] = selection
        storeSelections(map)

    }


    private fun initMap() : HashMap<FRS, MyEnums>{

        map = HashMap()
        map[FRS.LENGTH]         = MyEnums.M
        map[FRS.WEIGHT]         = MyEnums.KG
        map[FRS.AREA]           = MyEnums.M_SQUARE
        map[FRS.FUEL]           = MyEnums.KM_L
        map[FRS.VOLUME]         = MyEnums.LITRE
        map[FRS.AREA]           = MyEnums.M_SQUARE
        map[FRS.POWER]          = MyEnums.WATTS
        map[FRS.DATA]           = MyEnums.BIT
        map[FRS.ENERGY]         = MyEnums.JOULE
        map[FRS.TEMPERATURE]    = MyEnums.CELSIUS
        map[FRS.SPEED]          = MyEnums.KMH

        return map

    }


    fun getMap() : HashMap<FRS, MyEnums>{

        val storedHashMapString = prefs.getString("users_selections", "")
        return gson.fromJson(storedHashMapString, type)

    }

}