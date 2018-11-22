package tasos.grigoris.unitcurrencyconverter

import java.math.BigDecimal

interface IMyConverter {

    fun convert(from : String, to : String, value: String) : String
    fun format(x: BigDecimal): String
    fun convertWithScale(from : String, to : String, value: String) : String
    fun getBMI(weight : Double, height : Double) : String
    fun getInstallment(loanAmount : String, rate : String, installments : Int) : TheInterest
    fun convertTemperature(from : MyEnums, to : MyEnums, value: String) : String

}