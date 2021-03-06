package com.quiz.thequiz;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;
    private ColorStateList textcolorDefaultRb;
    private List<Question> questionList;
private int questionCounter;
private int questionCountTotal;
private   Question currentQuestion;
private int score;
private Boolean answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1= findViewById(R.id.radio_button1);
        rb2=findViewById(R.id.radio_button2);
        rb3=findViewById(R.id.radio_button3);
      buttonConfirmNext =  findViewById(R.id.button_confirm_next);
      textcolorDefaultRb = rb1.getTextColors();
      QuizDbHelper dbHelper = new QuizDbHelper(this);
      questionList =dbHelper.getALLQuestion();
      questionCountTotal = questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();



    }

private void showNextQuestion(){


        rb1.setTextColor(textcolorDefaultRb);
    rb2.setTextColor(textcolorDefaultRb);
    rb3.setTextColor(textcolorDefaultRb);
       rbGroup.clearCheck();
       if(questionCounter < questionCountTotal) {

           currentQuestion = questionList.get(questionCounter);
           textViewQuestion.setText(currentQuestion.getQuestion1());

           rb1.setText(currentQuestion.getOption1());

           rb2.setText(currentQuestion.getOption2());

           rb3.setText(currentQuestion.getOption3());
           questionCounter ++;
           textViewQuestionCount.setText("Question " + questionCounter +"/" + questionCountTotal);
           answer = false;
           buttonConfirmNext.setText("Confirm");
       } else{

           finishQuiz();

       }
}
private  void finishQuiz(){


        finish();
}
}

