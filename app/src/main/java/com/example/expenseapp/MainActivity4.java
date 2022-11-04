package com.example.expenseapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import es.dmoral.toasty.Toasty;

public class MainActivity4 extends AppCompatActivity {
    Button back_btn, Submitting_btn;
    EditText name, salary, exp_spending_sp;
    int getSalary;
    int getSpending;

    loading_dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getting_id();
        Activity_engine();
        dialog = new loading_dialog(this);
    }//end onCreate


    private void Activity_engine() {
        Submitting_btn.setOnClickListener(view -> {

            try {
                getSalary = Integer.parseInt(salary.getText().toString().trim());
                getSpending = Integer.parseInt(exp_spending_sp.getText().toString().trim());

            } catch (NumberFormatException e) {


            }//end catch

            if (salary.getText().toString().equals("") && exp_spending_sp.getText().toString().equals("")) {

                Toasty.error(this, "البيانات غير كاملهَ!", Toasty.LENGTH_SHORT).show();
            }//end if

            else if (getSalary < getSpending) {
                Toasty.error(this, "الحد الشهري اعلى من الراتب", Toasty.LENGTH_SHORT).show();
                exp_spending_sp.setText("");

            }//end if

            else {
                dialog.loading_alert_dialog();

                int SPEED = 1000;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dialog.dialog_dismiss();
                        Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                        intent.putExtra("new_challenge", getSpending);
                        startActivity(intent);

                        finish();

                        save_data();
                    }//end else

                }, SPEED);
            }
        });


        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity2.class);

            startActivity(intent);

            finish();


        });

    }//end method


    private void getting_id() {
        back_btn = findViewById(R.id.back_btn);
        Submitting_btn = findViewById(R.id.submitting_btn);
        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);
        exp_spending_sp = findViewById(R.id.exp_spending_sp);

    }//end method

    @Override
    public void onBackPressed() {

    }

    private void save_data() {


        SharedPreferences sh = getSharedPreferences("s", MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt("k", getSpending);
        ed.apply();


    }//end method

}//end class