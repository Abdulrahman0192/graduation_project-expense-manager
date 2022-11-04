package com.example.expenseapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class loading_dialog {


    private Activity activity;
    private AlertDialog alertDialog;

    loading_dialog(Activity my_activity) {

        activity = my_activity;

    }//end constructor

    void loading_alert_dialog() {

        AlertDialog.Builder a = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        a.setView(inflater.inflate(R.layout.loading_custom, null));
        a.setCancelable(false);

        alertDialog = a.create();
        alertDialog.show();


    }//end method

    void dialog_dismiss() {

        alertDialog.dismiss();

    }//end method

}//end class
