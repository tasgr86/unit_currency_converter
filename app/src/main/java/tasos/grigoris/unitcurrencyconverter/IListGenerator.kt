package tasos.grigoris.unitcurrencyconverter

import android.content.Context

interface IListGenerator {
    fun generateTempList(fromE : MyEnums, value : String) : ArrayList<TheValue>
    fun generateCurrencyList(selectedCurrency : String, value : String) : LinkedHashMap<String, ArrayList<String>>
    fun generateList(context: Context, fromE : MyEnums, value : String) : ArrayList<TheValue>
    fun getEnums(type : FRS) : ArrayList<MyEnums>
}