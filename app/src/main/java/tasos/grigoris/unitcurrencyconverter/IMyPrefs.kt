package tasos.grigoris.unitcurrencyconverter

import tasos.grigoris.unitcurrencyconverter.FixerApi.Model.FixerResponse

interface IMyPrefs {

    fun storeDecimal(decimalNumber : Int)

    fun getDecimals() : Int

    fun storeRates(rates: FixerResponse)

    fun getRates() : FixerResponse

    fun daysFromLastUpdate() : Int

    fun shouldUpdate() : Boolean

}