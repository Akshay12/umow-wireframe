package com.umow.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by julio on 3/2/15.
 */
public class ActivitySetting2 extends Activity_Base {

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




    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_setting2;
    }



}
