package com.raroque.marktristan.block3.p1.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var option4Button: Button

    private val questions = listOf("What is the name of the yellow, cylindrical character who lives in a pineapple under the sea?", "What is the name of the cat and mouse duo who are always in a chase-and-run situation?", "Which animated film features a young lion cub named Simba and his journey to become king of the Pride Lands?")
    private val options = listOf(
        listOf("SpongeBob SquarePants", "Patrick Star", "Squid ward", "Sandy"),
        listOf("Tweety and Sylvester", "Tom and Jerry", "Batman and Robin", "Ash and Pikachu"),
        listOf("Finding Nemo", "The Lion King", " Madagascar", "Kung Fu Panda")
    )
    private val correctAnswers = listOf(0, 1, 1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        questionTextView = findViewById(R.id.questionTextView)
        option1Button = findViewById(R.id.option1Button)
        option2Button = findViewById(R.id.option2Button)
        option3Button = findViewById(R.id.option3Button)
        option4Button = findViewById(R.id.option4Button)

        displayQuestion()

        option1Button.setOnClickListener { checkAnswer(0) }
        option2Button.setOnClickListener { checkAnswer(1) }
        option3Button.setOnClickListener { checkAnswer(2) }
        option4Button.setOnClickListener { checkAnswer(3) }
    }

    private fun displayQuestion() {
        if (currentQuestionIndex < questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
            option1Button.text = options[currentQuestionIndex][0]
            option2Button.text = options[currentQuestionIndex][1]
            option3Button.text = options[currentQuestionIndex][2]
            option4Button.text = options[currentQuestionIndex][3]
        } else {
            navigateToResultActivity()
        }
    }

    private fun checkAnswer(selectedAnswerIndex: Int) {
        if (selectedAnswerIndex == correctAnswers[currentQuestionIndex]) {
            score += 10
        }

        currentQuestionIndex++
        displayQuestion()
    }


    private fun navigateToResultActivity() {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("score", score)
        startActivity(intent)
        finish()
    }
}
