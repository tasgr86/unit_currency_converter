package tasos.grigoris.unitcurrencyconverter.NavBar

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fr_parent.*
import tasos.grigoris.unitcurrencyconverter.*

class FRParent : Fragment() {

    private lateinit var type : FRS

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fr_parent, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        type = arguments!!.getSerializable("fr") as FRS

        initTabs()

        val adapter = NavPagerAdapter(childFragmentManager, type)
        fr_parent_pager.adapter = adapter
        fr_parent_pager.currentItem = 0
        fr_parent_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(fr_parent_tab_layout))

        fr_parent_pager.setPageTransformer(false, ZoomOutTransformation())

        fr_parent_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

                tab!!.customView!!.findViewById<TextView>(R.id.tab_label).background =
                        ContextCompat.getDrawable(view.context, R.drawable.round_tab_selected)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

                tab!!.customView!!.findViewById<TextView>(R.id.tab_label).background =
                        ContextCompat.getDrawable(view.context, R.drawable.round_tab_unselected2)

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                fr_parent_pager.currentItem = tab!!.position

                tab.customView!!.findViewById<TextView>(R.id.tab_label).background =
                        ContextCompat.getDrawable(view.context, R.drawable.round_tab_selected)

            }

        })


        if (type != FRS.SETTINGS) {

            val tab = fr_parent_tab_layout.getTabAt(0)
            tab!!.customView!!.findViewById<TextView>(R.id.tab_label).background =
                    ContextCompat.getDrawable(view.context, R.drawable.round_tab_selected)

        }

    }

    private fun initTabs(){

        val numOfTabs : Int = if (type == FRS.BASIC) 6
        else if (type == FRS.SCIENCE) 5
        else if (type == FRS.CALCULATE) 2
        else 0

        for (i in 0 until numOfTabs) {

            fr_parent_tab_layout.addTab(fr_parent_tab_layout.newTab())

        }

        when (type){

            FRS.BASIC -> {

                for (i in 0 .. 5){

                    val tab = fr_parent_tab_layout.getTabAt(i)
                    tab!!.customView = layoutInflater.inflate(R.layout.tab, null)

                }

                fr_parent_tab_layout.getTabAt(0)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.currency)
                fr_parent_tab_layout.getTabAt(1)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.length)
                fr_parent_tab_layout.getTabAt(2)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.weight_cap)
                fr_parent_tab_layout.getTabAt(3)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.area)
                fr_parent_tab_layout.getTabAt(4)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.fuel)
                fr_parent_tab_layout.getTabAt(5)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.volume)

            }

            FRS.SCIENCE -> {

                for (i in 0 .. 4){

                    val tab = fr_parent_tab_layout.getTabAt(i)
                    tab!!.customView = layoutInflater.inflate(R.layout.tab, null)

                }

                fr_parent_tab_layout.getTabAt(0)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.power)
                fr_parent_tab_layout.getTabAt(1)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.data)
                fr_parent_tab_layout.getTabAt(2)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.energy)
                fr_parent_tab_layout.getTabAt(3)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.temperature)
                fr_parent_tab_layout.getTabAt(4)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.speed)

            }

            FRS.CALCULATE -> {

                for (i in 0 .. 1){

                    val tab = fr_parent_tab_layout.getTabAt(i)
                    tab!!.customView = layoutInflater.inflate(R.layout.tab, null)

                }

                fr_parent_tab_layout.getTabAt(0)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.bmi)
                fr_parent_tab_layout.getTabAt(1)!!.customView!!.findViewById<TextView>(R.id.tab_label).text = getString(R.string.loan)


            }

            FRS.SETTINGS -> { }

            else -> { }

        }

    }

}