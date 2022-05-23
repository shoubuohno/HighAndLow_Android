package com.webserva.wings.android.highandlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startボタンの取得
        Button startBtn = findViewById(R.id.btStart);
        BtnListener listener = new BtnListener();
        //startボタン押した際のリスナ呼び出し
        startBtn.setOnClickListener(listener);

        //highボタンの取得
        Button highBtn = findViewById(R.id.btHigh);
        //highボタン押した際のリスナ呼び出し
        highBtn.setOnClickListener(listener);

        //lowボタン取得
        Button lowBtn = findViewById(R.id.btLow);
        //lowボタン押した際のリスナ呼び出し
        lowBtn.setOnClickListener(listener);

        //数字表示部分の取得
        LinearLayout numDis = findViewById(R.id.numDis);
        //非表示化
        numDis.setVisibility(View.INVISIBLE);

        //ボタン表示部分の取得
        LinearLayout btnDis = findViewById(R.id.btnDis);
        //非表示化
        btnDis.setVisibility(View.INVISIBLE);

        //retryボタンの非表示
        Button retryBtn = findViewById(R.id.btRetry);
        retryBtn.setVisibility(View.INVISIBLE);
        retryBtn.setOnClickListener(listener);






    }

    private class BtnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //数字表示部分の取得
            LinearLayout numDis = findViewById(R.id.numDis);
            //ボタン表示部分の取得
            LinearLayout btnDis = findViewById(R.id.btnDis);
            //表示する数字のTextView取得
            TextView openNum = findViewById(R.id.openNum);
            int num1 =makeOpenNum();

            //隠している数字のを表示するテキストの取得
            TextView hideNum = findViewById(R.id.hideNum);
            int num2;

            //Retryボタンの取得
            Button retryBtn = findViewById(R.id.btRetry);

            //結果表示テキストの取得
            TextView result = findViewById(R.id.tv_result);

            //hideNumのTextView取得
            TextView hideNumText = findViewById(R.id.hideNum);
            int id = view.getId();
            switch (id) {
                case R.id.btStart:
                    //startボタンの非表示
                    view.setVisibility(View.INVISIBLE);
                    //openNumの表示

                    openNum.setText(String.valueOf(num1));
                    //数字表示武部の表示
                    numDis.setVisibility(View.VISIBLE);
                    //ボタン表示部分の表示
                    btnDis.setVisibility(View.VISIBLE);
                    break;
                case R.id.btHigh:
                    //hideNumTextViewの表示
                    hideNumText.setVisibility(View.VISIBLE);
                    //hideNumの表示
                    num2 = makeHideNum();
                    hideNum.setText(String.valueOf(num2));
                    //結果判定
                    if(num1 < num2) {
                        //結果表示
                        result.setText("You Win!");
                        //ボタン表示部分の非表示
                        btnDis.setVisibility(View.INVISIBLE);

                        //retryボタンの表示
                        retryBtn.setVisibility(View.VISIBLE);

                    } else {
                        result.setText("You Lose...");
                        //ボタン表示部分の非表示
                        btnDis.setVisibility(View.INVISIBLE);

                        //retryボタンの表示
                        retryBtn.setVisibility(View.VISIBLE);

                    }
                    result.setVisibility(View.VISIBLE);
                    break;
                case R.id.btLow:
                    //hideNumTextViewの表示
                    hideNumText.setVisibility(View.VISIBLE);
                    //hideNumの表示
                    num2 = makeHideNum();
                    hideNum.setText(String.valueOf(num2));
                    //結果判定
                    if(num1 > num2) {
                        //結果表示
                        result.setText("You Win!");
                        //ボタン表示部分の非表示
                        btnDis.setVisibility(View.INVISIBLE);

                        //retryボタンの表示
                        retryBtn.setVisibility(View.VISIBLE);
                    } else {
                        result.setText("You Lose...");
                        //ボタン表示部分の非表示
                        btnDis.setVisibility(View.INVISIBLE);

                        //retryボタンの表示
                        retryBtn.setVisibility(View.VISIBLE);
                    }
                    result.setVisibility(View.VISIBLE);
                    break;
                case R.id.btRetry:
                    //結果部分の非表示
                    result.setVisibility(View.INVISIBLE);
                    //hideNumTextViewの非表示
                    hideNumText.setVisibility(View.INVISIBLE);
                    //retryボタンの非表示
                    view.setVisibility(View.INVISIBLE);
                    //openNumの表示
                    //  num1 =makeOpenNum();
                    openNum.setText(String.valueOf(num1));
                    //数字表示武部の表示
                    numDis.setVisibility(View.VISIBLE);
                    //ボタン表示部分の表示
                    btnDis.setVisibility(View.VISIBLE);
                    break;

            }
        }
    }


    public static int makeOpenNum() {
        Random rnd = new Random();
        int openNum = openNum = rnd.nextInt(8) + 1;
        return openNum;
    }

    public static int makeHideNum() {
        Random rnd = new Random();
        int hideNum = hideNum = rnd.nextInt(8) + 1;
        return hideNum;
    }


}

//    Button button = findViewById(R.id.button);
//button.setVisibility(View.VISIBLE); // 表示する場合
//        button.setVisibility(View.INVISIBLE); // 非表示にする場合