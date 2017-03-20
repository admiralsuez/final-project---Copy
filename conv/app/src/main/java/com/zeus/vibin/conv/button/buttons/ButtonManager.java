package com.zeus.vibin.conv.button.buttons;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.zeus.vibin.conv.R;
import com.zeus.vibin.conv.button.display.DisplayHandler;
import com.zeus.vibin.conv.button.math.Maths;

//import displayhandler and math java files
/**
 * Created by cyber on 21-Feb-17.
 */
public class ButtonManager {

    //declaare objects

    private final Activity activity;
    private DisplayHandler displayHandler;
    private Maths maths;

    private Spinner extSpinner;

    private Spinner ansSpinner;

    private ArrayAdapter<CharSequence> adapter;
    private ArrayAdapter<CharSequence> adapter2;

    private boolean clearDisplayRecorder = false;

    public ButtonManager(Activity activity) {
        this.activity = activity;
        displayHandler = new DisplayHandler(activity);
        maths = new Maths(displayHandler, this);
        initButtonsAndSpinners(activity);
    }

    public void numberClick(int viewId) {
        if (clearDisplayRecorder){
            displayHandler.clearRecorder();
            clearDisplayRecorder = false;
            }

        Button button = (Button)activity.findViewById(viewId);
        String buttonText = button.getText().toString();
        displayHandler.addToDisplay(buttonText);

        }

    public void operatorClick(int viewId) {
        Button button = (Button)activity.findViewById(viewId);
        String buttonText = button.getText().toString();
        maths.setOperator(buttonText);



    }

    public void decimalClick(int viewID){
        Button button = (Button)activity.findViewById(viewID);
        String buttonText = button.getText().toString();
        displayHandler.addDecimalToDisplay(buttonText);
    }
    public void deleteClick(int viewId) {
        displayHandler.clearScreen();
    }

    public void equalsClick() {
        maths.equals();
        displayHandler.setNewNumber(true);
        maths.setFiOp(0f);
        maths.setSeOp(0f);
        maths.resetOp();
        clearDisplayRecorder = true;

    }

    public Spinner getExtSpinner(){
        return extSpinner;
    }
    public Spinner getAnsSpinner(){
        return ansSpinner;
    }

    private void initButtonsAndSpinners(Activity activity){
        extSpinner = (Spinner)activity.findViewById(R.id.Spinner);
        adapter = ArrayAdapter.createFromResource(activity, R.array.Packets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        extSpinner.setAdapter(adapter);
        extSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ansSpinner = (Spinner)activity.findViewById(R.id.Spinner2);
        adapter2 = ArrayAdapter.createFromResource(activity, R.array.Packets,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ansSpinner.setAdapter(adapter2);
        ansSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


}

