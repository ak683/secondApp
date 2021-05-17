package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button yesBtn;
    private Button noBtn;
    private TextView textView;
    private Button showAnswer;

    private Question[] questions = new Question[]{
            new Question(R.string.question0,true),
            new Question(R.string.question1,true),
            new Question(R.string.question2,true),
            new Question(R.string.question3,true),
            new Question(R.string.question4,true),
            new Question(R.string.question5, true)
    };
    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        yesBtn = findViewById(R.id.btnYes);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                if(questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();

                questionIndex = (questionIndex+1)%questions.length;
                textView.setText(questions[questionIndex].getQuestionResId());
            }
        });

        noBtn = findViewById(R.id.btnNo);

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                if(questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();

                questionIndex = (questionIndex+1)%questions.length;
                textView.setText(questions[questionIndex].getQuestionResId());
            }
        });

        textView = findViewById(R.id.textView);
        textView.setText(questions[questionIndex].getQuestionResId());

        showAnswer = findViewById(R.id.showAnswer);
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer",questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("questionIndex",questionIndex);
    }
}