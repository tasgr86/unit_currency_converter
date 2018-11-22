package tasos.grigoris.unitcurrencyconverter.NavBar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import tasos.grigoris.unitcurrencyconverter.*

class NavPagerAdapter(fm: FragmentManager, private var type: FRS) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        val bundle = Bundle()
        val fr = FRChild()
        bundle.putSerializable("fr", FRS.LENGTH)

        when(type){

            FRS.BASIC -> {

                when(position){

                    0 -> bundle.putSerializable("fr", FRS.CURRENCY)
                    1 -> bundle.putSerializable("fr", FRS.LENGTH)
                    2 -> bundle.putSerializable("fr", FRS.WEIGHT)
                    3 -> bundle.putSerializable("fr", FRS.AREA)
                    4 -> bundle.putSerializable("fr", FRS.FUEL)
                    5 -> bundle.putSerializable("fr", FRS.VOLUME)

                }
            }

            FRS.SCIENCE -> {

                when(position){

                    0 -> bundle.putSerializable("fr", FRS.POWER)
                    1 -> bundle.putSerializable("fr", FRS.DATA)
                    2 -> bundle.putSerializable("fr", FRS.ENERGY)
                    3 -> bundle.putSerializable("fr", FRS.TEMPERATURE)
                    4 -> bundle.putSerializable("fr", FRS.SPEED)

                }
            }

            FRS.CALCULATE -> {

                val fragm : Fragment

                when(position) {

                    0 -> {

                        fragm = FRBMI()
                        bundle.putSerializable("fr", FRS.BMI)

                    }

                    else -> {

                        fragm = FRLoan()
                        bundle.putSerializable("fr", FRS.LOAN)

                    }

                }

                fragm.arguments = bundle
                return fragm

            }

            else -> { }
        }

        fr.arguments = bundle
        return fr

    }

    override fun getCount(): Int {

        return if (type == FRS.BASIC) 6
        else if (type == FRS.SCIENCE) 5
        else if (type == FRS.CALCULATE) 2
        else 0

    }
}