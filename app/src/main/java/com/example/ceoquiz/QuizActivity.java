package com.example.ceoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.Gravity.TOP;

public class QuizActivity extends AppCompatActivity {


    private Button mTrueButton; // кнопка ПРАВДА

    private Button mFalseButton; // кнопка Ложь

    private Button mNextButton; // кнопка ДАЛЬШЕ

    private Toast mToast;
    private Toast nToast;


    private TextView mQuestionTextView;


    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_ocean, true),
            new Question(R.string.question_president, true),
            //new Question(R.string.question_mideast, false),
            new Question(R.string.question_years, false),
            new Question(R.string.question_eat, true),
            new Question(R.string.question_asia, true),
            new Question(R.string.gorod, false),
            new Question(R.string.vlad_put, false),
    };
    private int mCurrentIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFalseButton = (Button) findViewById(R.id.true_button);

        mTrueButton = (Button) findViewById(R.id.false_button);

        mNextButton =(Button) findViewById(R.id.next_button);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        //int question = mQuestionBank[mCurrentIndex].getTextResId();
        //mQuestionTextView.setText(question);

        View.OnClickListener onTrue = new View.OnClickListener() {

            public void onClick(View v) {

                //mToast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();

                checkAnswer(true);
            }

        };


        View.OnClickListener onNext = new View.OnClickListener(){
          public void onClick(View v){

              if (mCurrentIndex + 1 < mQuestionBank.length) {
                  mCurrentIndex = mCurrentIndex+1;
              } else {
                  mCurrentIndex = 0;
              }
              //int question = mQuestionBank[mCurrentIndex].getTextResId();
             // mQuestionTextView.setText(question);
              updateQuestion();
          }
            

        };
        
        

        mNextButton.setOnClickListener(onNext);

        mTrueButton.setOnClickListener(onTrue);

        View.OnClickListener onFalse = new View.OnClickListener(){


            public void onClick (View v){

                //Toast toast = Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT);
               // toast.setGravity(Gravity.TOP,0,300);
               // toast.show();

                checkAnswer(false);

            }


        };
        mFalseButton.setOnClickListener(onFalse);

    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId(); // в int question засовываем массив с индексом (тоесть одну строку) по индексу и метод, что бы всзять эту строку
        mQuestionTextView.setText(question);
    }

    public void checkAnswer (boolean userPressTrue){

        //boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();  // Вот эта boolen answerTrue нужно что бы туда запихнуть значение строки с вопросом , это значение true ли false но можно в if и полностью записать, то что я как раз и сделал.
        int massageResId;                           // как оказалась massageResId = 0 нужен был что бы туда были вложены ссылки на строки для ТОСТА который юудет в конце метода.

        if(userPressTrue == mQuestionBank[mCurrentIndex].getAnswerTrue()){ // сначало не было никакой рекации на как бы false при вопросе про 2020 год , это было из за того что я вместо [mCurrentIndex] написал 0. Но оказалось что mCurrentIndex это
            massageResId = R.string.correct_toast;
        }
        else{
            massageResId=R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this, massageResId, Toast.LENGTH_SHORT).show();


    }




}


