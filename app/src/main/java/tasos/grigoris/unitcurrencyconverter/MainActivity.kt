package tasos.grigoris.unitcurrencyconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import tasos.grigoris.unitcurrencyconverter.Model.MyConstants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<String>()

        list.add("one")
        list.add("two")

        list.forEach { println(it) }

        val conv = MyConverter()

//        println("meter to inch: " + conv.convert(MyConstants.m, MyConstants.inch, 4))
//        println("meter to cm: " + conv.convert(MyConstants.m, MyConstants.cm, 4))
//        println("inch to foot: " + conv.convert(MyConstants.inch, MyConstants.foot, 4))
//        println("mile to naut_mile: " +
//                conv.convert(MyConstants.mile, MyConstants.naut_mile, 4))


//        println("oz to grain: " + conv.convert(MyConstants.oz, MyConstants.grain, 3.4))
//        println("carat to cwt: " + conv.convert(MyConstants.carat, MyConstants.cwt, 3.4))
//        println("tonne to ton_uk: " +
//                conv.convert(MyConstants.tonne, MyConstants.ton_uk, 3.4))


//        println("ha to acre: " + conv.convert(MyConstants.ha, MyConstants.acre, 0.6))
//        println("ft to yd: " + conv.convert(MyConstants.ft_square, MyConstants.yd_square, 0.6))
//        println("mile to ha: " + conv.convert(MyConstants.ml_square, MyConstants.ha, 0.6))
//        println("cm to in: " + conv.convert(MyConstants.cm_square, MyConstants.in_square, 0.6))

        println("cubic_mm to bbl: " + conv.convert(MyConstants.cubic_mm, MyConstants.bbl, 0.7).toEngineeringString())
        println("cubic_mm to bbl: " + conv.convert(MyConstants.cubic_mm, MyConstants.bbl, 0.7).toPlainString())
//        println("pt_uk to tablespoon_uk: " + conv.convert(MyConstants.pt_uk, MyConstants.tablespoon_uk, 0.7))
//        println("dl to cubic_yd: " + conv.convert(MyConstants.dl, MyConstants.cubic_yd, 0.7))
//        println("fl_oz_us to teaspoon_uk: " + conv.convert(MyConstants.fl_oz_us, MyConstants.teaspoon_uk, 0.7))


    }
}