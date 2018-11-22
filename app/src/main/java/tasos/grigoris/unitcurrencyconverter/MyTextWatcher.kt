package tasos.grigoris.unitcurrencyconverter

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class MyTextWatcher (var et : EditText): TextWatcher {

    var listener: (()->Unit)? = null

    override fun afterTextChanged(s: Editable?) {

        println("editext: ".plus(et.text))
        println("editable: ".plus(s.toString()))

        println("last: ".plus(s?.lastOrNull()))

        println("last: ".plus(s))



//        if(!s.isNullOrEmpty() && s.toString()[s!!.length - 1] == '0') {
//
//            println("changing to ".plus(s.toString()))
//            et.setText(s.toString())
//
//        }

//        println("text changed: ".plus(et.text).plus(" ").plus(et.text.isEmpty()))
//        println("text changed editable: ".plus(s.toString()))

//        if (!et.text.contains(".") && et.text.startsWith("0")){
//
//            val new_txt = s.toString().replaceFirst("0", "")
//            println("replacing: ".plus(s.toString()).plus(s.toString().replaceFirst("0", "")))
//            et.setText(s.toString().replaceFirst("0", ""))
//
//            println("new text: ".plus(new_txt))
//
//        }

        if (et.text.isEmpty())
            et.setText("0")


        listener?.invoke()

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

}
