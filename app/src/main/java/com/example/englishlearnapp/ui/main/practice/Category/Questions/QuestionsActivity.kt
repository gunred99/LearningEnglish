package com.example.englishlearnapp.ui.main.practice.Category.Questions

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.englishlearnapp.R
import com.example.englishlearnapp.model.AllResults
import com.example.englishlearnapp.model.DoneFeed
import com.example.englishlearnapp.model.JoinedFeed
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_questions.*
import okhttp3.HttpUrl.Companion.toHttpUrl
import kotlin.math.abs

class QuestionsActivity:AppCompatActivity() {
    companion object{
        var allJoined: ArrayList<JoinedFeed> = ArrayList()
        var selectedAnswers: ArrayList<String> = ArrayList()
        var questionNr: Int = 0
        var isCorrect: Int = 0
        var isFailder: Int = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val endPoint : String = "https://opentdb.com/api.php?amount=10&category=21&difficulty=medium&type=multiple"
        val questions: ArrayList<String> = ArrayList()
        val allAnswers: ArrayList<ArrayList<String>> = ArrayList()
        val allCorrectAnswers: ArrayList<String> = ArrayList()

        val doneLayout: ConstraintLayout = findViewById(R.id.done)
        doneLayout.visibility = View.GONE

        val httpAsync = endPoint.httpGet()
            .responseString{request, response, result ->  
                when(result){
                    is Result.Failure -> {
                        val ex = result.getException()
                        println(ex)
                    }
                    is Result.Success ->{
                        val data = result.get()
                        val gsonBuilder = GsonBuilder().create()

                        val mainData : AllResults = gsonBuilder.fromJson(data, AllResults::class.java)

                        for ((index, value) in mainData.results.withIndex()){
                            val mainFeed = mainData.results
                            val question = mainFeed[index].question

                            questions.add(question)

                            val answers = mainFeed[index].incorrect_answers
                            answers.add((0..3).random(), mainFeed[index].correct_answer)
                            allAnswers.add(answers)

                            val canswers = mainFeed[index].correct_answer
                            allCorrectAnswers.add(canswers)
                        }
                    }
                }
            }
        httpAsync.join()

        allJoined.add(JoinedFeed(questions = questions, answers = allAnswers, correct_answers = allCorrectAnswers))
        startQuiz()
    }

    private fun startQuiz() {
        val nextBtn = findViewById<ImageButton>(R.id.next_btn)
        val totalNum = findViewById<TextView>(R.id.total_num)
        val mainQuestion = findViewById<TextView>(R.id.main_question)
        val doneLayout : ConstraintLayout = findViewById(R.id.done)
        val quizLayout: ConstraintLayout = findViewById(R.id.quiz)
        val donePop: ListView = findViewById(R.id.done_pop)

        //Display Number
        var questionNum = questionNr

        //Get current question
        val currentQuestion = allJoined[0].questions[questionNr]

        //grab the listview
        val answerListView : ListView = findViewById(R.id.answers_container)

        //increase the display number to + 1
        questionNum++
        totalNum.text = "${questionNum.toString()}/${allJoined[0].questions.count()}"

        //set the first question
        mainQuestion.text = currentQuestion

        //set the first question answers
        var qAnswers: ArrayList<String> = allJoined[0].answers[questionNr]
        setAnswers(qAnswers)

        answerListView.setOnItemClickListener { parent, view, position, id ->
            val clickId = id.toInt()
            val correctAnswer = allJoined[0].correct_answers[questionNr]
            val selectedAnswer = allJoined[0].answers[questionNr]
            val answersIsCorrect = selectedAnswer.equals(correctAnswer)

            //check if answers is correct
            if(answersIsCorrect){
                isCorrect++
            }else{
                isFailder--
            }

            if(questionNr == allJoined[0].questions.count() -1 && questionNum === 10){
                quizLayout.visibility = View.GONE
                quizLayout.visibility = View.VISIBLE

                val info: DoneFeed = DoneFeed(
                    qNumber = "${allJoined[0].questions.count()}",
                    qCorrectAnswers = "${isCorrect}",
                    qAttempted = "${10}",
                    qNegative = "${abs(isFailder)}"
                )
                donePop.adapter = DoneAdapter(this, info)
            }else{
                questionNum++
                questionNr++
            }

            totalNum.text = "${questionNum.toString()}/${allJoined[0].questions.count()}"
            mainQuestion.text = allJoined[0].questions[questionNr]

            val newAnswers = allJoined[0].answers[questionNr]
            setAnswers(newAnswers)
        }

    }

    private fun setAnswers(qAnswers: ArrayList<String>) {
        val answers: ListView = findViewById(R.id.answers_container)
        for ((index, value) in qAnswers.withIndex()){
            answers.adapter = AnswersAdapter(this, qAnswers)
        }
    }
}