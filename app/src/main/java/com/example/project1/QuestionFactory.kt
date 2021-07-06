package com.example.project1

import kotlin.math.pow

class QuestionFactory() {
    companion object {
        val calcType = listOf<String>("add", "subtract", "multiply", "divide")

        fun setQuestionAttributes(text: String, result: Int): Question {
            var question = Question()
            var values
                    = mutableListOf<Int>(result + 10, result + 20, result - 10, result - 20)
            values.shuffle()
            val randomIndex = (0..3).random()
            values.set(randomIndex, result)

            question.text = text
            question.option1 = (values[0]).toString()
            question.option2 = (values[1]).toString()
            question.option3 = (values[2]).toString()
            question.option4 = (values[3]).toString()
            question.correctOption = randomIndex

            return question
        }

        fun createRandomQuestion(difficulty: Int): Question? {
            val factor = 10.0.pow(difficulty).toInt()
            val random = (calcType.indices).random()

            when (calcType.get(random)) {
                "add" -> {
                    val a = (0..(99 * factor)).random()
                    val b = (0..(99 * factor)).random()
                    val sum = a + b

                    return setQuestionAttributes("$a + $b", sum)
                }
                "subtract" -> {
                    val a = (0..(99 * factor)).random()
                    val b = (0..(99 * factor)).random()
                    val difference = a - b

                    return setQuestionAttributes("$a - $b", difference)
                }
                "multiply" -> {
                    val a = (1..(10 * factor)).random()
                    val b = (1..(10 * factor)).random()
                    val product = a * b

                    return setQuestionAttributes("$a * $b", product)
                }
                else -> {
                    var a = (0..(99 * factor)).random()
                    val b = (0..(49 * factor)).random()

                    while (a % b != 0) {
                        a++
                    }
                    val quotient = a / b

                    return setQuestionAttributes("$a / $b", quotient)
                }
            }
        }

        fun create(chargeSize: Int = 10, difficulty: Int = 0): ArrayList<Question?> {
            var randomList = ArrayList<Question?>()
            var i = 0
            while (i < chargeSize) {
                randomList.add(createRandomQuestion(difficulty))
                i++
            }

            return randomList
        }
    }
}