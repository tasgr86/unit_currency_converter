package tasos.grigoris.unitcurrencyconverter

import java.math.BigDecimal
import java.math.RoundingMode

// Why i should use BigDecimal instead of double
// https://codereview.stackexchange.com/questions/63463/conversion-between-units

class MyConverter{

    fun convert(from : Number, to : Number, value: Number) : BigDecimal{

        val bdFrom = BigDecimal(from.toString())
        val bdTo = BigDecimal(to.toString())
        val bdValue = BigDecimal(value.toString())

        val div = bdTo.divide(bdFrom, 100, RoundingMode.CEILING)

        return div.multiply(bdValue).stripTrailingZeros()

    }
}