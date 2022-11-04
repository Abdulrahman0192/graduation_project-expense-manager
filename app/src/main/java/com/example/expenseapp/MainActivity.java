package com.example.expenseapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splash_screen_engine();



    }//end onCreate

    private void splash_screen_engine(){





        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Thread.sleep(1000);


                } catch (Exception e) {


                }


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        }).start();


    }//end onCreate

}//end class