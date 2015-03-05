package com.umow.android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by julio on 3/2/15.
 */
public class ActivitySetting2 extends Activity_Base {

    private Button buttonGetMowed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        {
            ((Button) findViewById(R.id.activity_setting2_recharge_button)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ActivitySetting2.this, ActivityBuyCredit.class);
                    startActivity(intent);
                }
            });
        }

        {

            ((Button) findViewById(R.id.activity_setting2_button_getmowed)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        switch (view.getId())
                        {
                            case R.id.activity_setting2_button_getmowed:
                                showButtonDialog();
                                break;
                        }
                    }

            });


        }
    }



    private void showButtonDialog()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setMessage("Are you sure you want to get your lawn at 1234 Evergreen st mowed?");

        dialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which){


                showButtonDialogConfirm();
            }
        });
        dialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which){
                Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void showButtonDialogConfirm()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setMessage("Your lawn mowing service is scheduled");

        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which){

                Toast.makeText(getApplicationContext(), "Scheduled", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_setting2;
    }



}
