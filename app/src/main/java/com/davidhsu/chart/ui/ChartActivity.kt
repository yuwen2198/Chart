package com.davidhsu.chart.ui

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.davidhsu.chart.adpater.GridViewAdapter
import com.davidhsu.chart.R
import kotlinx.android.synthetic.main.activity_tablelayout.*

/**
 * @author : david.hsu on 2019-10-05
 */
class ChartActivity : AppCompatActivity() {

    private var rowNumber = String()
    private var columnNumber = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablelayout)

        rowNumber = intent.getStringExtra("row")
        columnNumber = intent.getStringExtra("column")

        createChart(rowNumber, columnNumber)

    }

    private fun createChart(row: String, column: String) {
        val testArray = ArrayList<String>()
        for (i in 0 until column.toInt()) {
            testArray.add("測試$i")
        }
        val gridViewAdapter = GridViewAdapter(
            this,
            columnNumber.toInt(),
            rowNumber.toInt(),
            testArray
        )

        gridViewLayout.apply {
            numColumns = columnNumber.toInt()
            stretchMode = GridView.STRETCH_COLUMN_WIDTH
            adapter = gridViewAdapter
        }

    }
}