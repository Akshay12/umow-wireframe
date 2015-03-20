package com.umow.android;

import android.content.Intent;
import android.os.Bundle;
import com.parse.ParseUser;


public class ActivityUMow extends Activity_Base {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null){
            // address part 3

            String temp = currentUser.get("Address").toString();
            Intent intent = new Intent(ActivityUMow.this, ActivitySetting2.class);
            intent.putExtra("star_Address", temp);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(ActivityUMow.this, Activity_intro.class);
            startActivity(intent);
            finish();
        }
    }


    @Override protected int getContentViewResourceId() {
        return R.layout.activity_umow;
    }
}
