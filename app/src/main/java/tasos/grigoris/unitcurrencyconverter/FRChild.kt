package tasos.grigoris.unitcurrencyconverter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fr_child.*
import javax.inject.Inject

class FRChild : Fragment() {

    private lateinit var type : FRS
    private lateinit var selectedCurrency : String
    private lateinit var selectedItem : MyEnums
    private lateinit var generator : ListGenerator
    private lateinit var userSelections: UserSelections

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fr_child, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        type = arguments!!.getSerializable("fr") as FRS

        userSelections = UserSelections(view.context)
        selectedCurrency = userSelections.getCurrency()

        setUpInitialValues()

        generator = ListGenerator(view.context, type)

        loadAdapter(view.context, type)

        val tw = MyTextWatcher(fr_child_layout_value)
        tw.listener = {

            loadAdapter(view.context, type)

        }

        fr_child_layout_value.addTextChangedListener(tw)
        fr_child_layout_item.setOnClickListener {

            if (type == FRS.CURRENCY)
                showCurrencyAD(view.context)
            else
                showAD(view.context) }

    }


    private fun loadAdapter(context: Context, type : FRS){

        if (type == FRS.CURRENCY){

            val ratesList : LinkedHashMap<String, ArrayList<String>> = generator.generateCurrencyList(selectedCurrency, getEnteredValue())
            fr_child_rv.layoutManager = LinearLayoutManager(context)
            fr_child_rv.adapter = CurrencyAdapter(context, ratesList)

        }else{

            val list : ArrayList<TheValue> = when (type) {

                FRS.TEMPERATURE -> generator.generateTempList(selectedItem, getEnteredValue())
                else -> generator.generateList(context, selectedItem, getEnteredValue())

            }

            fr_child_rv.layoutManager = LinearLayoutManager(context)
            fr_child_rv.adapter = MainAdapter(context, type, list)

        }
    }


    private fun getEnteredValue() : String{

        return fr_child_layout_value.text.toString()

    }



    private fun showCurrencyAD(context: Context){

        val ratesList : LinkedHashMap<String, ArrayList<String>> = generator.generateCurrencyList(selectedCurrency, getEnteredValue())

        val items = ratesList["labels"]
        val cs = items!!.toTypedArray()

        AlertDialog.Builder(context).setItems(cs) { dialog, which ->

            fr_child_selectet_label.text = items[which]
            selectedCurrency = cs[which]
            userSelections.storeCurrency(selectedCurrency)
            loadAdapter(context, type)

            dialog.dismiss()

        }.show()

    }


    private fun showAD(context: Context){

        val list : ArrayList<MyEnums> = generator.getEnums(type)
        val items = getNames(context, list)

        AlertDialog.Builder(context).setItems(items) { dialog, which ->

            fr_child_selectet_label.text = items[which]
            selectedItem = list[which]
            loadAdapter(context, type)

            userSelections.updateSelections(type, selectedItem)

            dialog.dismiss()

        }.show()

    }

    private fun getNames(context: Context, aList: ArrayList<MyEnums>): Array<CharSequence> {

        return aList.map { context.getString(it.fullName) }.toTypedArray()

    }


    private fun setUpInitialValues(){

        val map = userSelections.getMap()

        when (type) {

            FRS.LENGTH -> {

                fr_child_selectet_label.text = getString(map[FRS.LENGTH]!!.fullName)
                selectedItem = map[FRS.LENGTH]!!

            }
            FRS.WEIGHT -> {

                fr_child_selectet_label.text = getString(map[FRS.WEIGHT]!!.fullName)
                selectedItem = map[FRS.WEIGHT]!!

            }
            FRS.AREA -> {

                fr_child_selectet_label.text = getString(map[FRS.AREA]!!.fullName)
                selectedItem = map[FRS.AREA]!!

            }
            FRS.FUEL -> {

                fr_child_selectet_label.text = getString(map[FRS.FUEL]!!.fullName)
                selectedItem = map[FRS.FUEL]!!

            }
            FRS.VOLUME -> {

                fr_child_selectet_label.text = getString(map[FRS.VOLUME]!!.fullName)
                selectedItem = map[FRS.VOLUME]!!

            }
            FRS.POWER -> {

                fr_child_selectet_label.text = getString(map[FRS.POWER]!!.fullName)
                selectedItem = map[FRS.POWER]!!

            }
            FRS.DATA -> {

                fr_child_selectet_label.text = getString(map[FRS.DATA]!!.fullName)
                selectedItem = map[FRS.DATA]!!

            }
            FRS.ENERGY -> {

                fr_child_selectet_label.text = getString(map[FRS.ENERGY]!!.fullName)
                selectedItem = map[FRS.ENERGY]!!

            }
            FRS.TEMPERATURE -> {

                fr_child_selectet_label.text = getString(map[FRS.TEMPERATURE]!!.fullName)
                selectedItem = map[FRS.TEMPERATURE]!!

            }
            FRS.SPEED -> {

                fr_child_selectet_label.text = getString(map[FRS.SPEED]!!.fullName)
                selectedItem = map[FRS.SPEED]!!

            }

            else -> { }

        }

    }

}