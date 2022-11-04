package com.example.expenseapp;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import es.dmoral.toasty.Toasty;

public class MainActivity2 extends AppCompatActivity {
    private static final String SHARED = "S";
    private static final String SHARED1 = "S1";
    private static final String SHARED2 = "S2";
    private static final String SHARED3 = "S3";
    private static final String SHARED4 = "S4";
    private static final String SHARED5 = "S5";
    private static final String SHARED6 = "S6";
    private static final String SHARED7 = "S7";
    private static final String SHARED8 = "S8";
    private static final String SHARED9 = "S9";
    private static final String KEY1 = "K";
    private static final String KEY2 = "K1";
    private static final String KEY3 = "K2";
    private static final String KEY4 = "K3";
    private static final String KEY5 = "K4";
    private static final String KEY6 = "K5";
    private static final String KEY7 = "K6";
    private static final String KEY8 = "K7";
    private static final String KEY9 = "K8";
    private static final String KEY10 = "K9";
    Button expense_btn, exit2_btn, submitting_btn;
    int saved_data;
    String getting_name;
    TextView expense, user_expense_btn, num1, num2, num3, num4, num5, num6, num7, delete_data_btn, app_info, update_data, salary, name, exp_spending_sp, user_name;
    int new_challenge;
    CardView user_spent;
    Button internet_expense_btn, personalCare_expense_btn, food_expense_btn, transfer_expense_btn, gas_expense_btn, charity_expense_btn, debts_expense_btn;
    Button user_submitting, user_canceling, exit_btn;
    EditText user_number;
    ImageView arrow, arrow2, dev_twitter, dev_insta;
    CardView small_active, startActivity;
    int new_number;
    int detect;
    String save_name;
    int save_salary;
    String save_ex_spending;
    Intent intent;
    int convert1;
    int convert2;
    int old_number;
    int result;
    int increase, increase1, increase2, increase3, increase4, increase5, increase6;
    Animation animation;
    WebView w;
    public loading_dialog dialog;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dialog = new loading_dialog(MainActivity2.this);

        getting_elements_id();


        app_start();

        app_engine();



        show_data();
        show_data1();
        show_data2();
        show_data3();
        show_data4();
        show_data5();
        show_data6();
        show_data7();
        show_data8();
        show_data9();
        show_data10();
        closing_app_engine();


        setAnimation();


    }//end onCreate

    private void app_start() {

        SharedPreferences sharedPreferences = getSharedPreferences("k", MODE_PRIVATE);
        String FirstTime = sharedPreferences.getString("ft", "");

        if (FirstTime.equals("Yes")) {

            startActivity.setVisibility(View.GONE);

        }//end if

        else {

            exit2_btn.setOnClickListener(view -> {

                if (exit2_btn.isPressed()) {

                    System.exit(0);

                }//end if

            });


            submitting_btn.setOnClickListener(view -> {


                try {

                    convert1 = Integer.parseInt(exp_spending_sp.getText().toString().trim());
                    convert2 = Integer.parseInt(salary.getText().toString().trim());

                } catch (NumberFormatException e) {


                }


                if (submitting_btn.isPressed() && exp_spending_sp.getText().toString().equals("") || name.getText().toString().equals("") || salary.getText().toString().equals("")) {

                    Toasty.error(this, "البيانات غير كاملهَ!", Toasty.LENGTH_SHORT).show();


                }//end if


                else if (submitting_btn.isPressed() && convert1 > convert2) {


                    Toasty.error(this, "الحد الشهري اعلى من الراتب", Toasty.LENGTH_SHORT).show();
                    exp_spending_sp.setText("");

                }//end if

                else if (submitting_btn.isPressed()) {


                    SharedPreferences.Editor e = sharedPreferences.edit();
                    e.putString("ft", "Yes");
                    e.apply();
                    expense_btn.setEnabled(false);
                    exit_btn.setEnabled(false);
                    user_spent.setEnabled(false);
                    internet_expense_btn.setEnabled(false);
                    personalCare_expense_btn.setEnabled(false);
                    transfer_expense_btn.setEnabled(false);
                    food_expense_btn.setEnabled(false);


                    save_ex_spending = (exp_spending_sp.getText().toString().trim());

                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    startActivity.setAnimation(animation);
                    startActivity.setVisibility(View.GONE);
                    int toInt = Integer.parseInt(save_ex_spending);
                    new_challenge = toInt;
                    save_data1(new_challenge);
                    save_data10();
                    ValueAnimator v = ValueAnimator.ofInt(new_challenge);
                    v.addUpdateListener(valueAnimator -> {


                        expense.setText(v.getAnimatedValue().toString());
                    });

                    v.start();


                    expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    user_spent.setEnabled(true);
                    internet_expense_btn.setEnabled(true);

                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);


                }//end if
            });


        }//end else


    }//end method

    private void app_engine() {


        expense_btn.setOnClickListener(view -> {


            if (expense_btn.isPressed()) {
                dialog.loading_alert_dialog();

                int SPEED = 1000;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        dialog.dialog_dismiss();
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        intent.putExtra("data1", increase);
                        intent.putExtra("data2", increase1);
                        intent.putExtra("data3", increase2);
                        intent.putExtra("data4", increase3);
                        intent.putExtra("data5", new_challenge);
                        intent.putExtra("data6", result);
                        intent.putExtra("data7", new_challenge - result);

                        startActivity(intent);
                        finish();

                        restart_engine();


                    }
                }, SPEED);


            }//end if

        });

        internet_expense_btn.setOnClickListener(view -> {

            user_spent.setVisibility(View.VISIBLE);


            animation = AnimationUtils.loadAnimation(this, R.anim.app_animation);

            user_spent.setAnimation(animation);

            user_submitting.setEnabled(true);
            user_number.setEnabled(true);
            user_canceling.setEnabled(true);
            internet_expense_btn.setEnabled(false);
            personalCare_expense_btn.setEnabled(false);
            transfer_expense_btn.setEnabled(false);
            expense_btn.setEnabled(false);
            food_expense_btn.setEnabled(false);
            exit_btn.setEnabled(false);
            expense_btn.setEnabled(false);

            user_canceling.setOnClickListener(view2 -> {

                if (user_canceling.isPressed()) {

                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);

                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);


                    user_spent.setVisibility(View.INVISIBLE);

                    internet_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);


                }//end if

            });


            user_submitting.setOnClickListener(view1 -> {


                if (user_submitting.isPressed() && user_number.getText().toString().equals("")) {

                    Toasty.error(this, "لا توجد بيانات ", Toast.LENGTH_SHORT).show();

                }//end if

                else {
                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);

                    increase();
                    new_number = Integer.parseInt(user_number.getText().toString().trim());

                    old_number = Integer.parseInt(user_expense_btn.getText().toString().trim());

                    result = new_number + old_number;
                    number_animation();

                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);


                    user_spent.setVisibility(View.INVISIBLE);

                    result_engine();

                    internet_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);

                }


            });


        });


        gas_expense_btn.setOnClickListener(view -> {

            user_spent.setVisibility(View.VISIBLE);


            animation = AnimationUtils.loadAnimation(this, R.anim.app_animation);

            user_spent.setAnimation(animation);

            user_submitting.setEnabled(true);
            user_number.setEnabled(true);
            user_canceling.setEnabled(true);
            internet_expense_btn.setEnabled(false);
            debts_expense_btn.setEnabled(false);
            charity_expense_btn.setEnabled(false);
            personalCare_expense_btn.setEnabled(false);
            gas_expense_btn.setEnabled(false);
            transfer_expense_btn.setEnabled(false);
            expense_btn.setEnabled(false);
            food_expense_btn.setEnabled(false);
            exit_btn.setEnabled(false);
            expense_btn.setEnabled(false);

            user_canceling.setOnClickListener(view2 -> {

                if (user_canceling.isPressed()) {

                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);

                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);


                    user_spent.setVisibility(View.INVISIBLE);

                    internet_expense_btn.setEnabled(true);
                    gas_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    debts_expense_btn.setEnabled(true);
                    charity_expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);


                }//end if

            });


            user_submitting.setOnClickListener(view1 -> {


                if (user_submitting.isPressed() && user_number.getText().toString().equals("")) {

                    Toasty.error(this, "لا توجد بيانات ", Toast.LENGTH_SHORT).show();

                }//end if

                else {
                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);

                    increase4();
                    new_number = Integer.parseInt(user_number.getText().toString().trim());

                    old_number = Integer.parseInt(user_expense_btn.getText().toString().trim());

                    result = new_number + old_number;
                    number_animation();

                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);


                    user_spent.setVisibility(View.INVISIBLE);

                    result_engine();

                    internet_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    gas_expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    debts_expense_btn.setEnabled(true);
                    charity_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);

                }


            });


        });

        debts_expense_btn.setOnClickListener(view -> {

            user_spent.setVisibility(View.VISIBLE);


            animation = AnimationUtils.loadAnimation(this, R.anim.app_animation);

            user_spent.setAnimation(animation);

            user_submitting.setEnabled(true);
            user_number.setEnabled(true);
            user_canceling.setEnabled(true);
            debts_expense_btn.setEnabled(false);
            charity_expense_btn.setEnabled(false);
            internet_expense_btn.setEnabled(false);
            personalCare_expense_btn.setEnabled(false);
            gas_expense_btn.setEnabled(false);
            transfer_expense_btn.setEnabled(false);
            expense_btn.setEnabled(false);
            food_expense_btn.setEnabled(false);
            exit_btn.setEnabled(false);
            expense_btn.setEnabled(false);

            user_canceling.setOnClickListener(view2 -> {

                if (user_canceling.isPressed()) {

                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);

                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);


                    user_spent.setVisibility(View.INVISIBLE);

                    internet_expense_btn.setEnabled(true);
                    gas_expense_btn.setEnabled(true);
                    debts_expense_btn.setEnabled(true);
                    charity_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);


                }//end if

            });


            user_submitting.setOnClickListener(view1 -> {


                if (user_submitting.isPressed() && user_number.getText().toString().equals("")) {

                    Toasty.error(this, "لا توجد بيانات ", Toast.LENGTH_SHORT).show();

                }//end if

                else {
                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);

                    increase5();
                    new_number = Integer.parseInt(user_number.getText().toString().trim());

                    old_number = Integer.parseInt(user_expense_btn.getText().toString().trim());

                    result = new_number + old_number;
                    number_animation();

                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);


                    user_spent.setVisibility(View.INVISIBLE);

                    result_engine();

                    internet_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    gas_expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    debts_expense_btn.setEnabled(true);
                    charity_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);

                }


            });


        });


        personalCare_expense_btn.setOnClickListener(view -> {

            user_spent.setVisibility(View.VISIBLE);


            animation = AnimationUtils.loadAnimation(this, R.anim.app_animation);

            user_spent.setAnimation(animation);

            user_submitting.setEnabled(true);
            user_number.setEnabled(true);
            user_canceling.setEnabled(true);
            internet_expense_btn.setEnabled(false);
            personalCare_expense_btn.setEnabled(false);
            transfer_expense_btn.setEnabled(false);
            expense_btn.setEnabled(false);
            food_expense_btn.setEnabled(false);
            exit_btn.setEnabled(false);
            expense_btn.setEnabled(false);


            user_canceling.setOnClickListener(view2 -> {

                if (user_canceling.isPressed()) {

                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);


                    user_spent.setVisibility(View.INVISIBLE);
                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);
                    internet_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);


                }//end if

            });


            user_submitting.setOnClickListener(view1 -> {


                if (user_submitting.isPressed() && user_number.getText().toString().equals("")) {

                    Toasty.error(this, "لا توجد بيانات ", Toast.LENGTH_SHORT).show();

                }//end if

                else {

                    if (user_submitting.isPressed()) {

                        increase3();
                        new_number = Integer.parseInt(user_number.getText().toString().trim());

                        old_number = Integer.parseInt(user_expense_btn.getText().toString().trim());

                        result = new_number + old_number;
                        number_animation();
                        animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                        user_spent.setAnimation(animation);


                        user_spent.setVisibility(View.INVISIBLE);

                        result_engine();
                        user_submitting.setEnabled(false);
                        user_number.setEnabled(false);
                        user_canceling.setEnabled(false);
                        internet_expense_btn.setEnabled(true);
                        expense_btn.setEnabled(true);
                        personalCare_expense_btn.setEnabled(true);
                        transfer_expense_btn.setEnabled(true);
                        food_expense_btn.setEnabled(true);
                        exit_btn.setEnabled(true);
                        expense_btn.setEnabled(true);

                    }//end if


                }//end else

            });


        });


        food_expense_btn.setOnClickListener(view -> {


            user_spent.setVisibility(View.VISIBLE);


            animation = AnimationUtils.loadAnimation(this, R.anim.app_animation);

            user_spent.setAnimation(animation);
            user_submitting.setEnabled(true);
            user_number.setEnabled(true);
            user_canceling.setEnabled(true);
            internet_expense_btn.setEnabled(false);
            personalCare_expense_btn.setEnabled(false);
            transfer_expense_btn.setEnabled(false);
            expense_btn.setEnabled(false);
            food_expense_btn.setEnabled(false);
            exit_btn.setEnabled(false);
            expense_btn.setEnabled(false);

            user_canceling.setOnClickListener(view2 -> {

                if (user_canceling.isPressed()) {


                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);

                    user_spent.setVisibility(View.INVISIBLE);

                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);
                    internet_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);


                }//end if

            });

            user_submitting.setOnClickListener(view1 -> {


                if (user_submitting.isPressed() && user_number.getText().toString().equals("")) {

                    Toasty.error(this, "لا توجد بيانات ", Toast.LENGTH_SHORT).show();

                }//end if

                else {

                    if (user_submitting.isPressed()) {
                        increase1();

                        new_number = Integer.parseInt(user_number.getText().toString().trim());

                        old_number = Integer.parseInt(user_expense_btn.getText().toString().trim());

                        result = new_number + old_number;

                        number_animation();
                        animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                        user_spent.setAnimation(animation);


                        user_spent.setVisibility(View.INVISIBLE);


                        result_engine();
                        user_submitting.setEnabled(false);
                        user_number.setEnabled(false);
                        user_canceling.setEnabled(false);
                        internet_expense_btn.setEnabled(true);
                        expense_btn.setEnabled(true);
                        personalCare_expense_btn.setEnabled(true);
                        transfer_expense_btn.setEnabled(true);
                        food_expense_btn.setEnabled(true);
                        exit_btn.setEnabled(true);
                        expense_btn.setEnabled(true);
                    }//end if

                }//end else

            });


        });


        transfer_expense_btn.setOnClickListener(view -> {


            user_spent.setVisibility(View.VISIBLE);

            animation = AnimationUtils.loadAnimation(this, R.anim.app_animation);

            user_spent.setAnimation(animation);

            user_submitting.setEnabled(true);
            user_number.setEnabled(true);
            user_canceling.setEnabled(true);
            internet_expense_btn.setEnabled(false);
            personalCare_expense_btn.setEnabled(false);
            transfer_expense_btn.setEnabled(false);
            expense_btn.setEnabled(false);
            food_expense_btn.setEnabled(false);
            exit_btn.setEnabled(false);
            expense_btn.setEnabled(false);

            user_canceling.setOnClickListener(view2 -> {

                if (user_canceling.isPressed()) {


                    animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                    user_spent.setAnimation(animation);

                    user_spent.setVisibility(View.INVISIBLE);

                    user_submitting.setEnabled(false);
                    user_number.setEnabled(false);
                    user_canceling.setEnabled(false);
                    internet_expense_btn.setEnabled(true);
                    expense_btn.setEnabled(true);
                    personalCare_expense_btn.setEnabled(true);
                    transfer_expense_btn.setEnabled(true);
                    food_expense_btn.setEnabled(true);
                    exit_btn.setEnabled(true);
                    expense_btn.setEnabled(true);


                }//end if

            });


            user_submitting.setOnClickListener(view1 -> {


                if (user_submitting.isPressed() && user_number.getText().toString().equals("")) {

                    Toasty.error(this, "لا توجد بيانات ", Toast.LENGTH_SHORT).show();

                }//end if

                else {

                    if (user_submitting.isPressed()) {

                        increase2();
                        new_number = Integer.parseInt(user_number.getText().toString().trim());

                        old_number = Integer.parseInt(user_expense_btn.getText().toString().trim());

                        result = new_number + old_number;
                        number_animation();
                        animation = AnimationUtils.loadAnimation(this, R.anim.app_animation_after);

                        user_spent.setAnimation(animation);


                        user_spent.setVisibility(View.INVISIBLE);

                        result_engine();
                        user_submitting.setEnabled(false);
                        user_number.setEnabled(false);
                        user_canceling.setEnabled(false);
                        internet_expense_btn.setEnabled(true);
                        expense_btn.setEnabled(true);
                        personalCare_expense_btn.setEnabled(true);
                        transfer_expense_btn.setEnabled(true);
                        food_expense_btn.setEnabled(true);
                        exit_btn.setEnabled(true);
                        expense_btn.setEnabled(true);

                    }//end if

                }//end else

            });


        });


    }//end method

    private void getting_elements_id() {

        user_name = findViewById(R.id.user_name);
        expense_btn = findViewById(R.id.reload_btn);
        expense = findViewById(R.id.expense);
        user_expense_btn = findViewById(R.id.user_expense_btn);
        internet_expense_btn = findViewById(R.id.internet_expense_btn);
        user_spent = findViewById(R.id.user_spent);
        user_submitting = findViewById(R.id.user_submitting);
        user_number = findViewById(R.id.user_number);
        personalCare_expense_btn = findViewById(R.id.personalCare_expense_btn);
        food_expense_btn = findViewById(R.id.food_expense_btn);
        transfer_expense_btn = findViewById(R.id.transfer_expense_btn);
        exit_btn = findViewById(R.id.exit_btn);
        user_canceling = findViewById(R.id.user_canceling);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        small_active = findViewById(R.id.small_active);
        arrow = findViewById(R.id.arrow);
        arrow2 = findViewById(R.id.arrow1);
        delete_data_btn = findViewById(R.id.delete_data_btn);
        dev_insta = findViewById(R.id.dev_insta);
        dev_twitter = findViewById(R.id.dev_twitter);
        update_data = findViewById(R.id.update_data);
        app_info = findViewById(R.id.app_info);
        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);
        exp_spending_sp = findViewById(R.id.exp_spending_sp);
        exit2_btn = findViewById(R.id.exit2_btn);
        startActivity = findViewById(R.id.startActivity);
        submitting_btn = findViewById(R.id.submitting_btn);
        gas_expense_btn = findViewById(R.id.gas_expense_btn);
        debts_expense_btn = findViewById(R.id.debts_expense_btn);
        charity_expense_btn = findViewById(R.id.charity_expense_btn);

    }//end method

    private void result_engine() {

        user_expense_btn.setText(result + "");

        save_data();
    }//end method


    private void save_data() {


        user_expense_btn.setText(result + "");
        SharedPreferences sh = getSharedPreferences(SHARED, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();
        ed.putInt(KEY1, result);
        ed.apply();


    }//end method


    private void show_data() {

        SharedPreferences sh = getSharedPreferences(SHARED, MODE_PRIVATE);

        result = sh.getInt(KEY1, 0);


        user_expense_btn.setText(result + "");


    }//end method


    private void save_data1(int save) {
new_challenge = save;
        expense.setText(new_challenge + "");

        SharedPreferences sh = getSharedPreferences(SHARED1, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt(KEY2, new_challenge);
        ed.apply();



    }//end method


    private void show_data1() {


        SharedPreferences sh = getSharedPreferences(SHARED1, MODE_PRIVATE);


        new_challenge = sh.getInt(KEY2, 0);


        expense.setText(new_challenge + "");


    }//end method




    private void show_data2() {

        SharedPreferences sh = getSharedPreferences("s", MODE_PRIVATE);


        new_challenge = sh.getInt("k", new_challenge);


        expense.setText(new_challenge + "");



    }//end method

    private void save_data3() {


        num1.setText(increase + "");
        SharedPreferences sh = getSharedPreferences(SHARED2, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt(KEY3, increase);
        ed.apply();


    }//end method


    private void show_data3() {

        SharedPreferences sh = getSharedPreferences(SHARED2, MODE_PRIVATE);


        increase = sh.getInt(KEY3, 0);


        num1.setText(increase + "");


    }//end method

    private void save_data4() {


        num2.setText(increase1 + "");
        SharedPreferences sh = getSharedPreferences(SHARED3, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt(KEY4, increase1);
        ed.apply();


    }//end method


    private void show_data4() {

        SharedPreferences sh = getSharedPreferences(SHARED3, MODE_PRIVATE);


        increase1 = sh.getInt(KEY4, 0);


        num2.setText(increase1 + "");


    }//end method

    private void save_data5() {


        num3.setText(increase2 + "");
        SharedPreferences sh = getSharedPreferences(SHARED4, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt(KEY5, increase2);
        ed.apply();


    }//end method


    private void show_data5() {

        SharedPreferences sh = getSharedPreferences(SHARED4, MODE_PRIVATE);


        increase2 = sh.getInt(KEY5, 0);


        num3.setText(increase2 + "");


    }//end method


    private void save_data6() {


        num4.setText(increase3 + "");
        SharedPreferences sh = getSharedPreferences(SHARED5, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt(KEY6, increase3);
        ed.apply();


    }//end method


    private void show_data6() {

        SharedPreferences sh = getSharedPreferences(SHARED5, MODE_PRIVATE);


        increase3 = sh.getInt(KEY6, 0);


        num4.setText(increase3 + "");


    }//end method


    private void save_data7() {


        num5.setText(increase4 + "");
        SharedPreferences sh = getSharedPreferences(SHARED6, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt(KEY7, increase4);
        ed.apply();


    }//end method


    private void show_data7() {

        SharedPreferences sh = getSharedPreferences(SHARED6, MODE_PRIVATE);


        increase4 = sh.getInt(KEY7, 0);


        num5.setText(increase4 + "");


    }//end method

    private void save_data8() {


        num6.setText(increase5 + "");
        SharedPreferences sh = getSharedPreferences(SHARED7, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt(KEY8, increase5);
        ed.apply();


    }//end method


    private void show_data8() {

        SharedPreferences sh = getSharedPreferences(SHARED7, MODE_PRIVATE);


        increase5 = sh.getInt(KEY8, 0);


        num6.setText(increase5 + "");


    }//end method

    private void save_data9() {


        num7.setText(increase6 + "");
        SharedPreferences sh = getSharedPreferences(SHARED8, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putInt(KEY9, increase6);
        ed.apply();


    }//end method


    private void show_data9() {

        SharedPreferences sh = getSharedPreferences(SHARED8, MODE_PRIVATE);


        increase6 = sh.getInt(KEY9, 0);


        num7.setText(increase6 + "");


    }//end method

    private void save_data10() {


        user_name.setText(name.getText().toString() + " ,اهلا ");
        SharedPreferences sh = getSharedPreferences(SHARED9, MODE_PRIVATE);

        SharedPreferences.Editor ed = sh.edit();

        ed.putString(KEY10,name.getText().toString().trim());
        ed.apply();


    }//end method


    private void show_data10() {

        SharedPreferences sh = getSharedPreferences(SHARED9, MODE_PRIVATE);


        getting_name = sh.getString(KEY10, name.getText().toString().trim());


        user_name.setText(getting_name +  ", اهلا ");


    }//end method



    private void increase() {


        increase += 1;


        num1.setText(increase + "");


        save_data3();


    }//end method

    private void increase1() {


        increase1 += 1;


        num2.setText(increase1 + "");


        save_data4();


    }//end method

    private void increase2() {


        increase2 += 1;


        num3.setText(increase2 + "");


        save_data5();


    }//end method

    private void increase3() {


        increase3 += 1;


        num4.setText(increase3 + "");


        save_data6();


    }//end method


    private void increase4() {


        increase4 += 1;


        num5.setText(increase4 + "");


        save_data7();


    }//end method

    private void increase5() {


        increase5 += 1;


        num6.setText(increase5 + "");


        save_data8();


    }//end method

    private void increase6() {


        increase6 += 1;


        num7.setText(increase6 + "");


        save_data9();


    }//end method


    private void restart_engine() {

        int SPEED = 900;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                increase = 0;
                increase1 = 0;
                increase2 = 0;
                increase3 = 0;
                increase4 = 0;
                increase5 = 0;
                increase6 = 0;
                save_data3();
                save_data4();
                save_data5();
                save_data6();
                save_data7();
                save_data8();
                save_data9();
                result = 0;
                save_data();


            }
        }, SPEED);


    }//end method


    private void setAnimation() {


        arrow.setOnClickListener(view -> {

            if (arrow.isPressed()) {

                small_active.setVisibility(View.VISIBLE);

                dev_social_media_accounts();
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_small_active);

                small_active.setAnimation(animation);

                expense_btn.setEnabled(false);
                exit_btn.setEnabled(false);
                user_spent.setEnabled(false);
                internet_expense_btn.setEnabled(false);
                personalCare_expense_btn.setEnabled(false);
                transfer_expense_btn.setEnabled(false);
                food_expense_btn.setEnabled(false);


                delete_data_btn.setOnClickListener(view1 -> {

                    if (delete_data_btn.isPressed()) {
                        Toasty.success(this, "تم حذف البيانات بنجاح     ", Toast.LENGTH_SHORT, true).show();
                        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.animation_small_active2);

                        small_active.setAnimation(animation1);
                        small_active.setVisibility(View.GONE);
                        expense_btn.setEnabled(true);
                        exit_btn.setEnabled(true);
                        internet_expense_btn.setEnabled(true);
                        personalCare_expense_btn.setEnabled(true);
                        transfer_expense_btn.setEnabled(true);
                        food_expense_btn.setEnabled(true);
                        num1.setText("0");
                        increase = 0;
                        save_data3();
                        num2.setText("0");
                        increase2 = 0;
                        save_data4();
                        num3.setText("0");
                        increase1 = 0;
                        save_data5();
                        num4.setText("0");
                        increase3 = 0;
                        save_data6();
                        num5.setText("0");
                        increase4 = 0;
                        save_data7();
                        num6.setText("0");
                        increase5 = 0;
                        save_data8();
                        num7.setText("0");
                        increase6 = 0;
                        save_data9();

                        result = 0;
                        save_data();
                        user_expense_btn.setText("0");

                    }//end if-

                });


                update_data.setOnClickListener(view1 -> {

                    if (update_data.isPressed()) {
                        intent = new Intent(MainActivity2.this, MainActivity4.class);

                        startActivity(intent);

                    }//end if-

                });

                app_info.setOnClickListener(view1 -> {

                    if (app_info.isPressed()) {

                        intent = new Intent();


                    }//end if-

                });

            }//end if

        });
        arrow2.setOnClickListener(view -> {

            if (arrow2.isPressed()) {


                Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_small_active2);

                small_active.setAnimation(animation);
                small_active.setVisibility(View.GONE);
                expense_btn.setEnabled(true);
                exit_btn.setEnabled(true);
                internet_expense_btn.setEnabled(true);
                personalCare_expense_btn.setEnabled(true);
                transfer_expense_btn.setEnabled(true);
                food_expense_btn.setEnabled(true);
            }

        });


    }//end method

    private void closing_app_engine() {


        exit_btn.setOnClickListener(view -> {


            if (exit_btn.isPressed()) {

                System.exit(0);

            }//end if
        });
    }//end method

    private void dev_social_media_accounts() {


        dev_twitter.setOnClickListener(view -> {


            if (dev_twitter.isPressed()) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://Twitter.com/d7om37"));

                startActivity(intent);

            }//end if


        });
        dev_insta.setOnClickListener(view -> {


            if (dev_insta.isPressed()) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://Instagram.com/locv7"));

                startActivity(intent);

            }//end if


        });


    }//end method


    private void number_animation() {


        ValueAnimator v = ValueAnimator.ofInt(result);
        v.addUpdateListener(valueAnimator -> {


            user_expense_btn.setText(v.getAnimatedValue().toString());
        });

        v.start();

    }//end method


    @Override
    public void onBackPressed() {

    }

}//end class