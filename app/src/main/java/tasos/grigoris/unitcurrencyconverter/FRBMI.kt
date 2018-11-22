package tasos.grigoris.unitcurrencyconverter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fr_bmi.*
import javax.inject.Inject

class FRBMI : Fragment() {

    @Inject lateinit var converter: MyConverter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fr_bmi, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showBMI()

        val twWeight = MyTextWatcher(fr_bmi_input_weight)
        val twHeight = MyTextWatcher(fr_bmi_input_height)

        twWeight.listener = { showBMI() }
        twHeight.listener = { showBMI() }

        fr_bmi_input_weight.addTextChangedListener(twWeight)
        fr_bmi_input_height.addTextChangedListener(twHeight)

    }

    private fun getWeight() : Double{

        return fr_bmi_input_weight.text.toString().toDouble()

    }

    private fun getHeight() : Double{

        return fr_bmi_input_height.text.toString().toDouble()

    }

    private fun showBMI(){

        if (!fr_bmi_input_weight.text.isEmpty() && !fr_bmi_input_height.text.isEmpty()
            && fr_bmi_input_height.text.toString() != "0")

            fr_bmi_result.text = getString(R.string.bmi_result).plus(" ").
                plus(converter.getBMI(getWeight(), getHeight()))

        else
            fr_bmi_result.text = ""

    }

}