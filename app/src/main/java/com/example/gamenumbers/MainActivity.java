package com.example.gamenumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    int difficult = 0;
    int[] originalArray = new int[]{
        R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4,
            R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8,
            R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12,
            R.drawable.img_13, R.drawable.img_14, R.drawable.img_15, R.drawable.img_16
    };
    int[] randomArray = new int[16];
    int counterOfClicks;
    int maxClicks;

    TextView tv;
    TextView tv1;
    TextView tvTimer;
    ImageView iv1;
    ImageView iv2;

    int imageId1;
    int imageId2;
    int lastPosition = 0;

    boolean isFullImage = false;
    boolean isFirstClick = true;

    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int k;
    int timeForGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void buttonSelectDifficult(View view){

        if(difficult != 0){
            switch(view.getId()) {
                case R.id.button_easy:
                case R.id.button_hard:
                case R.id.button_medium:
                    findViewById(R.id.button_easy).setBackgroundColor(Color.YELLOW);
                    findViewById(R.id.button_medium).setBackgroundColor(Color.YELLOW);
                    findViewById(R.id.button_hard).setBackgroundColor(Color.YELLOW);
                    difficult =0;
                    break;
            }
        }
        else{
            switch(view.getId()) {
                case R.id.button_easy:
                    findViewById(R.id.button_easy).setBackgroundColor(Color.GREEN);
                    difficult = 1;
                    findViewById(R.id.button_hard).setBackgroundColor(Color.YELLOW);
                    findViewById(R.id.button_medium).setBackgroundColor(Color.YELLOW);
                    break;
                case R.id.button_medium:
                    findViewById(R.id.button_medium).setBackgroundColor(Color.GREEN);
                    difficult = 2;
                    findViewById(R.id.button_hard).setBackgroundColor(Color.YELLOW);
                    findViewById(R.id.button_easy).setBackgroundColor(Color.YELLOW);
                    break;
                case R.id.button_hard:
                    findViewById(R.id.button_hard).setBackgroundColor(Color.GREEN);
                    difficult = 3;
                    findViewById(R.id.button_easy).setBackgroundColor(Color.YELLOW);
                    findViewById(R.id.button_medium).setBackgroundColor(Color.YELLOW);
                    break;
            }
        }
    }


    public void start(View view){
        tv = findViewById(R.id.text_1);

        TextView tv2 = findViewById(R.id.maxCount);
        tvTimer = findViewById(R.id.timer);
        if(difficult == 0){
            tv.setText("Выберите сложность для начала игры!");
            tv.setTextSize(15);
            return;
        }
        else {
            counterOfClicks = 0;


            for (int i=0; i<16; i++){
                randomArray[i] = originalArray[i];
            }
            //Сортируем новый массив по методу Фишера-Йейтса
            Random r = new Random();
            for(int i = 15; i > 0; i--){
                int j = r.nextInt(i);

                int temp = randomArray[i];
                randomArray[i] = randomArray[j];
                randomArray[j] = temp;
            }
            tv.setText("Время пошло!!!");

            if (difficult == 1){
                timeForGame = 120000;
                maxClicks = 50;
            }
            else if (difficult == 2) {
                timeForGame = 70000;
                maxClicks = 35;
            }
            else {
                timeForGame = 40000;
                maxClicks = 15;
            }


            tv2.setText(String.valueOf(maxClicks));
            mProgressBar = (ProgressBar) findViewById(R.id.progressBarHorizontal);
            k = 0;
            mProgressBar.setProgress(k);
            mProgressBar.setVisibility(View.VISIBLE);
            mCountDownTimer = new CountDownTimer(timeForGame, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    k++;
                    tvTimer.setText(String.valueOf((timeForGame / 1000) - k));
                    mProgressBar.setProgress((int) k * 100 / (timeForGame / 1000));
                }

                @Override
                public void onFinish() {
                    k++;
                    mProgressBar.setProgress(100);
                    if(!isFullImage){
                        tv.setText("Уупс, время вышло. Вы не справились с заданием :(");
                        tv.setTextSize(20);
                        mProgressBar.setVisibility(View.INVISIBLE);
                    }
                }
            };

            mCountDownTimer.start();


            ImageView btn1 = findViewById(R.id.button_1);
            btn1.setImageResource(randomArray[0]);

            ImageView btn2 = findViewById(R.id.button_2);
            btn2.setImageResource(randomArray[1]);

            ImageView btn3 = findViewById(R.id.button_3);
            btn3.setImageResource(randomArray[2]);

            ImageView btn4 = findViewById(R.id.button_4);
            btn4.setImageResource(randomArray[3]);

            ImageView btn5 = findViewById(R.id.button_5);
            btn5.setImageResource(randomArray[4]);

            ImageView btn6 = findViewById(R.id.button_6);
            btn6.setImageResource(randomArray[5]);

            ImageView btn7 = findViewById(R.id.button_7);
            btn7.setImageResource(randomArray[6]);

            ImageView btn8 = findViewById(R.id.button_8);
            btn8.setImageResource(randomArray[7]);

            ImageView btn9 = findViewById(R.id.button_9);
            btn9.setImageResource(randomArray[8]);

            ImageView btn10 = findViewById(R.id.button_10);
            btn10.setImageResource(randomArray[9]);

            ImageView btn11 = findViewById(R.id.button_11);
            btn11.setImageResource(randomArray[10]);

            ImageView btn12 = findViewById(R.id.button_12);
            btn12.setImageResource(randomArray[11]);

            ImageView btn13 = findViewById(R.id.button_13);
            btn13.setImageResource(randomArray[12]);

            ImageView btn14 = findViewById(R.id.button_14);
            btn14.setImageResource(randomArray[13]);

            ImageView btn15 = findViewById(R.id.button_15);
            btn15.setImageResource(randomArray[14]);

            ImageView btn16 = findViewById(R.id.button_16);
            btn16.setImageResource(randomArray[15]);
        }
    }



    public void buttonClick(View view) {

        if(isFirstClick){

            switch (view.getId()){
                case R.id.button_1:
                    clickFirst(R.id.button_1, 0);
                    break;
                case R.id.button_2:
                    clickFirst(R.id.button_2, 1);
                    break;
                case R.id.button_3:
                    clickFirst(R.id.button_3, 2);
                    break;
                case R.id.button_4:
                    clickFirst(R.id.button_4, 3);
                    break;
                case R.id.button_5:
                    clickFirst(R.id.button_5, 4);
                    break;
                case R.id.button_6:
                    clickFirst(R.id.button_6, 5);
                    break;
                case R.id.button_7:
                    clickFirst(R.id.button_7, 6);
                    break;
                case R.id.button_8:
                    clickFirst(R.id.button_8, 7);
                    break;
                case R.id.button_9:
                    clickFirst(R.id.button_9, 8);
                    break;
                case R.id.button_10:
                    clickFirst(R.id.button_10, 9);
                    break;
                case R.id.button_11:
                    clickFirst(R.id.button_11, 10);
                    break;
                case R.id.button_12:
                    clickFirst(R.id.button_12, 11);
                    break;
                case R.id.button_13:
                    clickFirst(R.id.button_13, 12);
                    break;
                case R.id.button_14:
                    clickFirst(R.id.button_14, 13);
                    break;
                case R.id.button_15:
                    clickFirst(R.id.button_15, 14);
                    break;
                case R.id.button_16:
                    clickFirst(R.id.button_16, 15);
                    break;
            }
        }
        else{

            switch (view.getId()){
                case R.id.button_1:
                    clickSecond(R.id.button_1, 0);
                    break;
                case R.id.button_2:
                    clickSecond(R.id.button_2, 1);
                    break;
                case R.id.button_3:
                    clickSecond(R.id.button_3, 2);
                    break;
                case R.id.button_4:
                    clickSecond(R.id.button_4, 3);
                    break;
                case R.id.button_5:
                    clickSecond(R.id.button_5, 4);
                    break;
                case R.id.button_6:
                    clickSecond(R.id.button_6, 5);
                    break;
                case R.id.button_7:
                    clickSecond(R.id.button_7, 6);
                    break;
                case R.id.button_8:
                    clickSecond(R.id.button_8, 7);
                    break;
                case R.id.button_9:
                    clickSecond(R.id.button_9, 8);
                    break;
                case R.id.button_10:
                    clickSecond(R.id.button_10, 9);
                    break;
                case R.id.button_11:
                    clickSecond(R.id.button_11, 10);
                    break;
                case R.id.button_12:
                    clickSecond(R.id.button_12, 11);
                    break;
                case R.id.button_13:
                    clickSecond(R.id.button_13, 12);
                    break;
                case R.id.button_14:
                    clickSecond(R.id.button_14, 13);
                    break;
                case R.id.button_15:
                    clickSecond(R.id.button_15, 14);
                    break;
                case R.id.button_16:
                    clickSecond(R.id.button_16, 15);
                    break;

            }
        }

    }


    public void clickFirst(int Id, int posInArray){
        counterOfClicks++;
        tv1 = findViewById(R.id.counter);
        tv1.setText(String.valueOf(counterOfClicks));
        iv1 = findViewById(Id);
        iv1.setAlpha(0.5f);
        isFirstClick = !isFirstClick;
        lastPosition = posInArray;
        imageId1 = randomArray[posInArray];
    }

    public void clickSecond(int Id, int posInArray){
        if(counterOfClicks <= maxClicks){
            iv2 = findViewById(Id);
            iv2.setAlpha(0.5f);
            isFirstClick = !isFirstClick;
            imageId2 = randomArray[posInArray];
            iv1.setImageResource(imageId2);
            iv2.setImageResource(imageId1);
            randomArray[lastPosition] = imageId2;
            randomArray[posInArray] = imageId1;
            iv1.setAlpha(1.0f);
            iv2.setAlpha(1.0f);

            if(Arrays.equals(originalArray, randomArray)){
                isFullImage = true;
                tv = findViewById(R.id.text_1);
                tv.setText("Отлично. Вы выиграли!!! ");
                tv.setTextSize(30);
                mProgressBar.setVisibility(View.INVISIBLE);
                mCountDownTimer.cancel();
            }
        }
        else{
            tv = findViewById(R.id.text_1);
            tv.setText("Уупс, превышен лимит попыток. Вы не справились с заданием :(");
            tv.setTextSize(30);
            mProgressBar.setVisibility(View.INVISIBLE);
            mCountDownTimer.cancel();
        }


    }
}

