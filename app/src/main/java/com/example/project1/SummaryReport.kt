package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.round

class SummaryReport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_report)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        var message = ""

        val percent = (score * 100) / total
        var rounded = (round(percent * 10.0)) / 10.0

        when (rounded) {
            in 70.0..100.0 -> {
                message = getString(R.string.pass)
                findViewById<Button>(R.id.stop).visibility = View.VISIBLE
                findViewById<Button>(R.id.stop).setOnClickListener {
                    AlarmPlay.stopAudio()
                }
            }
            else -> {
                findViewById<Button>(R.id.stop).visibility = View.GONE
                message = getString(R.string.fail)
            }
        }

        findViewById<TextView>(R.id.congratulations).setText(message)

        findViewById<TextView>(R.id.scoreReport).setText(
            "You got "+"${score.toString()} (${rounded}%)" +" out of "+
                    " ${total.toString()} " +
                    "questions correct.")

        findViewById<Button>(R.id.restartGame).setOnClickListener {
            finish()
        }

    }
}