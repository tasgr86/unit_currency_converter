package tasos.grigoris.unitcurrencyconverter

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject
import kotlin.math.pow

// Why i should use BigDecimal instead of double
// https://codereview.stackexchange.com/questions/63463/conversion-between-units

class MyConverter@Inject constructor() : IMyConverter {

    @Inject lateinit var prefs : IMyPrefs
    private var scale = 0

    init {

        MyApplication.getComponent().injectConverter(this)
        scale = prefs.getDecimals()

    }


    override fun convert(from : String, to : String, value: String) : String{

        if (value == "0")
            return BigDecimal.ZERO.toPlainString()

        val bdFrom = BigDecimal(from)
        val bdTo = BigDecimal(to)
        val bdValue = BigDecimal(value)

        val div = bdTo.divide(bdFrom, 100, RoundingMode.HALF_EVEN).stripTrailingZeros()

        val result = div.multiply(bdValue).stripTrailingZeros()

        return format(result.setScale(7, RoundingMode.HALF_UP).stripTrailingZeros())

    }

    override fun format(x: BigDecimal): String {

        val formatter = DecimalFormat("0.000000E0")

        return if (x.toPlainString().length < 19)
            x.toPlainString()
        else
            formatter.format(x)

    }


    override fun convertWithScale(from : String, to : String, value: String) : String{

        if (value == "0")
            return BigDecimal.ZERO.toPlainString()

        val bdFrom = BigDecimal(from)
        val bdTo = BigDecimal(to)
        val bdValue = BigDecimal(value)

        val div = bdTo.divide(bdFrom, 100, RoundingMode.HALF_UP).stripTrailingZeros()

        return div.multiply(bdValue).setScale(scale, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString()

    }


    override fun getBMI(weight : Double, height : Double) : String{

        return BigDecimal(weight).
            divide(BigDecimal(height/100 * height/100), 2, RoundingMode.HALF_UP).
            stripTrailingZeros().toPlainString()

    }


    override fun getInstallment(loanAmount : String, rate : String, installments : Int) : TheInterest{

        val loanAmountBD = BigDecimal(loanAmount)
        val rateBD = BigDecimal(rate).divide(BigDecimal("100") ,2, RoundingMode.HALF_UP)

        val installment = loanAmountBD.multiply(rateBD).
            divide(BigDecimal(1 - (1 + rateBD.toDouble()).pow(-installments)), 2, RoundingMode.HALF_UP)

        val monthlyInstallment = installment.divide(BigDecimal("12"), 2, RoundingMode.HALF_UP)
        val totalAmount = installment.multiply(installments.toBigDecimal())
        val totalInterest = totalAmount.subtract(loanAmountBD)

        return TheInterest(monthlyInstallment.toPlainString(), totalAmount.toPlainString(), totalInterest.toPlainString())

    }



    override fun convertTemperature(from : MyEnums, to : MyEnums, value: String) : String{

        if (value == "0")
            return BigDecimal.ZERO.toEngineeringString()

        if (from == to)
            return BigDecimal(value).toEngineeringString()

        val bdValue = BigDecimal(value)

        val result : BigDecimal

        if (from == MyEnums.CELSIUS && to == MyEnums.FAHRENEIT)
            result = (bdValue.multiply(BigDecimal("1.8"))).add(BigDecimal("32"))
        else if (from == MyEnums.CELSIUS && to == MyEnums.KELVIN)
            result = bdValue.add(BigDecimal("273.15"))
        else if (from == MyEnums.CELSIUS && to == MyEnums.REAUMUR)
            result = bdValue.multiply(BigDecimal("0.8"))
        else if (from == MyEnums.CELSIUS && to == MyEnums.RANKINE)
            result = bdValue.multiply(BigDecimal("1.8")).add(BigDecimal("32")).add(BigDecimal("459.67"))
        else if (from == MyEnums.FAHRENEIT && to == MyEnums.CELSIUS)
            result = bdValue.subtract(BigDecimal("32")).divide(BigDecimal("1.8"), 100, RoundingMode.HALF_UP)
        else if (from == MyEnums.FAHRENEIT && to == MyEnums.KELVIN)
            result = bdValue.add(BigDecimal("459.67")).divide(BigDecimal("1.8"), 100, RoundingMode.HALF_UP)
        else if (from == MyEnums.FAHRENEIT && to == MyEnums.REAUMUR)
            result = bdValue.subtract(BigDecimal("32")).divide(BigDecimal("2.25"), 100, RoundingMode.HALF_UP)
        else if (from == MyEnums.FAHRENEIT && to == MyEnums.RANKINE)
            result = bdValue.add(BigDecimal("459.67"))
        else if (from == MyEnums.KELVIN && to == MyEnums.FAHRENEIT)
            result = bdValue.multiply(BigDecimal("1.8")).subtract(BigDecimal("459.67"))
        else if (from == MyEnums.KELVIN && to == MyEnums.CELSIUS)
            result = bdValue.subtract(BigDecimal("273.15"))
        else if (from == MyEnums.KELVIN && to == MyEnums.REAUMUR)
            result = bdValue.subtract(BigDecimal("273.15")).multiply(BigDecimal("0.8"))
        else if (from == MyEnums.KELVIN && to == MyEnums.RANKINE)
            result = bdValue.multiply(BigDecimal("1.8"))
        else if (from == MyEnums.REAUMUR && to == MyEnums.CELSIUS)
            result = (bdValue.multiply(BigDecimal("1.25")))
        else if (from == MyEnums.REAUMUR && to == MyEnums.FAHRENEIT)
            result = bdValue.multiply(BigDecimal("2.25")).add(BigDecimal("32"))
        else if (from == MyEnums.REAUMUR && to == MyEnums.KELVIN)
            result = bdValue.multiply(BigDecimal("1.25")).add(BigDecimal("273.15"))
        else if (from == MyEnums.REAUMUR && to == MyEnums.RANKINE)
            result = bdValue.multiply(BigDecimal("2.25")).add(BigDecimal("32")).add(BigDecimal("459.67"))

        else if (from == MyEnums.RANKINE && to == MyEnums.CELSIUS)
            result = (bdValue.subtract(BigDecimal("32")).subtract(BigDecimal("459.67")).
                divide(BigDecimal("1.8"), 100, RoundingMode.HALF_EVEN))
        else if (from == MyEnums.RANKINE && to == MyEnums.FAHRENEIT)
            result = bdValue.subtract(BigDecimal("459.67"))
        else if (from == MyEnums.RANKINE && to == MyEnums.KELVIN)
            result = bdValue.divide(BigDecimal("1.8"), 100, RoundingMode.HALF_UP)
        else if (from == MyEnums.RANKINE && to == MyEnums.REAUMUR)
            result = bdValue.subtract(BigDecimal("32")).subtract(BigDecimal( "459.67")).
                divide(BigDecimal("2.25"), 100, RoundingMode.HALF_UP)
        else return BigDecimal.ZERO.toEngineeringString()

        return result.stripTrailingZeros().toEngineeringString()
//        return result.stripTrailingZeros()

    }
}