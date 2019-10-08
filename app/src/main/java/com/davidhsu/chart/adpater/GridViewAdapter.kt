package com.davidhsu.chart.adpater

import android.content.Context
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import com.davidhsu.chart.R
import kotlinx.android.synthetic.main.view_grid_content.view.*

/**
 * @author : david.hsu on 2019-10-08
 */
class GridViewAdapter(val context: Context, columnNumber: Int, val rowNumber: Int, private val array: ArrayList<String>) : BaseAdapter()  {

    init {
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                // TODO Auto-generated method stub
                //要做的事情
                Log.d("test1234", "runnable")
                handler.postDelayed(this, 2000)
            }
        }
        handler.postDelayed(runnable, 1000)
    }

    private var randomColumn = (Math.random() * columnNumber).toInt()
    private var randomRow = (Math.random() * (rowNumber - 1)).toInt()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.view_grid_content, parent, false)
        if (position == randomColumn) {
            SpecialGridViewRow(view)
        } else {
            NormalGridViewRow(view)
        }
        return view
    }

    override fun getItem(position: Int): Any = array[position]

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int = array.size

    inner class NormalGridViewRow(itemView: View) {
        init {
            itemView.grid_view_grid_layout.apply {
                columnCount = 1
                rowCount = rowNumber
            }

            for (index in 0 until rowNumber) {
                val textView = TextView(context)
                textView.setBackgroundResource(R.drawable.shape_gridlayout_default_border)
                val layoutParams = GridLayout.LayoutParams().apply {
                    width = GridLayout.LayoutParams.MATCH_PARENT
                    setGravity(Gravity.CENTER)
                }

                textView.layoutParams = layoutParams
                itemView.grid_view_grid_layout.addView(textView)
            }

            itemView.grid_view_grid_layout.addView(getGridViewButton())
        }
    }

    inner class SpecialGridViewRow(itemView: View) {
        init {
            itemView.grid_view_grid_layout.apply {
                columnCount = 1
                rowCount = rowNumber
            }

            for (index in 0 until rowNumber - 1) {
                if (index == randomRow) {
                    itemView.grid_view_grid_layout.addView(getRandomTextView())
                }

                val textView = TextView(context).apply {
                    setBackgroundResource(R.drawable.shape_gridlayout_default_border)
                }
                val layoutParams = GridLayout.LayoutParams().apply {
                    width = GridLayout.LayoutParams.MATCH_PARENT
                    setGravity(Gravity.CENTER)
                }
                textView.layoutParams = layoutParams
                itemView.grid_view_grid_layout.addView(textView)
            }

            itemView.grid_view_grid_layout.addView(getGridViewButton())
            itemView.grid_view_grid_layout.setBackgroundResource(R.drawable.shape_gridview_border)
        }

    }

    private fun getRandomTextView() : TextView {
        val textView = TextView(context).apply {
            setBackgroundResource(R.drawable.shape_gridlayout_default_border)
            text = "random"
            ellipsize = TextUtils.TruncateAt.END
            setSingleLine()
        }

        val layoutParams = GridLayout.LayoutParams().apply {
            width = GridLayout.LayoutParams.MATCH_PARENT
            setGravity(Gravity.CENTER)
        }
        textView.layoutParams = layoutParams
        return textView
    }

    private fun getGridViewButton() : Button {
        val button = LayoutInflater.from(context).inflate(R.layout.button_material_default, null) as Button
        button.isClickable = false
        button.isFocusable = false
        return button
    }

}