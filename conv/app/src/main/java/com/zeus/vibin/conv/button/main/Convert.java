package com.zeus.vibin.conv.button.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zeus.vibin.conv.R;
import com.zeus.vibin.conv.button.buttons.ButtonManager;

/**
 * Created by cyber on 12-Mar-17.
 */



public class Convert extends MainActivity {

    ButtonManager buttonManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonManager = new ButtonManager(this);

        }

public void numberClicked(View v) {
        buttonManager.numberClick(v.getId());
        }
public void operatorClicked(View v){
        buttonManager.operatorClick(v.getId());
        }
public void equalClicked(View v){
        buttonManager.equalsClick();
        }
public void decimalClicked(View v){
        buttonManager.decimalClick(v.getId());
        }
public  void deleteClicked(View v){
        buttonManager.deleteClick(v.getId());
        }
        }
