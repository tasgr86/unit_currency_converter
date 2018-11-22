package tasos.grigoris.unitcurrencyconverter

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import tasos.grigoris.unitcurrencyconverter.FixerApi.Model.FixerResponse
import com.google.gson.reflect.TypeToken
import org.joda.time.Days
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

class MyPrefs(context: Context) : IMyPrefs{

    private val prefs : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val type = object : TypeToken<FixerResponse>() {}.type
    private var gson = Gson()
    private val daysForUpdate = 1

    override fun storeDecimal(decimalNumber : Int) {

        val str = gson.toJson(decimalNumber, Integer::class.java)
        prefs.edit().putString("decimals_number", str).apply()

    }

    override fun getDecimals(): Int {

        if (!prefs.contains("decimals_number"))
            return 2

        val str = prefs.getString("decimals_number", null)
        return gson.fromJson(str, Int::class.java)!!

    }


    override fun storeRates(rates : FixerResponse) {

        val serializedRates = gson.toJson(rates, type)
        prefs.edit().putString("fixer_rates", serializedRates).apply()

    }

    override fun getRates(): FixerResponse {

        val serializedRates = prefs.getString("fixer_rates", null)

        if (serializedRates == null)
            return FixerResponse()

        return gson.fromJson(serializedRates, FixerResponse::class.java)!!

    }

    override fun daysFromLastUpdate(): Int {

        val lastDateStr = getRates().date
        val fmt = DateTimeFormat.forPattern("yyyy-MM-dd")
        val lastUpdate = LocalDate(fmt.parseLocalDate(lastDateStr))

        return Days.daysBetween(lastUpdate, LocalDate.now()).days

    }

    override fun shouldUpdate(): Boolean {

        return if (getRates().timestamp == null) true
        else daysFromLastUpdate() > daysForUpdate

    }

}