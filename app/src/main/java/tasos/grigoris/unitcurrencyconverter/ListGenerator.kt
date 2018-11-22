package tasos.grigoris.unitcurrencyconverter

import android.content.Context
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashMap

class ListGenerator(var context : Context, var type : FRS) : IListGenerator {

    @Inject lateinit var prefs : IMyPrefs
    @Inject lateinit var converter: MyConverter

    init {

        MyApplication.getComponent().injectListGenerator(this)

    }

    override fun generateTempList(fromE : MyEnums, value : String) : ArrayList<TheValue> {

        val list = ArrayList<TheValue>()

        list.add(TheValue(context.getString(R.string.celsius), converter.convertTemperature(fromE, MyEnums.CELSIUS, value), MyEnums.CELSIUS))
        list.add(TheValue(context.getString(R.string.fahrenheit), converter.convertTemperature(fromE, MyEnums.FAHRENEIT, value), MyEnums.FAHRENEIT))
        list.add(TheValue(context.getString(R.string.kelvin), converter.convertTemperature(fromE, MyEnums.KELVIN, value), MyEnums.KELVIN))
        list.add(TheValue(context.getString(R.string.réaumur), converter.convertTemperature(fromE, MyEnums.REAUMUR, value), MyEnums.REAUMUR))
        list.add(TheValue(context.getString(R.string.rankine), converter.convertTemperature(fromE, MyEnums.RANKINE, value), MyEnums.RANKINE))

        return list

    }


    override fun generateCurrencyList(selectedCurrency : String, value : String) : LinkedHashMap<String, ArrayList<String>>{

        val labels = ArrayList<String>()
        val values = ArrayList<String>()

        if (prefs.getRates().rates == null){

            val map = LinkedHashMap<String, ArrayList<String>>()
            map["labels"] = labels
            map["values"] = values

            return map

        }

        val response = prefs.getRates().rates!!.toSortedMap()

        var from = "0"

        response.forEach {

            if (it.key == selectedCurrency)
                from = it.value

        }


        response.forEach {

            if (it.key != "XAG" && it.key != "XAU" && it.key != "XCD" && it.key != "ZMK"
                && it.key != "XPF" && it.key != "ZMK" && it.key != "XOF" && it.key != "XDR"
                && it.key != "XAF" && it.key != "BYR") {

                labels.add(it.key)
                values.add(converter.convertWithScale(from, it.value, value))

            }

        }

        val ratesMap = LinkedHashMap<String, ArrayList<String>>()
        ratesMap["labels"] = labels
        ratesMap["values"] = values

        return ratesMap

    }


    override fun generateList(context: Context, fromE : MyEnums, value : String) : ArrayList<TheValue>{

        val list = ArrayList<TheValue>()

        when (type) {

            FRS.LENGTH -> {

                list.add(TheValue(context.getString(R.string.meters), converter.convert(fromE.value, MyEnums.M.value, value), MyEnums.M))
                list.add(TheValue(context.getString(R.string.μm), converter.convert(fromE.value, MyEnums.μM.value, value), MyEnums.μM))
                list.add(TheValue(context.getString(R.string.mm), converter.convert(fromE.value, MyEnums.MM.value, value), MyEnums.MM))
                list.add(TheValue(context.getString(R.string.cm), converter.convert(fromE.value, MyEnums.CM.value, value), MyEnums.CM))
                list.add(TheValue(context.getString(R.string.dm), converter.convert(fromE.value, MyEnums.DM.value, value), MyEnums.DM))
                list.add(TheValue(context.getString(R.string.inch), converter.convert(fromE.value, MyEnums.INCH.value, value), MyEnums.INCH))
                list.add(TheValue(context.getString(R.string.feet), converter.convert(fromE.value, MyEnums.FT.value, value), MyEnums.FT))
                list.add(TheValue(context.getString(R.string.yards), converter.convert(fromE.value, MyEnums.YD.value, value), MyEnums.YD))
                list.add(TheValue(context.getString(R.string.mile), converter.convert(fromE.value, MyEnums.MILE.value, value), MyEnums.MILE))
                list.add(TheValue(context.getString(R.string.nautical_mile), converter.convert(fromE.value, MyEnums.NAUT_MILE.value, value), MyEnums.NAUT_MILE))
                list.add(TheValue(context.getString(R.string.kilometers), converter.convert(fromE.value, MyEnums.KM.value, value), MyEnums.KM))
                list.add(TheValue(context.getString(R.string.nm), converter.convert(fromE.value, MyEnums.NM.value, value), MyEnums.NM))
                list.add(TheValue(context.getString(R.string.fathom), converter.convert(fromE.value, MyEnums.FATHOM.value, value), MyEnums.FATHOM))

            }


            FRS.WEIGHT -> {

                list.add(TheValue(context.getString(R.string.kilos), converter.convert(fromE.value, MyEnums.KG.value, value), MyEnums.KG))
                list.add(TheValue(context.getString(R.string.μg), converter.convert(fromE.value, MyEnums.μG.value, value), MyEnums.μG))
                list.add(TheValue(context.getString(R.string.mg), converter.convert(fromE.value, MyEnums.MG.value, value), MyEnums.MG))
                list.add(TheValue(context.getString(R.string.g), converter.convert(fromE.value, MyEnums.G.value, value), MyEnums.G))
                list.add(TheValue(context.getString(R.string.lb), converter.convert(fromE.value, MyEnums.LB.value, value), MyEnums.LB))
                list.add(TheValue(context.getString(R.string.oz), converter.convert(fromE.value, MyEnums.OZ.value, value), MyEnums.OZ))
                list.add(TheValue(context.getString(R.string.oz_t), converter.convert(fromE.value, MyEnums.OZ_T.value, value), MyEnums.OZ_T))
                list.add(TheValue(context.getString(R.string.grain), converter.convert(fromE.value, MyEnums.GRAIN.value, value), MyEnums.GRAIN))
                list.add(TheValue(context.getString(R.string.tonne), converter.convert(fromE.value, MyEnums.TONNE.value, value), MyEnums.TONNE))
                list.add(TheValue(context.getString(R.string.ton_uk), converter.convert(fromE.value, MyEnums.TON_UK.value, value), MyEnums.TON_UK))
                list.add(TheValue(context.getString(R.string.ton_us), converter.convert(fromE.value, MyEnums.TON_US.value, value), MyEnums.TON_US))
                list.add(TheValue(context.getString(R.string.stone_uk), converter.convert(fromE.value, MyEnums.STONE_UK.value, value), MyEnums.STONE_UK))
                list.add(TheValue(context.getString(R.string.cwt), converter.convert(fromE.value, MyEnums.CWT.value, value), MyEnums.CWT))
                list.add(TheValue(context.getString(R.string.carat), converter.convert(fromE.value, MyEnums.CARAT.value, value), MyEnums.CARAT))

            }


            FRS.AREA -> {

                list.add(TheValue(context.getString(R.string.square_meters), converter.convert(fromE.value, MyEnums.M_SQUARE.value, value), MyEnums.M_SQUARE))
                list.add(TheValue(context.getString(R.string.square_mm), converter.convert(fromE.value, MyEnums.MM_SQUARE.value, value), MyEnums.MM_SQUARE))
                list.add(TheValue(context.getString(R.string.square_cm), converter.convert(fromE.value, MyEnums.CM_SQUARE.value, value), MyEnums.CM_SQUARE))
                list.add(TheValue(context.getString(R.string.square_dm), converter.convert(fromE.value, MyEnums.DM_SQUARE.value, value), MyEnums.DM_SQUARE))
                list.add(TheValue(context.getString(R.string.square_inch), converter.convert(fromE.value, MyEnums.IN_SQUARE.value, value), MyEnums.IN_SQUARE))
                list.add(TheValue(context.getString(R.string.square_feet), converter.convert(fromE.value, MyEnums.FT_SQUARE.value, value), MyEnums.FT_SQUARE))
                list.add(TheValue(context.getString(R.string.square_yd), converter.convert(fromE.value, MyEnums.YD_SQUARE.value, value), MyEnums.YD_SQUARE))
                list.add(TheValue(context.getString(R.string.a), converter.convert(fromE.value, MyEnums.A.value, value), MyEnums.A))
                list.add(TheValue(context.getString(R.string.ha), converter.convert(fromE.value, MyEnums.HA.value, value), MyEnums.HA))
                list.add(TheValue(context.getString(R.string.square_km), converter.convert(fromE.value, MyEnums.KM_SQUARE.value, value), MyEnums.KM_SQUARE))
                list.add(TheValue(context.getString(R.string.acre), converter.convert(fromE.value, MyEnums.ACRE.value, value), MyEnums.ACRE))
                list.add(TheValue(context.getString(R.string.square_ml), converter.convert(fromE.value, MyEnums.ML_SQUARE.value, value), MyEnums.ML_SQUARE))

            }


            FRS.VOLUME -> {

                list.add(TheValue(context.getString(R.string.litre), converter.convert(fromE.value, MyEnums.LITRE.value, value), MyEnums.LITRE))
                list.add(TheValue(context.getString(R.string.ml), converter.convert(fromE.value, MyEnums.ML.value, value), MyEnums.ML))
                list.add(TheValue(context.getString(R.string.cl), converter.convert(fromE.value, MyEnums.CL.value, value), MyEnums.CL))
                list.add(TheValue(context.getString(R.string.dl), converter.convert(fromE.value, MyEnums.DL.value, value), MyEnums.DL))
                list.add(TheValue(context.getString(R.string.cubic_mm), converter.convert(fromE.value, MyEnums.CUBIC_MM.value, value), MyEnums.CUBIC_MM))
                list.add(TheValue(context.getString(R.string.cubic_cm), converter.convert(fromE.value, MyEnums.CUBIC_CM.value, value), MyEnums.CUBIC_CM))
                list.add(TheValue(context.getString(R.string.cubic_dm), converter.convert(fromE.value, MyEnums.CUBIC_DM.value, value), MyEnums.CUBIC_DM))
                list.add(TheValue(context.getString(R.string.cubic_m), converter.convert(fromE.value, MyEnums.CUBIC_M.value, value), MyEnums.CUBIC_M))
                list.add(TheValue(context.getString(R.string.cubic_in), converter.convert(fromE.value, MyEnums.CUBIC_IN.value, value), MyEnums.CUBIC_IN))
                list.add(TheValue(context.getString(R.string.cubic_feet), converter.convert(fromE.value, MyEnums.CUBIC_FT.value, value), MyEnums.CUBIC_FT))
                list.add(TheValue(context.getString(R.string.cubic_yards), converter.convert(fromE.value, MyEnums.CUBIC_YD.value, value), MyEnums.CUBIC_YD))
                list.add(TheValue(context.getString(R.string.gal_uk), converter.convert(fromE.value, MyEnums.GAL_UK.value, value), MyEnums.GAL_UK))
                list.add(TheValue(context.getString(R.string.gal_us), converter.convert(fromE.value, MyEnums.GAL_US.value, value), MyEnums.GAL_US))
                list.add(TheValue(context.getString(R.string.bbl), converter.convert(fromE.value, MyEnums.BBL.value, value), MyEnums.BBL))
                list.add(TheValue(context.getString(R.string.pt_uk), converter.convert(fromE.value, MyEnums.PT_UK.value, value), MyEnums.PT_UK))
                list.add(TheValue(context.getString(R.string.pt_us), converter.convert(fromE.value, MyEnums.PT_US.value, value), MyEnums.PT_US))
                list.add(TheValue(context.getString(R.string.fl_oz_us), converter.convert(fromE.value, MyEnums.FL_OZ_US.value, value), MyEnums.FL_OZ_US))
                list.add(TheValue(context.getString(R.string.tablespoon_uk), converter.convert(fromE.value, MyEnums.TABLESPOON_UK.value, value), MyEnums.TABLESPOON_UK))
                list.add(TheValue(context.getString(R.string.teaspoon_uk), converter.convert(fromE.value, MyEnums.TEESPOON_UK.value, value), MyEnums.TEESPOON_UK))

            }


            FRS.FUEL -> {

                list.add(TheValue(context.getString(R.string.km_l), converter.convert(fromE.value, MyEnums.KM_L.value, value), MyEnums.KM_L))
                list.add(TheValue(context.getString(R.string.mi_l), converter.convert(fromE.value, MyEnums.MI_L.value, value), MyEnums.MI_L))
                list.add(TheValue(context.getString(R.string.km_gal), converter.convert(fromE.value, MyEnums.KM_GAL.value, value), MyEnums.KM_GAL))
                list.add(TheValue(context.getString(R.string.mi_gal_us), converter.convert(fromE.value, MyEnums.MI_GAL_US.value, value), MyEnums.MI_GAL_US))
                list.add(TheValue(context.getString(R.string.mi_gal_uk), converter.convert(fromE.value, MyEnums.MI_GAL_UK.value, value), MyEnums.MI_GAL_UK))

            }

            FRS.POWER -> {

                list.add(TheValue(context.getString(R.string.watts), converter.convert(fromE.value, MyEnums.WATTS.value, value), MyEnums.WATTS))
                list.add(TheValue(context.getString(R.string.kwatts), converter.convert(fromE.value, MyEnums.KWATTS.value, value), MyEnums.KWATTS))
                list.add(TheValue(context.getString(R.string.mwatts), converter.convert(fromE.value, MyEnums.MWATTS.value, value), MyEnums.MWATTS))
                list.add(TheValue(context.getString(R.string.btu_hour), converter.convert(fromE.value, MyEnums.BTU_HOUR.value, value), MyEnums.BTU_HOUR))
                list.add(TheValue(context.getString(R.string.hp), converter.convert(fromE.value, MyEnums.HP.value, value), MyEnums.HP))
                list.add(TheValue(context.getString(R.string.ps), converter.convert(fromE.value, MyEnums.PS.value, value), MyEnums.PS))

            }


            FRS.SPEED -> {

                list.add(TheValue(context.getString(R.string.kmh), converter.convert(fromE.value, MyEnums.KMH.value, value), MyEnums.KMH))
                list.add(TheValue(context.getString(R.string.mph), converter.convert(fromE.value, MyEnums.MPH.value, value), MyEnums.MPH))
                list.add(TheValue(context.getString(R.string.m_s), converter.convert(fromE.value, MyEnums.M_S.value, value), MyEnums.M_S))
                list.add(TheValue(context.getString(R.string.ft_s), converter.convert(fromE.value, MyEnums.FT_S.value, value), MyEnums.FT_S))
                list.add(TheValue(context.getString(R.string.knot), converter.convert(fromE.value, MyEnums.KNOT.value, value), MyEnums.KNOT))
                list.add(TheValue(context.getString(R.string.mach), converter.convert(fromE.value, MyEnums.MACH.value, value), MyEnums.MACH))

            }


            FRS.TIME -> {

                list.add(TheValue(context.getString(R.string.hours), converter.convert(fromE.value, MyEnums.HOURS.value, value), MyEnums.HOURS))
                list.add(TheValue(context.getString(R.string.minutes), converter.convert(fromE.value, MyEnums.MINUTES.value, value), MyEnums.MINUTES))
                list.add(TheValue(context.getString(R.string.seconds), converter.convert(fromE.value, MyEnums.SECONDS.value, value), MyEnums.SECONDS))
                list.add(TheValue(context.getString(R.string.ms), converter.convert(fromE.value, MyEnums.MS.value, value), MyEnums.MS))
                list.add(TheValue(context.getString(R.string.days), converter.convert(fromE.value, MyEnums.DAY.value, value), MyEnums.DAY))
                list.add(TheValue(context.getString(R.string.weeks), converter.convert(fromE.value, MyEnums.WEEK.value, value), MyEnums.WEEK))
                list.add(TheValue(context.getString(R.string.months), converter.convert(fromE.value, MyEnums.MONTH.value, value), MyEnums.MONTH))
                list.add(TheValue(context.getString(R.string.years), converter.convert(fromE.value, MyEnums.YEAR.value, value), MyEnums.YEAR))

            }

            FRS.ENERGY -> {

                list.add(TheValue(context.getString(R.string.joule), converter.convert(fromE.value, MyEnums.JOULE.value, value), MyEnums.JOULE))
                list.add(TheValue(context.getString(R.string.kilojoules), converter.convert(fromE.value, MyEnums.KILO_JOULE.value, value), MyEnums.KILO_JOULE))
                list.add(TheValue(context.getString(R.string.calorie), converter.convert(fromE.value, MyEnums.CAL.value, value), MyEnums.CAL))
                list.add(TheValue(context.getString(R.string.kcalorie), converter.convert(fromE.value, MyEnums.KCAL.value, value), MyEnums.KCAL))
                list.add(TheValue(context.getString(R.string.kwh), converter.convert(fromE.value, MyEnums.KWH.value, value), MyEnums.KWH))
                list.add(TheValue(context.getString(R.string.btu), converter.convert(fromE.value, MyEnums.BTU.value, value), MyEnums.BTU))
                list.add(TheValue(context.getString(R.string.toe), converter.convert(fromE.value, MyEnums.TOE.value, value), MyEnums.TOE))

            }


            FRS.DATA -> {

                list.add(TheValue(context.getString(R.string.bit), converter.convert(fromE.value, MyEnums.BIT.value, value), MyEnums.BIT))
                list.add(TheValue(context.getString(R.string._byte), converter.convert(fromE.value, MyEnums.BYTE.value, value), MyEnums.BYTE))
                list.add(TheValue(context.getString(R.string.kilobits), converter.convert(fromE.value, MyEnums.KILOBIT.value, value), MyEnums.KILOBIT))
                list.add(TheValue(context.getString(R.string.kilobyte), converter.convert(fromE.value, MyEnums.KILOBYTE.value, value), MyEnums.KILOBYTE))
                list.add(TheValue(context.getString(R.string.megabit), converter.convert(fromE.value, MyEnums.MEGABIT.value, value), MyEnums.MEGABIT))
                list.add(TheValue(context.getString(R.string.megabyte), converter.convert(fromE.value, MyEnums.MEGABYTE.value, value), MyEnums.MEGABYTE))
                list.add(TheValue(context.getString(R.string.gigabit), converter.convert(fromE.value, MyEnums.GIGABIT.value, value), MyEnums.GIGABIT))
                list.add(TheValue(context.getString(R.string.gigabyte), converter.convert(fromE.value, MyEnums.GIGABYTE.value, value), MyEnums.GIGABYTE))
                list.add(TheValue(context.getString(R.string.terabits), converter.convert(fromE.value, MyEnums.TERABIT.value, value), MyEnums.TERABIT))
                list.add(TheValue(context.getString(R.string.terabyte), converter.convert(fromE.value, MyEnums.TERABYTE.value, value), MyEnums.TERABYTE))

            }


            else -> { }

        }

        return list

    }





    override fun getEnums(type : FRS) : ArrayList<MyEnums>{

        val list = ArrayList<MyEnums>()

        when (type) {
            FRS.LENGTH -> {

                list.add(MyEnums.M)
                list.add(MyEnums.μM)
                list.add(MyEnums.MM)
                list.add(MyEnums.CM)
                list.add(MyEnums.DM)
                list.add(MyEnums.INCH)
                list.add(MyEnums.FT)
                list.add(MyEnums.YD)
                list.add(MyEnums.MILE)
                list.add(MyEnums.NAUT_MILE)
                list.add(MyEnums.KM)
                list.add(MyEnums.NM)
                list.add(MyEnums.FATHOM)

            }
            FRS.WEIGHT -> {

                list.add(MyEnums.KG)
                list.add(MyEnums.μG)
                list.add(MyEnums.MG)
                list.add(MyEnums.G)
                list.add(MyEnums.LB)
                list.add(MyEnums.OZ)
                list.add(MyEnums.OZ_T)
                list.add(MyEnums.GRAIN)
                list.add(MyEnums.TONNE)
                list.add(MyEnums.TON_UK)
                list.add(MyEnums.TON_US)
                list.add(MyEnums.STONE_UK)
                list.add(MyEnums.CWT)
                list.add(MyEnums.CARAT)

            }
            FRS.AREA -> {

                list.add(MyEnums.M_SQUARE)
                list.add(MyEnums.MM_SQUARE)
                list.add(MyEnums.CM_SQUARE)
                list.add(MyEnums.DM_SQUARE)
                list.add(MyEnums.IN_SQUARE)
                list.add(MyEnums.FT_SQUARE)
                list.add(MyEnums.YD_SQUARE)
                list.add(MyEnums.A)
                list.add(MyEnums.HA)
                list.add(MyEnums.KM_SQUARE)
                list.add(MyEnums.ACRE)
                list.add(MyEnums.ML_SQUARE)

            }
            FRS.FUEL -> {

                list.add(MyEnums.KM_L)
                list.add(MyEnums.MI_L)
                list.add(MyEnums.KM_GAL)
                list.add(MyEnums.MI_GAL_US)
                list.add(MyEnums.MI_GAL_UK)

            }
            FRS.VOLUME -> {

                list.add(MyEnums.LITRE)
                list.add(MyEnums.ML)
                list.add(MyEnums.CL)
                list.add(MyEnums.DL)
                list.add(MyEnums.CUBIC_MM)
                list.add(MyEnums.CUBIC_CM)
                list.add(MyEnums.CUBIC_DM)
                list.add(MyEnums.CUBIC_M)
                list.add(MyEnums.CUBIC_IN)
                list.add(MyEnums.CUBIC_FT)
                list.add(MyEnums.CUBIC_YD)
                list.add(MyEnums.GAL_UK)
                list.add(MyEnums.GAL_US)
                list.add(MyEnums.BBL)
                list.add(MyEnums.PT_UK)
                list.add(MyEnums.PT_US)
                list.add(MyEnums.FL_OZ_US)
                list.add(MyEnums.TABLESPOON_UK)
                list.add(MyEnums.TEESPOON_UK)

            }
            FRS.POWER -> {

                list.add(MyEnums.WATTS)
                list.add(MyEnums.KWATTS)
                list.add(MyEnums.MWATTS)
                list.add(MyEnums.BTU_HOUR)
                list.add(MyEnums.HP)
                list.add(MyEnums.PS)

            }
            FRS.ENERGY -> {

                list.add(MyEnums.JOULE)
                list.add(MyEnums.KILO_JOULE)
                list.add(MyEnums.CAL)
                list.add(MyEnums.KCAL)
                list.add(MyEnums.KWH)
                list.add(MyEnums.BTU)
                list.add(MyEnums.TOE)

            }
            FRS.DATA -> {

                list.add(MyEnums.BIT)
                list.add(MyEnums.BYTE)
                list.add(MyEnums.KILOBIT)
                list.add(MyEnums.KILOBYTE)
                list.add(MyEnums.MEGABIT)
                list.add(MyEnums.MEGABYTE)
                list.add(MyEnums.GIGABIT)
                list.add(MyEnums.GIGABYTE)
                list.add(MyEnums.TERABIT)
                list.add(MyEnums.TERABYTE)

            }
            FRS.TEMPERATURE -> {

                list.add(MyEnums.CELSIUS)
                list.add(MyEnums.FAHRENEIT)
                list.add(MyEnums.KELVIN)
                list.add(MyEnums.REAUMUR)
                list.add(MyEnums.RANKINE)

            }
            FRS.SPEED -> {

                list.add(MyEnums.KMH)
                list.add(MyEnums.MPH)
                list.add(MyEnums.M_S)
                list.add(MyEnums.FT_S)
                list.add(MyEnums.KNOT)
                list.add(MyEnums.MACH)

            }
            else -> {
            }
        }

        return list

    }
}