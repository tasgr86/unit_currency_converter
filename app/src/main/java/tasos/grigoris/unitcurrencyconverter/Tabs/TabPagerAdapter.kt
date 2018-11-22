package tasos.grigoris.unitcurrencyconverter.Tabs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import tasos.grigoris.unitcurrencyconverter.FRS

class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        val bundle = Bundle()
        val fr = FRParentTabs()

        println("Get Item: ".plus(position))

        when (position) {

            0 -> bundle.putSerializable("fr", FRS.BASIC)
//            1 -> bundle.putSerializable("fr", FRS.EVERYDAY)
//            2 -> bundle.putSerializable("fr", FRS.OTHER)
            3 -> bundle.putSerializable("fr", FRS.CALCULATE)

        }

        fr.arguments = bundle
        return fr

    }

    override fun getCount(): Int {
        return tabCount
    }
}