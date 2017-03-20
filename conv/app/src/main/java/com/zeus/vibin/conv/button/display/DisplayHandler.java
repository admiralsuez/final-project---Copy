package com.zeus.vibin.conv.button.display;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import com.zeus.vibin.conv.R;

/**
 * Created by cyber on 21-Feb-17.
 */
public class DisplayHandler {


    private EditText display;
    private TextView displayRecorder;
    private boolean newNumber =true;

    public DisplayHandler(Activity activity) {
        display = (EditText)activity.findViewById(R.id.display);
        displayRecorder = (TextView)activity.findViewById(R.id.recorder);

    }
    public void addToDisplay(String userInput){
        if (newNumber) {
            clearScreen();
            newNumber = false;

        }
    display.append(userInput);
    }

    public void editDisplay(){
        String currentString = display.getText().toString();
        if (currentString.length() > 0) {
                String editedString = currentString.substring(0, currentString.length() - 1);
            clearScreen();
            display.append(editedString);

        }
    }

    public void addDecimalToDisplay(String userInput) {
        if(!display.getText().toString().contains(".")){
            display.append(userInput);
        }
    }

    public void clearScreen() {
        display.setText("");
        displayRecorder.setText("");
        }
    public EditText getDisplay() {
        return display;
    }
    public void setDisplay(String s) {
        display.setText(s);
    }
    public void setNewNumber(boolean changeNewNumber)  {
        newNumber = changeNewNumber;
    }
    public void clearRecorder() {
    displayRecorder.setText("");
}
    public void addToRecorder(String packets, float f, String operator){
            displayRecorder.append(f + packets + " " + operator);

    }
    public void addSingleValue(float f, String s) {
        displayRecorder.setText(f+ s);
    }
}


