package com.davidhsu.chart.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidhsu.chart.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextPageBtn.setOnClickListener {

            val row = editRow.text.toString()
            val column = editColumn.text.toString()

            val intent = Intent(this, ChartActivity::class.java).apply {
                putExtra("row", row)
                putExtra("column", column)
            }
            startActivity(intent)
        }
    }
}
