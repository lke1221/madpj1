package com.example.project1

import android.content.Intent
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
        val rounded = (round(percent * 10.0)) / 10.0

        when (rounded) {
            in 80.0..100.0 -> {
                message = getString(R.string.pass)
                findViewById<Button>(R.id.restartGame).visibility = View.GONE
                findViewById<Button>(R.id.stop).visibility = View.VISIBLE
                findViewById<Button>(R.id.stop).setOnClickListener {
                    AlarmPlay.stopAudio()
                    finish()
                }
            }
            else -> {
                findViewById<Button>(R.id.stop).visibility = View.GONE
                findViewById<Button>(R.id.restartGame).visibility = View.VISIBLE
                message = getString(R.string.fail)
                findViewById<Button>(R.id.restartGame).setOnClickListener {
                    var restart = Intent(this, DestinationActivity::class.java)
                    startActivity(restart)
                    finish()
                }
            }
        }

        findViewById<TextView>(R.id.congratulations).setText(message)

        findViewById<TextView>(R.id.scoreReport).setText(
            "You got "+"${score.toString()} (${rounded}%)" +" out of "+
                    " ${total.toString()} " +
                    "questions correct.")

    }
}