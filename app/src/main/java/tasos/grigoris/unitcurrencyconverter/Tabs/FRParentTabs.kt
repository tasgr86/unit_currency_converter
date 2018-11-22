package tasos.grigoris.unitcurrencyconverter.Tabs

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fr_parent_tabs.*
import tasos.grigoris.unitcurrencyconverter.*

class FRParentTabs : Fragment() {

    private lateinit var myView : View
    private lateinit var type : FRS

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        myView = inflater.inflate(R.layout.fr_parent_tabs, container, false)

        return myView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        type = arguments!!.getSerializable("fr") as FRS

        println("fr parent ".plus(type))

        initTabs()
        startLastFragment()

        fr_parent_tabs_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {}

            override fun onTabUnselected(p0: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {

                val pos = tab!!.position
                val bundle = Bundle()
                val fr = FRChild()

                when(type){

                    FRS.BASIC -> {

                        when(pos){

                            0 -> bundle.putSerializable("fr", FRS.LENGTH)
                            1 -> bundle.putSerializable("fr", FRS.CURRENCY)
                            2 -> bundle.putSerializable("fr", FRS.WEIGHT)
                            3 -> bundle.putSerializable("fr", FRS.AREA)

                        }
                    }


                    FRS.CALCULATE -> {

                        val fragm : Fragment

                        when(pos) {

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
                        loadFragment(fragm)
                        return

                    }

                    else -> { }
                }

                fr.arguments = bundle
                loadFragment(fr)

            }

        })

    }


    private fun initTabs(){

        val numOfTabs : Int = if (type == FRS.CALCULATE) 2
        else 4

        for (i in 0 until numOfTabs) {

            fr_parent_tabs_tab_layout.addTab(fr_parent_tabs_tab_layout.newTab())

        }

        when (type){

            FRS.BASIC -> {

                fr_parent_tabs_tab_layout.getTabAt(0)!!.text = getString(R.string.length)
                fr_parent_tabs_tab_layout.getTabAt(1)!!.text = getString(R.string.currency)
                fr_parent_tabs_tab_layout.getTabAt(2)!!.text = getString(R.string.weight)
                fr_parent_tabs_tab_layout.getTabAt(3)!!.text = getString(R.string.area)

            }

            FRS.CALCULATE -> {

                fr_parent_tabs_tab_layout.getTabAt(0)!!.text = getString(R.string.bmi)
                fr_parent_tabs_tab_layout.getTabAt(1)!!.text = getString(R.string.loan)

            }

            else -> { }

        }


    }


    private fun startLastFragment (){

        val bundle = Bundle()
        val fr = FRChild()

        when (type){

            FRS.BASIC -> {
                bundle.putSerializable("fr", FRS.LENGTH)
            }

            FRS.CALCULATE -> {

                val bmi = FRBMI()
                bundle.putSerializable("fr", FRS.BMI)
                fr.arguments = bundle
                loadFragment(bmi)
                return

            }

            else -> { }

        }

        fr.arguments = bundle
        loadFragment(fr)

    }


    private fun loadFragment(fr : Fragment){

        childFragmentManager.beginTransaction().replace(fr_parent_tab_frame.id, fr).commit()

    }

}