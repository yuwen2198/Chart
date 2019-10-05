package com.davidhsu.chart

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.TableLayout
import android.view.Gravity
import android.widget.TextView
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tablelayout.*

/**
 * @author : david.hsu on 2019-10-05
 */
class TableLayoutActivity : AppCompatActivity() {

    private val high = ViewGroup.LayoutParams.WRAP_CONTENT
    private val width = ViewGroup.LayoutParams.MATCH_PARENT
    private val tableRow = ArrayList<String>()
    private val tableColumn = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablelayout)

        val row = intent.getStringExtra("row").toInt()
        val column = intent.getStringExtra("column").toInt()


        for (i in 1.. row) {
            tableRow.add("第($i)行")
        }

        for (i in 1.. column) {
            tableColumn.add("第($i)列  ")
        }

        Log.d("test","tableRow size = ${tableRow.size} , tableColumn size = ${tableColumn.size}")

        //控制列數
        for(rowSize in 0 .. column) {
            val tabRow = TableRow(this)
            //控制行數
            for (columnSize in 0 until row) {

                if (rowSize == column) {
                    val tv = TextView(this).apply {
                        text = " test "
                        gravity = Gravity.CENTER
                    }
                    tabRow.addView(tv)
                } else {
                    val tv = TextView(this).apply {
                        text = tableRow[columnSize] + tableColumn[rowSize]
                        gravity = Gravity.CENTER
                    }
                    tabRow.addView(tv)
                }

            }
            tableLayout.addView(tabRow, TableLayout.LayoutParams(width, high))
        }

    }
}