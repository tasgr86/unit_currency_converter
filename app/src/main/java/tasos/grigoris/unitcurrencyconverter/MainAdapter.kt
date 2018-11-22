package tasos.grigoris.unitcurrencyconverter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_basic.view.*

class MainAdapter (
    private val context: Context,
    val type : FRS,
    _array: ArrayList<TheValue>) : RecyclerView.Adapter<MainAdapter.Holder>() {

    var array = _array

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {

        return Holder(LayoutInflater.from(context).inflate(R.layout.row_basic, p0, false))

    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {

        p0.label.text = array[p1].label
        p0.value.text = array[p1].value

    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val label = itemView.row_label
        val value = itemView.row_value
        val row_constraint = itemView.row_constraint

    }
}
