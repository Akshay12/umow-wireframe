package com.umow.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import android.view.View;

public class FragmentA extends Fragment implements View.OnClickListener {

    Button join;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View intro1 = inflater.inflate(R.layout.intro_1, container, false);


        //join button to create account
        {
            ((Button) intro1.findViewById(R.id.join_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                   Intent intent = new Intent(getActivity(), ActivityCreateAccount.class);
                    startActivity(intent);
                }
            });

        }
            return intro1;



    }
    @Override
    public void onClick(View v) {
        }
}
