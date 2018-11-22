package tasos.grigoris.unitcurrencyconverter

import android.content.Context
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceViewHolder
import android.util.AttributeSet
import android.widget.SeekBar
import android.widget.TextView

class MyCustomSeekbar : Preference {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    private lateinit var prefs : MyPrefs

    override fun onBindViewHolder(holder: PreferenceViewHolder?) {
        super.onBindViewHolder(holder)

//        val prefs = MyPrefs(context)
        val initialValue = prefs.getDecimals()

        val tv = holder?.findViewById(R.id.seekbar_label) as TextView
        val seekbar = holder.findViewById(R.id.seekBar) as SeekBar
        tv.text = context.getString(R.string.decimals_number).plus(" ").plus(initialValue)
        seekbar.progress = initialValue - 2

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                tv.text = context.getString(R.string.decimals_number).plus(" ").
                    plus(progress + 2)

                prefs.storeDecimal(progress + 2)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
    }
}