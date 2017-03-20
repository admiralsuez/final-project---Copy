package com.zeus.vibin.conv.button.main;
import android.os.Bundle;

import android.app.Activity;

import android.view.Menu;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Spinner;

import android.view.View.OnClickListener;
import android.widget.TextView;
import com.zeus.vibin.conv.R;

import com.zeus.vibin.conv.button.main.MainActivity;


public class Ed extends MainActivity {

    /** Called when the activity is first created. */

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.edt);



        // get the button’s reference

        Button btn = (Button) findViewById(R.id.addButton);



        // Defining onclick listener for finding the result

        btn.setOnClickListener( new OnClickListener() {



            @Override

            public void onClick(View v) {


                float a;
                float b;
                double kilobits;
                double megabits;
                double megabytes;
                double time;
                // Get view references of all the UI widgets

                Spinner spr = (Spinner) findViewById(R.id.spinner1);

                //Spinner spr2 = (Spinner) findViewById(R.id.spinner2);

                EditText edtNumber1 = ( EditText) findViewById(R.id.firstValue);

                EditText edtNumber2 = ( EditText) findViewById(R.id.secondValue);

                TextView edtResult = ( TextView) findViewById(R.id.result);



                String selectedItem = (String) spr.getSelectedItem();



                //Perform the operations based on selected signs strings
                a = Float.parseFloat(edtNumber1.getText().toString());
                b = Float.parseFloat(edtNumber2.getText().toString());
                kilobits = 8192;
                megabits = 8;
                megabytes = 9.5367431640625;
                time = 3600;





                if(selectedItem.trim().equals("Megabits")){

                    double result = ((a  / (b/megabits))/time);

                    edtResult.setText(Double.toString(result));

                }else if(selectedItem.trim().equals("Kilobits")){

                    double result = ((a  / (b/kilobits))/time);

                    edtResult.setText(Double.toString(result));

                }else if(selectedItem.trim().equals("Megabytes")){

                    double result = (a  / (b/megabytes));

                    edtResult.setText(Double.toString(result));


                }else if(selectedItem.trim().equals("/")){

                    double result = ((a  / b)/time);

                    edtResult.setText(Double.toString(result));

                }

            }



        });



    }

}