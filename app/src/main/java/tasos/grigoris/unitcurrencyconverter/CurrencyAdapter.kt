package tasos.grigoris.unitcurrencyconverter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.currency_row.view.*
import kotlinx.android.synthetic.main.row_basic.view.*

class CurrencyAdapter(private val context: Context,
                      _map : HashMap<String, ArrayList<String>>)
                        : RecyclerView.Adapter<CurrencyAdapter.Holder>(){

    private var map = _map
    private var labels = map["labels"]
    private var values = map["values"]

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return CurrencyAdapter.Holder(LayoutInflater.from(context).inflate(R.layout.currency_row, p0, false))
    }

    override fun getItemCount(): Int {
        return labels!!.size
    }

    override fun onBindViewHolder(holder: Holder, pos: Int) {

        holder.label.text = labels!![pos]
        holder.value.text = values!![pos]

        setFlag(labels!![pos], holder.flag)

    }


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val label = itemView.currency_row_label
        val value = itemView.currency_row_value
        val flag  = itemView.currency_row_flag

    }

    private fun setFlag(currency : String, iv : ImageView){

        when(currency){

            "USD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.usd)
            "AED" -> iv.background = ContextCompat.getDrawable(context, R.drawable.aed)
            "AFN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.afn)
            "ALL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.all)
            "AMD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.amd)
            "ANG" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ang)
            "AOA" -> iv.background = ContextCompat.getDrawable(context, R.drawable.aoa)
            "ARS" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ars)
            "AUD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.aud)
            "AWG" -> iv.background = ContextCompat.getDrawable(context, R.drawable.awg)
            "AZN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.azn)
            "BAM" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bam)
            "BBD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bbd)
            "BDT" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bdt)
            "BGN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bgn)
            "BHD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bhd)
            "BIF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bif)
            "BMD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bmd)
            "BND" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bnd)
            "BOB" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bob)
            "BRL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.brl)
            "BSD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bsd)
            "BTC" -> iv.background = ContextCompat.getDrawable(context, R.drawable.btc)
            "BTN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.btn)
            "BWP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bwp)
            "BYN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.byn)
            "BYR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.byr)
            "BZD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.bzd)
            "CAD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.cad)
            "CDF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.cdf)
            "CHF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.chf)
            "CLF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.clf)
            "CLP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.clp)
            "CNY" -> iv.background = ContextCompat.getDrawable(context, R.drawable.cny)
            "COP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.cop)
            "CRC" -> iv.background = ContextCompat.getDrawable(context, R.drawable.crc)
            "CUC" -> iv.background = ContextCompat.getDrawable(context, R.drawable.cuc)
            "CUP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.cup)
            "CVE" -> iv.background = ContextCompat.getDrawable(context, R.drawable.cve)
            "CZK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.czk)
            "DJF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.djf)
            "DKK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.dkk)
            "DOP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.dop)
            "DZD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.dzd)
            "EGP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.egp)
            "ERN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ern)
            "ETB" -> iv.background = ContextCompat.getDrawable(context, R.drawable.etb)
            "EUR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.eur)
            "FJD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.fjd)
            "FKP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.fkp)
            "GBP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.gbp)
            "GEL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.gel)
            "GGP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ggp)
            "GHS" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ghs)
            "GIP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.gip)
            "GMD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.gmd)
            "GNF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.gnf)
            "GTQ" -> iv.background = ContextCompat.getDrawable(context, R.drawable.gtq)
            "GYD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.gyd)
            "HKD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.hkd)
            "HNL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.hnl)
            "HRK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.hrk)
            "HTG" -> iv.background = ContextCompat.getDrawable(context, R.drawable.htg)
            "HUF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.huf)
            "IDR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.idr)
            "ILS" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ils)
            "IMP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.imp)
            "INR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.inr)
            "IQD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.iqd)
            "IRR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.irr)
            "ISK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.isk)
            "JEP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.jep)
            "JMD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.jmd)
            "JOD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.jod)
            "JPY" -> iv.background = ContextCompat.getDrawable(context, R.drawable.jpy)
            "KES" -> iv.background = ContextCompat.getDrawable(context, R.drawable.kes)
            "KGS" -> iv.background = ContextCompat.getDrawable(context, R.drawable.kgs)
            "KHR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.khr)
            "KMF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.kmf)
            "KPW" -> iv.background = ContextCompat.getDrawable(context, R.drawable.kpw)
            "KRW" -> iv.background = ContextCompat.getDrawable(context, R.drawable.krw)
            "KWD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.kwd)
            "KYD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.kyd)
            "KZT" -> iv.background = ContextCompat.getDrawable(context, R.drawable.kzt)
            "LAK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.lak)
            "LBP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.lbp)
            "LKR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.lkr)
            "LRD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.lrd)
            "LSL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.lsl)
            "LTL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ltl)
            "LVL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.lvl)
            "LYD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.lyd)
            "MAD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mad)
            "MDL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mdl)
            "MGA" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mga)
            "MKD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mkd)
            "MMK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mmk)
            "MNT" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mnt)
            "MOP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mop)
            "MRO" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mro)
            "MUR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mur)
            "MVR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mvr)
            "MWK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mwk)
            "MXN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mxn)
            "MYR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.myr)
            "MZN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.mzn)
            "NAD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.nad)
            "NGN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ngn)
            "NIO" -> iv.background = ContextCompat.getDrawable(context, R.drawable.nio)
            "NOK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.nok)
            "NPR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.npr)
            "NZD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.nzd)
            "OMR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.omr)
            "PAB" -> iv.background = ContextCompat.getDrawable(context, R.drawable.pab)
            "PEN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.pen)
            "PGK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.pgk)
            "PHP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.php)
            "PKR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.pkr)
            "PLN" -> iv.background = ContextCompat.getDrawable(context, R.drawable.pln)
            "PYG" -> iv.background = ContextCompat.getDrawable(context, R.drawable.pyg)
            "QAR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.qar)
            "RON" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ron)
            "RSD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.rsd)
            "RUB" -> iv.background = ContextCompat.getDrawable(context, R.drawable.rub)
            "RWF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.rwf)
            "SAR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.sar)
            "SBD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.sbd)
            "SCR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.scr)
            "SDG" -> iv.background = ContextCompat.getDrawable(context, R.drawable.sdg)
            "SEK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.sek)
            "SGD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.sgd)
            "SHP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.shp)
            "SLL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.sll)
            "SOS" -> iv.background = ContextCompat.getDrawable(context, R.drawable.sos)
            "SRD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.srd)
            "STD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.std)
            "SVC" -> iv.background = ContextCompat.getDrawable(context, R.drawable.svc)
            "SYP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.syp)
            "SZL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.szl)
            "THB" -> iv.background = ContextCompat.getDrawable(context, R.drawable.thb)
            "TJS" -> iv.background = ContextCompat.getDrawable(context, R.drawable.tjs)
            "TMT" -> iv.background = ContextCompat.getDrawable(context, R.drawable.tmt)
            "TND" -> iv.background = ContextCompat.getDrawable(context, R.drawable.tnd)
            "TOP" -> iv.background = ContextCompat.getDrawable(context, R.drawable.top)
            "TRY" -> iv.background = ContextCompat.getDrawable(context, R.drawable.try_)
            "TTD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ttd)
            "TWD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.twd)
            "TZS" -> iv.background = ContextCompat.getDrawable(context, R.drawable.tzs)
            "UAH" -> iv.background = ContextCompat.getDrawable(context, R.drawable.uah)
            "UGX" -> iv.background = ContextCompat.getDrawable(context, R.drawable.ugx)
            "UYU" -> iv.background = ContextCompat.getDrawable(context, R.drawable.uyu)
            "UZS" -> iv.background = ContextCompat.getDrawable(context, R.drawable.uzs)
            "VEF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.vef)
            "VND" -> iv.background = ContextCompat.getDrawable(context, R.drawable.vnd)
            "VUV" -> iv.background = ContextCompat.getDrawable(context, R.drawable.vuv)
            "WST" -> iv.background = ContextCompat.getDrawable(context, R.drawable.wst)
            "XAF" -> iv.background = ContextCompat.getDrawable(context, R.drawable.xaf)
            "XAG" -> iv.background = ContextCompat.getDrawable(context, R.drawable.xag)
            "XAU" -> iv.background = ContextCompat.getDrawable(context, R.drawable.xau)
            "XCD" -> iv.background = ContextCompat.getDrawable(context, R.drawable.xcd)
            "YER" -> iv.background = ContextCompat.getDrawable(context, R.drawable.yer)
            "ZAR" -> iv.background = ContextCompat.getDrawable(context, R.drawable.zar)
            "ZMK" -> iv.background = ContextCompat.getDrawable(context, R.drawable.zmk)
            "ZMW" -> iv.background = ContextCompat.getDrawable(context, R.drawable.zmw)
            "SWL" -> iv.background = ContextCompat.getDrawable(context, R.drawable.swl)

        }
    }
}