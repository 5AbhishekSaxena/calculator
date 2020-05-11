package com.example.android.calci.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.calci.R;
import com.example.android.calci.adapter.KeyAdapter;
import com.example.android.calci.utility.InfixCalculator;
import com.example.android.calci.model.Key;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private String num1 = "";
    private String num2 = "";
    private String operator;
    private int sign = 0;

    private RecyclerView recyclerView;

    private TableLayout tableLayout;

    private KeyAdapter adapter;

    private List<Key> keys;

    private StringBuilder expression = new StringBuilder();

    private final int WRAP_CONTENT = TableRow.LayoutParams.WRAP_CONTENT;
    private final int MATCH_Parent = TableRow.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerView = findViewById(R.id.buttons_recyclerView);

        //keys = addKeys();
/*

        adapter = new KeyAdapter(this, keys, this);

        recyclerView.setAdapter(adapter);
        //GridLayoutManager manager = new GridLayoutManager(this, Utility.calculateNoOfColumns(this, 120));
        GridLayoutManager manager = new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
*/


        tableLayout = findViewById(R.id.calculator_table_layout);

        TableRow tr = new TableRow(this);

        tr.setLayoutParams(new TableRow.LayoutParams(MATCH_Parent, 0, 1));


        Button button = new Button(this);
        button.setText("test button");
        button.setLayoutParams(new TableRow.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        tr.addView(button);
        tableLayout.addView(tr, new TableRow.LayoutParams(WRAP_CONTENT, MATCH_Parent));
        /*final Button resultButton = (Button) findViewById(R.id.result_button);*/


       /* resultButton.setOnClickListener(new View.OnClickListener() {
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
        });*/
    }
/*
    public void displayResult(double number) {
        TextView displayTextView = findViewById(R.id.result_display);
        displayTextView.setText("" + number);
        displayTextView.setMaxLines(1);
    }


    *//*public void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.number_display);
        quantityTextView.setText("Syntax Error!!" );
    }
    *//*
    public void displayResult(String number) {
        TextView displayTextView = findViewById(R.id.result_display);
        displayTextView.setText(number);
        displayTextView.setMaxLines(1);
    }

    public void display(String number) {
        TextView displayTextView = findViewById(R.id.number_display);
        displayTextView.setText(number);
        displayTextView.setMaxLines(1);
    }

    *//*public void display(String number1, String operator, String number2) {
        TextView displayTextView = findViewById(R.id.number_display);
        displayTextView.setText(number1 + " " + operator + " " + number2);
        displayTextView.setMaxLines(1);
    }*//*

    private List<Key> addKeys() {
        List<Key> keys = new ArrayList<>();

        keys.add(new Key("7"));
        keys.add(new Key("8"));
        keys.add(new Key("9"));
        keys.add(new Key("/"));
        keys.add(new Key("4"));
        keys.add(new Key("5"));
        keys.add(new Key("6"));
        keys.add(new Key("*"));
        keys.add(new Key("1"));
        keys.add(new Key("2"));
        keys.add(new Key("3"));
        keys.add(new Key("+"));
        keys.add(new Key("0"));
        keys.add(new Key("="));
        keys.add(new Key("C"));
        keys.add(new Key("-"));
        return keys;
    }


    @Override
    public void onClick(int position, String key) {
        Toast.makeText(this, "Key Pressed: " + key, Toast.LENGTH_SHORT).show();
        switch (key) {
            case "C":
                expression = new StringBuilder();
                display("0");
                displayResult(0);
                break;
            case "=":
                try {
                    displayResult(new InfixCalculator(expression.toString()).calculate()); //TODO: apply infix solution
                } catch (UnsupportedOperationException e) {
                    displayResult(e.getMessage());
                }
                break;
            default:
                expression.append(key);
                display(expression.toString());
                break;
        }
    }*/
}

