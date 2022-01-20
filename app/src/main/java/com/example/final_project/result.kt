package com.example.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class result : AppCompatActivity() {

    private lateinit var tv_name:TextView
    private lateinit var tv_score:TextView
    private lateinit var tv_congratulations:TextView
    private lateinit var btn_finish:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tv_name = findViewById(R.id.tv_name)
        tv_score = findViewById(R.id.tv_score)
        btn_finish = findViewById(R.id.btn_finish)
        tv_congratulations = findViewById(R.id.tv_congratulations)


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        if(correctAnswers >= 5){
            tv_congratulations.text = "გილოცავთ"
            tv_score.text = "თქვენ დააგროვეთ $correctAnswers სწორი პასუხი $totalQuestions-დან"
        }
        if(correctAnswers < 5){
            tv_congratulations.text = "როგორ მოგილოცოთ?!"
            tv_score.text = "სამწუხაროდ თქვენ დააგროვეთ $correctAnswers სწორი პასუხი $totalQuestions-დან"
        }


        btn_finish.setOnClickListener {
            startActivity(Intent(this@result, MainActivity2::class.java))
        }

    }
}