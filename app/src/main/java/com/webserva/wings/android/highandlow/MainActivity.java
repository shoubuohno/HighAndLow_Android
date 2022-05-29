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

        //ボタンの取得
        Button startBtn = findViewById(R.id.btStart);
        Button highBtn = findViewById(R.id.btHigh);
        Button lowBtn = findViewById(R.id.btLow);
        Button retryBtn = findViewById(R.id.btRetry);

        //ボタンが押されたときのインスタンス生成
        BtnListener listener = new BtnListener();

        //ボタンにリスナをセット
        startBtn.setOnClickListener(listener);
        highBtn.setOnClickListener(listener);
        lowBtn.setOnClickListener(listener);
        retryBtn.setOnClickListener(listener);

        //数字表示部分の取得
        LinearLayout numDis = findViewById(R.id.numDis);
        //非表示化
        numDis.setVisibility(View.INVISIBLE);

        //ボタン表示部分の取得
        LinearLayout btnDis = findViewById(R.id.btnDis);
        //非表示化
        btnDis.setVisibility(View.INVISIBLE);
        retryBtn.setVisibility(View.INVISIBLE);

    }

    private class BtnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //数字表示部分の取得
            LinearLayout numDis = findViewById(R.id.numDis);
            //ボタン表示部分の取得
            LinearLayout btnDis = findViewById(R.id.btnDis);
            //初めに表示する数字のTextView取得
            TextView openNum = findViewById(R.id.openNum);
            //隠している数字を表示するテキストの取得
            TextView hideNum = findViewById(R.id.hideNum);

            //Retryボタンの取得
            Button retryBtn = findViewById(R.id.btRetry);

            //結果表示テキストの取得
            TextView result = findViewById(R.id.tv_result);
            int id = view.getId();
            switch (id) {
                case R.id.btStart:
                    //startボタンの非表示
                    view.setVisibility(View.INVISIBLE);
                    //最初に表示する数字の乱数生成、変数格納
                    int num1 =makeOpenNum();
                    openNum.setText(String.valueOf(num1));
                    //数字表示部分の表示
                    numDis.setVisibility(View.VISIBLE);
                    //ボタン表示部分の表示
                    btnDis.setVisibility(View.VISIBLE);
                    break;
                case R.id.btHigh:
                    //openNumTextViewの値を取得
                    String num = openNum.getText().toString();
                    //num1に数値型に変換して格納
                    num1 = Integer.valueOf(num);
                    //hideNumTextViewの表示
                    hideNum.setVisibility(View.VISIBLE);
                    //hideNumの表示
                    int num2 = makeHideNum();
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
                    //openNumTextViewの値を取得
                    num = openNum.getText().toString();
                    num1 = Integer.valueOf(num);
                    //hideNumTextViewの表示
                    hideNum.setVisibility(View.VISIBLE);
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
                    hideNum.setVisibility(View.INVISIBLE);
                    //retryボタンの非表示
                    view.setVisibility(View.INVISIBLE);
                    //openNumの表示
                    //  num1 =makeOpenNum();
                    num1 =makeOpenNum();
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

