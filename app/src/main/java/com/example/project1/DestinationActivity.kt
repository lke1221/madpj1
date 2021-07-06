package com.example.project1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.project1.databinding.ActivityMainBinding
import android.Manifest
import android.content.ContentProviderOperation

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build

import android.os.PersistableBundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.text.DecimalFormat

class DestinationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var selected: Int? = null
    var hasSubmitted: Boolean = false
    var textSelected: String = ""
    var index = 0
    var questions: ArrayList<Question?>? = null
    var currentQuestion: Question? = null
    var indexCurrentCorrect: Int? = null
    var buttons = ArrayList<Button>()
    var countCorrectAnswers = 0
    var startTime: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        /*findViewById<Button>(R.id.stop).setOnClickListener {
            AlarmPlay.stopAudio()
        }*/

        /*val selectedCount = intent.getIntExtra("selectedCount", 10)
        val selectedDifficulty = intent.getIntExtra("difficulty", 0)*/
        questions = QuestionFactory.create(10, 2)
        initQuestion()
        reportText()




        buttons?.add(findViewById<Button>(R.id.optionButton1))
        buttons?.add(findViewById<Button>(R.id.optionButton2))
        buttons?.add(findViewById<Button>(R.id.optionButton3))
        buttons?.add(findViewById<Button>(R.id.optionButton4))

        setButtonColors()
        setQuestionAndOptions()

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                selected = index
                setButtonColors()
            }
        }

        findViewById<Button>(R.id.submitButton).setOnClickListener {
            if (selected != null) {
                hasSubmitted = !hasSubmitted

                if (hasSubmitted) {
                    findViewById<Button>(R.id.submitButton).text = "Continue"
                    findViewById<Button>(R.id.submitButton).setTextColor(Color.BLUE)
                    toggleButtonsEnabled(false)
                    setButtonColors()
                    findViewById<ProgressBar>(R.id.progressBar).progress = index + 1

                    if (selected == indexCurrentCorrect) {
                        countCorrectAnswers++
                    }

                    reportText()
                } else {
                    index++

                    if (index < questions?.size!!) {
                        initQuestion()
                        findViewById<Button>(R.id.submitButton).text = "Submit Answer"
                        findViewById<Button>(R.id.submitButton).setTextColor(Color.RED)
                        toggleButtonsEnabled(true)
                        setButtonColors()
                        setQuestionAndOptions()
                    } else {
                        val intent = Intent(this, SummaryReport::class.java)
                        intent.putExtra("score", countCorrectAnswers)
                        intent.putExtra("total", questions?.size!!)
                        startActivity(intent)
                    }
                }
            } else {
                Toast.makeText(this, "Please select one option.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        findViewById<Button>(R.id.resetButton).setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Reset Game")
            builder.setMessage("점수가 초기화됩니다. 계속하시겠습니까?")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(this, "초기화 완료",
                    Toast.LENGTH_SHORT).show()
                resetState()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(this, "Operation Cancelled",
                    Toast.LENGTH_SHORT).show()
            }

            builder.show()
        }
    }

    fun reportText() {
        findViewById<TextView>(R.id.currentScore).text = "점수: $countCorrectAnswers"
        findViewById<TextView>(R.id.reportText).setText("${index + 1} / 10")
    }

    fun toggleButtonsEnabled(newState: Boolean = false) {
        buttons.forEach { button ->
            button.isEnabled = newState
        }
    }

    override fun onResume() {
        super.onResume()

        if (index > 0) {
            resetState()
        }
    }

    fun resetState() {
        finish()
    }

    fun initQuestion() {
        currentQuestion = questions?.get(index)
        indexCurrentCorrect = currentQuestion?.correctOption
        selected = null
        hasSubmitted = false
    }

    fun setQuestionAndOptions() {
        findViewById<TextView>(R.id.textQuestion).setText(currentQuestion?.text)
        findViewById<Button>(R.id.optionButton1).setText(currentQuestion?.option1)
        findViewById<Button>(R.id.optionButton2).setText(currentQuestion?.option2)
        findViewById<Button>(R.id.optionButton3).setText(currentQuestion?.option3)
        findViewById<Button>(R.id.optionButton4).setText(currentQuestion?.option4)
    }

    fun setButtonColors() {
        buttons.forEachIndexed { index, button ->
            setButtonColor(button, Color.BLACK, Color.WHITE)

            if (index == selected) {
                setButtonColor(button, Color.YELLOW, Color.BLACK)
                textSelected = button.text.toString()
            }

            if (hasSubmitted && index == indexCurrentCorrect) {
                setButtonColor(button, Color.GREEN, Color.WHITE)
            }
        }
    }

    fun setButtonColor(button: Button, backgroundColor: Int, textColor: Int) {
        button.setBackgroundColor(backgroundColor)
        button.setTextColor(textColor)
    }
}