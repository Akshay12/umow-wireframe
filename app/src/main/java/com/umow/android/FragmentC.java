package com.umow.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentC extends Fragment {

    private EditText zip_code;
    private TextView cost;
    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View intro3 = inflater.inflate(R.layout.intro_3, container, false);
        //zipcode for price
        editText = (EditText) intro3.findViewById(R.id.zipcode);
        //editText.setText("78705");
        cost = (TextView) intro3.findViewById(R.id.cost);
        //editText = (EditText) getView().findViewById(R.id.zipcode);
        //((EditText) zip_code = ((EditText) findViewById(R.id.zipcode))

                editText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
             cost.setVisibility(View.VISIBLE);

            }
        });







        // join button to create account
                {
            ((Button) intro3.findViewById(R.id.join_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ActivityCreateAccount.class);
                    startActivity(intent);
                }
            });

        }
        return intro3;



    }

}



