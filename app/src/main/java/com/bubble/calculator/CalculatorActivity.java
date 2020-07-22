package com.bubble.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity  {

    Button button,button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_0,button_equal,button_del,button_divide,button_multiply,button_subtraction,button_addition,button_dot;
    TextView solution, showResult;
    String num_1,num_2,num_3;
    boolean addition,subtraction,multiply,divide,deci, startNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        button_0=findViewById(R.id.bt_0);
        button_1=findViewById(R.id.bt_1);
        button_2=findViewById(R.id.bt_2);
        button_3=findViewById(R.id.bt_3);
        button_4=findViewById(R.id.bt_4);
        button_5=findViewById(R.id.bt_5);
        button_6=findViewById(R.id.bt_6);
        button_7=findViewById(R.id.bt_7);
        button_8=findViewById(R.id.bt_8);
        button_9=findViewById(R.id.bt_9);
        button_dot=findViewById(R.id.bt_dot);
        button_del=findViewById(R.id.bt_del);
        button_divide=findViewById(R.id.bt_divide);
        button_multiply=findViewById(R.id.bt_multiple);
        button_subtraction=findViewById(R.id.bt_subtraction);
        button_addition=findViewById(R.id.bt_addition);
        button_equal=findViewById(R.id.bt_equal);

        solution=findViewById(R.id.TV_sol);
        showResult =findViewById(R.id.TV_result);

        startNum = true;
        deci=false;
        num_1="";
        num_2="";
        num_3="";

        button_0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "0";
                solution.setText(solution.getText()+ "0");
                solve();
            }
        });

        button_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "1";
                solution.setText(solution.getText()+ "1");
                solve();
            }
        });

        button_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "2";
                solution.setText(solution.getText()+ "2");
                solve();
            }
        });

        button_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "3";
                solution.setText(solution.getText()+ "3");
                solve();
            }
        });

        button_4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "4";
                solution.setText(solution.getText()+ "4");
                solve();
            }
        });

        button_5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "5";
                solution.setText(solution.getText()+ "5");
                solve();
            }
        });

        button_6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "6";
                solution.setText(solution.getText()+ "6");
                solve();
            }
        });

        button_7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "7";
                solution.setText(solution.getText()+ "7");
                solve();
            }
        });

        button_8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "8";
                solution.setText(solution.getText()+ "8");
                solve();
            }
        });

        button_9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num_2 = num_2+ "9";
                solution.setText(solution.getText()+ "9");
                solve();
            }
        });

        button_dot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!deci) {
                   num_2=num_2+".";
                    solution.setText(solution.getText() + ".");
                    deci=true;
                }
            }
        });

        button_addition.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(solution.getText().length() != 0 && !addition){

                    if(startNum){
                        num_1 = num_2;

                    }else{
                        num_1=num_3;
                    }
                    num_2 ="0";
                    solution.setText(solution.getText() + "+");

                    deci=false;
                    addition = true;
                    subtraction=false;
                    multiply=false;
                    divide=false;
                    startNum =false;
                }
            }
        });

        button_subtraction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(solution.getText().length() != 0 && !subtraction){

                    if(startNum){
                        num_1 = num_2;

                    }else{
                        num_1=num_3;
                    }
                    num_2 ="0";

                    solution.setText(solution.getText() + "-");

                    deci=false;
                    addition = false;
                    subtraction=true;
                    multiply=false;
                    divide=false;
                    startNum =false;
                }
            }
        });

        button_multiply.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(solution.getText().length() != 0 && !multiply){
                    solution.setText(solution.getText() + "x");

                    if(startNum){
                        num_1 = num_2;

                    }else{
                        num_1=num_3;
                    }
                    num_2 ="0";

                    deci=false;
                    addition = false;
                    subtraction=false;
                    multiply=true;
                    divide=false;
                    startNum =false;
                }
            }
        });

        button_divide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(solution.getText().length() != 0 && !divide){
                    solution.setText(solution.getText() + "/");

                    if(startNum){
                        num_1 = num_2;

                    }else{
                        num_1=num_3;
                    }
                    num_2 ="0";

                    deci=false;
                    addition = false;
                    subtraction=false;
                    multiply=false;
                    divide=true;
                    startNum =false;
                }
            }
        });

        button_equal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(solution.getText().length() != 0 ) {
                    if (addition || subtraction || multiply || divide) {
                        if(startNum){
                            num_1 = num_2;

                        }else{
                            num_1=num_3;
                        }
                        num_2 ="0";
                        deci=false;
                    }
                }
            }
        });

    }

    private void solve() {
        if(addition){
            num_3 = Double.toString(Double.parseDouble(num_1) + Double.parseDouble(num_2));
        }
        if(subtraction){
            num_3 = Double.toString(Double.parseDouble(num_1) - Double.parseDouble(num_2));
        }
        if(multiply){
            num_3 = Double.toString(Double.parseDouble(num_1) * Double.parseDouble(num_2));
        }
        if(divide){
            num_3 = Double.toString(Double.parseDouble(num_1) / Double.parseDouble(num_2));
        }
        showResult.setText(num_3);
    }
}