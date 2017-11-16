package com.example.android.calci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String num1 = "";
    String num2 = "";
    String operator;
    int sign = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button resultButton = (Button) findViewById(R.id.result_button);


        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1 != "" && num2 != "") {
                    //String resultDisp = String.format("%.4f");
                    double n1, n2;
                    n1 = Double.valueOf(num1);
                    n2 = Double.valueOf(num2);
                    double result;
                    //if (sign == 0)
                    //displayResult(result);
                    if (sign == 1)
                        result = n1 + n2;
                    else if (sign == 2)
                        result = n1 - n2;
                    else if (sign == 3)
                        result = n1 * n2;
                    else
                        result = n1 / n2;
                    num1 = String.valueOf(result);
                    num2 = "";
                    displayResult(result);
                    //display(num1);
                } else if (num1 == "") {
                    Toast.makeText(MainActivity.this, "Enter First Number", Toast.LENGTH_SHORT).show();
                    //displayResult("Syntax Error");
                } else if (num2 == "") {
                    Toast.makeText(MainActivity.this, "Enter Second Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void inputNumOne(View view) {
        if (sign == 0)
            num1 += "1";
        else
            num2 += "1";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }

    public void inputNumTwo(View view) {
        if (sign == 0)
            num1 += "2";
        else
            num2 += "2";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }

    public void inputNumThree(View view) {
        if (sign == 0)
            num1 += "3";
        else
            num2 += "3";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }

    public void inputNumFour(View view) {
        if (sign == 0)
            num1 += "4";
        else
            num2 += "4";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }

    public void inputNumFive(View view) {
        if (sign == 0)
            num1 += "5";
        else
            num2 += "5";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }

    public void inputNumSix(View view) {
        if (sign == 0)
            num1 += "6";
        else
            num2 += "6";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }

    public void inputNumSeven(View view) {
        if (sign == 0)
            num1 += "7";
        else
            num2 += "7";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }


    public void inputNumEight(View view) {
        if (sign == 0)
            num1 += "8";
        else
            num2 += "8";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }

    public void inputNumNine(View view) {
        if (sign == 0)
            num1 += "9";
        else
            num2 += "9";

        if (sign == 0)
            display(num1);
        else
            display(num1, operator, num2);
    }

    public void inputNumZero(View view) {
        if (sign == 0)
            num1 += "0";
        else
            num2 += "0";

        if (sign == 0)
            display(num1);
        else
            display(num2);
    }


    public void inputOperatorAdd(View view) {
        operator = "+";
        sign = 1;
        display(num1 + " " + operator);
    }

    public void inputOperatorSub(View view) {
        operator = "-";
        sign = 2;
        display(num1 + " " + operator);
    }

    public void inputOperatorMul(View view) {
        operator = "*";
        sign = 3;
        display(num1 + " " + operator);
    }

    public void inputOperatorDiv(View view) {
        operator = "/";
        sign = 4;
        display(num1 + " " + operator);
    }

    public void reset_all(View view) {
        num1 = "";
        num2 = "";
        sign = 0;
        display("0");
        displayResult(0);
    }

    public void displayResult(double number) {
        TextView displayTextView = (TextView) findViewById(R.id.result_display);
        displayTextView.setText("" + number);
        displayTextView.setMaxLines(1);
    }


    /*public void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.number_display);
        quantityTextView.setText("Syntax Error!!" );
    }
    */
    public void displayResult(String number) {
        TextView displayTextView = (TextView) findViewById(R.id.result_display);
        displayTextView.setText("" + number);
        displayTextView.setMaxLines(1);
    }

    public void display(String number) {
        TextView displayTextView = (TextView) findViewById(R.id.number_display);
        displayTextView.setText("" + number);
        displayTextView.setMaxLines(1);
    }

    public void display(String number1, String operator, String number2) {
        TextView displayTextView = (TextView) findViewById(R.id.number_display);
        displayTextView.setText(number1 + " " + operator + " " + number2);
        displayTextView.setMaxLines(1);
    }




}

