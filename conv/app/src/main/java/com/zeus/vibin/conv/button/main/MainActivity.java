package com.zeus.vibin.conv.button.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zeus.vibin.conv.NavDrawer;
import com.zeus.vibin.conv.R;
import com.zeus.vibin.conv.button.buttons.ButtonManager;

public class MainActivity extends AppCompatActivity {


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen);

    }
public void calcButton (View view) {
    Intent intent = new Intent(this, Convert.class);
    Context context = getApplicationContext();
    CharSequence text = "Fetching last updated values";
    int duration = Toast.LENGTH_LONG;

    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
   // Button  = (EditText) findViewById(R.id.editText);
 //   String message = editText.getText().toString();
 //   intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);


}
    public void speedButton (View view) {
        Intent speed = new Intent(this, Info.class);
        Context context = getApplicationContext();
        CharSequence text = "Zoooooooom";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        startActivity(speed);

    }
    public void infoButton (View view) {
        Intent info = new Intent(this, Info.class);
        Context context = getApplicationContext();
        CharSequence text = "Fetching a nerd to help you";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        // Button  = (EditText) findViewById(R.id.editText);
        //   String message = editText.getText().toString();
        //   intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(info);

    }

    public void backButton (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        Context context = getApplicationContext();
        CharSequence text = "Did you even read bro?";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        // Button  = (EditText) findViewById(R.id.editText);
        //   String message = editText.getText().toString();
        //   intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void navButton (View view) {
        Intent intent = new Intent(this, NavDrawer.class);
        Context context = getApplicationContext();
        CharSequence text = "Did you even read bro?";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        // Button  = (EditText) findViewById(R.id.editText);
        //   String message = editText.getText().toString();
        //   intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
    public void edB (View view) {
        Intent intent = new Intent(this, Ed.class);
        Context context = getApplicationContext();
        CharSequence text = "Did you even read bro?";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        // Button  = (EditText) findViewById(R.id.editText);
        //   String message = editText.getText().toString();
        //   intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

}
