package com.zeus.vibin.conv.button.math;

import com.zeus.vibin.conv.button.buttons.ButtonManager;
import com.zeus.vibin.conv.R;
import com.zeus.vibin.conv.button.display.DisplayHandler;
import com.zeus.vibin.conv.button.packetexchange.Conversion;

/**
 * Created by cyber on 22-Feb-17.
 */
public class Maths {

    private float fiOp = 0f;
    private float seOp = 0f;
    private String operator = "";

    private String firstPacket;
    private String secondPacket;
    private String ansPacket;

    private DisplayHandler displayHandler;
    private ButtonManager buttonManager;

    private Conversion conversion;

    private boolean operatorState = false;

 //
    private double answerInTarget =0d;

    public Maths(DisplayHandler d, ButtonManager b){
        displayHandler = d;
        buttonManager = b;

        conversion = new Conversion();

    }

    public void setOperator(String operatorCharacter){


        if (operatorState == false){
            displayHandler.clearRecorder();

        }
        displayHandler.addToRecorder(buttonManager.getExtSpinner().getSelectedItem().toString(),
                Float.parseFloat(displayHandler.getDisplay().getText().toString()),operatorCharacter);

        if (operatorState == true){
            calculate();

        }
        fiOp = Float.parseFloat(displayHandler.getDisplay().getText().toString());
        firstPacket = buttonManager.getExtSpinner().getSelectedItem().toString();

        operator = operatorCharacter;
        displayHandler.setNewNumber(true);
        operatorState = true;
    }

        public void equals(){
            displayHandler.addToRecorder(buttonManager.getExtSpinner().getSelectedItem().toString(),
                    Float.parseFloat(displayHandler.getDisplay().getText().toString()), "");
            calculate();

        }


    public void calculate() {
        String op = displayHandler.getDisplay().getText().toString();
        if (!op.isEmpty()) {
            seOp = Float.parseFloat(op); // can still fail when not a number
        }
            secondPacket = buttonManager.getExtSpinner().getSelectedItem().toString();
            ansPacket = buttonManager.getAnsSpinner().getSelectedItem().toString();

            try {
                double targetPacket = conversion.getPacketSize(ansPacket);
                double fiOpInTarget = 0d;

                if (firstPacket != null) {
                    double firstOperandConversion = conversion.getPacketSize(firstPacket);
                    fiOpInTarget = (fiOp * targetPacket) / firstOperandConversion;

                }
                double secondOperandConversion = conversion.getPacketSize(secondPacket);
                double seOpinTarget = (seOp * targetPacket) / secondOperandConversion;

                if (operator.equals("+")) {
                    answerInTarget = fiOpInTarget + seOpinTarget;
                }
                else if (operator.equals("-")) {
                    answerInTarget = fiOpInTarget - seOpinTarget;

                } else if (operator.equals("/")) {
                    answerInTarget = (fiOpInTarget / seOpinTarget);

                } else if (operator.equals("x")) {
                    answerInTarget = fiOpInTarget * seOpinTarget;

                } else {
                    answerInTarget = seOpinTarget;
                    displayHandler.addSingleValue(seOp, secondPacket);
                }
                displayHandler.setDisplay(String.format("%.2f", answerInTarget));
            }
                catch (Exception e) {
                    e.printStackTrace();
                    displayHandler.setDisplay("beep boop no internet. Please relaunch");
                }
            operatorState = false;


        }
    public void setFiOp(float f) {fiOp = f;
    }
    public void setSeOp(float f)
    {
        this.seOp = f;
    }
    public void resetOp() {
        operator = "";
    }
}
