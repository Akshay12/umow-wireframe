package com.umow.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;


/**
 * Created by julio on 3/2/15.
 */
public class ActivitySetting extends Activity_Base {

    private EditText Name_view;
    private EditText Addressview;
    private EditText zipcodeView;
    private EditText phoneView;
    private EditText cityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // name view constructor variables setting to current user

        ParseUser user = ParseUser.getCurrentUser();

        Name_view = (EditText) findViewById(R.id.setting_name);
        Addressview = (EditText) findViewById(R.id.editText2);
        zipcodeView = (EditText) findViewById(R.id.editText4);
        cityView = (EditText) findViewById(R.id.editText3);
        phoneView = (EditText) findViewById(R.id.editText5);

        //if already registered
        if ((user.has("Name"))){
            Name_view.setText(user.get("Name").toString());
            Addressview.setText(user.get("Address").toString());
            cityView.setText(user.get("City").toString());
            zipcodeView.setText(user.get("Zipcode").toString());
            phoneView.setText(user.get("Phonenumber").toString());
        }

        // error message if fields are left blank.
        {
            ((Button) findViewById(R.id.activity_setting_save_button)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Validate the log in data
                    boolean validationError = false;
                    StringBuilder validationErrorMessage =
                            new StringBuilder("Please");
                    if ((Name_view.getTextSize() == 0)) {
                        validationError = true;
                        validationErrorMessage.append("Enter your Name");
                    }
                    if ((Addressview.getTextSize() == 0)) {
                        if (validationError) {
                            validationErrorMessage.append(",and");
                        }
                        validationError = true;
                        validationErrorMessage.append("enter your Address");
                    }
                    if ((cityView.getTextSize() == 0)) {
                        validationError = true;
                        validationErrorMessage.append("Enter your Name");
                    }
                    if ((zipcodeView.getTextSize() == 0)) {
                        validationError = true;
                        validationErrorMessage.append("Enter your Zipcode");
                    }
                    if ((phoneView.getTextSize() == 0)) {
                        validationError = true;
                        validationErrorMessage.append("Enter your Phone Number");
                    }
                    validationErrorMessage.append(".");

                    // If there is a validation error, display the error
                    if (validationError) {
                        Toast.makeText(ActivitySetting.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                                .show();
                        return;
                    }
                    ParseUser user = ParseUser.getCurrentUser();

                    user.put("Name", Name_view.getText().toString());
                    user.put("Address", Addressview.getText().toString());
                    user.put("City", cityView.getText().toString());
                    user.put("Zipcode", Integer.valueOf(zipcodeView.getText().toString()));
                    user.put("Phonenumber", Integer.valueOf(phoneView.getText().toString()));
                    user.saveInBackground();


                    Intent intent = new Intent(ActivitySetting.this, ActivitySetting2.class);
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_setting;
    }





}
