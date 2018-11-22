package tasos.grigoris.unitcurrencyconverter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fr_loan.*
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

class FRLoan : Fragment(){

    @Inject lateinit var converter: MyConverter
    var nf = NumberFormat.getInstance(Locale.getDefault())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_loan, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val twAmount = MyTextWatcher(fr_loan_input_amount)
        val twInterest = MyTextWatcher(fr_loan_input_interest)
        val twPeriod = MyTextWatcher(fr_loan_input_period)

        twAmount.listener = { calcLoan() }
        twInterest.listener = { calcLoan() }
        twPeriod.listener = { calcLoan() }

        fr_loan_input_amount.addTextChangedListener(twAmount)
        fr_loan_input_interest.addTextChangedListener(twInterest)
        fr_loan_input_period.addTextChangedListener(twPeriod)

    }


    private fun calcLoan(){

        if (!fr_loan_input_amount.text.isNullOrEmpty() && !fr_loan_input_interest.text.isNullOrEmpty()
            && !fr_loan_input_period.text.isNullOrEmpty() && fr_loan_input_interest.text.toString().toDouble() > 0
                && fr_loan_input_period.text.toString().toDouble() > 0){

            val loan = converter.getInstallment(fr_loan_input_amount.text.toString(),
                fr_loan_input_interest.text.toString(), fr_loan_input_period.text.toString().toInt())

            fr_loan_installment.text = getString(R.string.monthly_payment).plus(" : ").plus(loan.installment)
            fr_loan_total_amount.text = getString(R.string.total_amount).plus(" : ").plus(loan.totalAmount)
            fr_loan_interest.text = getString(R.string.total_interest).plus(" : ").plus(loan.interest)

        }else{

            fr_loan_installment.text = ""
            fr_loan_total_amount.text = ""
            fr_loan_interest.text = ""

        }

    }
}