package com.umow.android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

/**
 * Created by julio on 3/2/15.
 */
public class ActivitySetting2 extends Activity_Base {
    private TextView address2;
    private Button buttonGetMowed;
    String address;
    private EditText notes;
    private String notes2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




      ParseUser user = ParseUser.getCurrentUser();
      String  add_temp = user.getString("Address");
      address = add_temp;
      address2 = (TextView) findViewById(R.id.textView16);
      address2.setText(address);
        /*
        address2 = (TextView) findViewById(R.id.textView16);
        // ADDRESS BULLSHIT PART 1
        Intent i = getIntent();
            String temp =i.getExtras().get("star_Address").toString();
            String temp2 =i.getExtras().get("usr_address").toString();

        if(temp == null){
            address = temp2;
            address2.setText(temp2);
        }
        if (temp != null) {
            address = temp;
            address2.setText(temp);

        }
        */
        // Notes
        notes = (EditText) findViewById(R.id.editText6);
        notes2= notes.getText().toString();



         /* {
            ((Button) findViewById(R.id.activity_setting2_recharge_button)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ActivitySetting2.this, ActivityBuyCredit.class);
                    startActivity(intent);
                }
            });
        }




        {
            ((Button) findViewById(R.id.setting_2_setting)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ActivitySetting2.this, ActivitySetting.class);
                    startActivity(intent);
                }
            });
        }
        */

        {
            ((Button) findViewById(R.id.logout)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ParseUser.logOut();
                    ParseUser currentUser = ParseUser.getCurrentUser();
                    Intent intent = new Intent(ActivitySetting2.this, ActivityFirstPage.class);
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

        dialogBuilder.setMessage("Are you sure you want to get your lawn at "+ address + " mowed?");

        dialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {


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
        dialogBuilder.setMessage("Proceed to payment");

        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which){

                //Toast.makeText(getApplicationContext(), "Scheduled", Toast.LENGTH_SHORT).show();
                //notes2= notes.getText().toString();
                Intent intent = new Intent(ActivitySetting2.this, ActivityPayment.class);
                intent.putExtra("notes", notes2);
                intent.putExtra("address",address);
                startActivity(intent);
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
