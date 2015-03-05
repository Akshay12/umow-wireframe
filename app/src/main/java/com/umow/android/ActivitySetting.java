package com.umow.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by julio on 3/2/15.
 */
public class ActivitySetting extends Activity_Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        {
            ((Button) findViewById(R.id.activity_setting_save_button)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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
