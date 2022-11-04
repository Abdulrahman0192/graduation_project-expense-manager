package com.example.expenseapp;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button new_month, back_btn;
    TextView text, number, text2, number2, challenged_money, spent_money, result;
    ImageView image, image2;
    loading_dialog dialog = new loading_dialog(MainActivity3.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getting_data();

        activity_engine();
    }//end onCreate


    private void activity_engine() {

        getting_outsider_data();

        new_month.setOnClickListener(view -> {

            dialog.loading_alert_dialog();

            int SPEED = 1000;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {


                    dialog.dialog_dismiss();
int toInt = Integer.parseInt(challenged_money.getText().toString().trim());
                    Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                    intent.putExtra("s",toInt);
                    startActivity(intent);

                    finish();

                }
            }, SPEED);


        });


    }//end method

    private void getting_outsider_data() {


        Intent in = getIntent();

        int x5 = in.getIntExtra("data5", 0);
        int x6 = in.getIntExtra("data6", 0);
        int x7 = in.getIntExtra("data7", 0);


        ValueAnimator v = ValueAnimator.ofInt(x5);

        v.addUpdateListener(valueAnimator -> {


            challenged_money.setText(v.getAnimatedValue().toString());

        });

        v.start();
        @SuppressLint("Recycle") ValueAnimator v2 = ValueAnimator.ofInt(x6);

        v2.addUpdateListener(valueAnimator -> {


            spent_money.setText(v2.getAnimatedValue().toString());

        });

        @SuppressLint("Recycle") ValueAnimator v3 = ValueAnimator.ofInt(x7);
        v2.start();
        v3.addUpdateListener(valueAnimator -> {


            result.setText(v3.getAnimatedValue().toString());
        });

        v3.start();


        if (x7 <= 0) {

            result.setTextColor(Color.RED);


        }//end if


    }//end method

    private void getting_data() {

        new_month = findViewById(R.id.new_month);


        challenged_money = findViewById(R.id.challenged_number);
        spent_money = findViewById(R.id.spent_money);
        result = findViewById(R.id.result);

    }//end method


}//end class