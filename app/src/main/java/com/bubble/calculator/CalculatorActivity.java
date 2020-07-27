package com.bubble.calculator;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_0;
    Button button_equal;
    Button button_del;
    Button button_divide;
    Button button_multiply;
    Button button_subtraction;
    Button button_addition;
    Button button_dot;
    TextView solution, showResult;
    String stringToSolve = null;
    boolean addition, subtraction, multiply, divide, deci, firstNumber;
    String num_a = null, num_b = null, num_c = null;
    char ch, operator, lastChar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        button_0 = findViewById(R.id.bt_0);
        button_1 = findViewById(R.id.bt_1);
        button_2 = findViewById(R.id.bt_2);
        button_3 = findViewById(R.id.bt_3);
        button_4 = findViewById(R.id.bt_4);
        button_5 = findViewById(R.id.bt_5);
        button_6 = findViewById(R.id.bt_6);
        button_7 = findViewById(R.id.bt_7);
        button_8 = findViewById(R.id.bt_8);
        button_9 = findViewById(R.id.bt_9);
        button_dot = findViewById(R.id.bt_dot);
        button_del = findViewById(R.id.bt_del);
        button_divide = findViewById(R.id.bt_divide);
        button_multiply = findViewById(R.id.bt_multiple);
        button_subtraction = findViewById(R.id.bt_subtraction);
        button_addition = findViewById(R.id.bt_addition);
        button_equal = findViewById(R.id.bt_equal);

        solution = findViewById(R.id.TV_sol);
        showResult = findViewById(R.id.TV_result);

        deci = false;
        stringToSolve = "";

        button_0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("0");
                calculation();
            }
        });

        button_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("1");
                calculation();
            }
        });

        button_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("2");
                calculation();
            }
        });

        button_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("3");
                calculation();
            }
        });

        button_4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("4");
                calculation();
            }
        });

        button_5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("5");
                calculation();
            }
        });

        button_6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("6");
                calculation();
            }
        });

        button_7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("7");
                calculation();
            }
        });

        button_8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("8");
                calculation();
            }
        });

        button_9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.append("9");
                calculation();
            }
        });

        button_dot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!deci) {
                    if (lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == 'x') {
                        solution.append("0");
                    }
                    deci = true;
                    solution.append(".");
                    calculation();
                }
            }
        });

        button_addition.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (solution.getText().length() != 0 && lastChar != '+') {
                    deci = false;
                    solution.append("+");
                    calculation();
                }
            }
        });

        button_subtraction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (solution.getText().length() != 0 && lastChar != '-') {
                    deci = false;
                    solution.append("-");
                    calculation();
                }
            }
        });

        button_multiply.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (solution.getText().length() != 0 && lastChar != 'x') {
                    deci = false;
                    solution.append("x");
                    calculation();
                }
            }
        });

        button_divide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (solution.getText().length() != 0 && lastChar != '/') {
                    deci = false;
                    solution.append("/");
                    calculation();
                }
            }
        });

        button_equal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (solution.getText().length() != 0) {
                    if (addition || subtraction || multiply || divide) {
                        solution.setText(showResult.getText().toString());
                        showResult.setText("");
                    }
                }
            }
        });
        button_del.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (solution.getText().length() != 0) {
                    stringToSolve = solution.getText().toString().trim();
                    solution.setText(stringToSolve.substring(0, stringToSolve.trim().length() - 1));
                    calculation();
                }
            }
        });
        button_del.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                if (stringToSolve.length() != 0) {
                    stringToSolve = "";
                    solution.setText("");
                    showResult.setText("");
                }
                return false;
            }
        });
    }

    private void calculation() {
        stringToSolve = solution.getText().toString().trim();
        int lengthOf = stringToSolve.length();
        num_a = "0";
        num_b = "0";
        num_c = "0";
        addition = false;
        subtraction = false;
        multiply = false;
        divide = false;

        firstNumber = true;

        for (int x = 0; x < lengthOf; x++) {
            ch = stringToSolve.charAt(x);
            if (ch == '+' || ch == '-' || ch == '/' || ch == 'x') {
                operator(ch);
                if (firstNumber) {
                    num_a = num_b;
                    firstNumber = false;
                } else {
                    num_a = num_c;
                }
                num_b = "";

            } else {
                num_b += ch;
                solve();
            }

            lastChar = ch;


            solution.setText(stringToSolve);
            showResult.setText(num_c);
        }

    }

    private void operator(char ch) {

        addition = false;
        subtraction = false;
        multiply = false;
        divide = false;

        switch (ch) {
            case '+':
                addition = true;
                break;
            case 'x':
                multiply = true;
                break;
            case '-':
                subtraction = true;
                break;
            case '/':
                divide = true;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + ch);
        }
    }

    private void solve() {
        if (addition) {
            num_c = Double.toString(Double.parseDouble(num_a) + Double.parseDouble(num_b)).trim();
        }
        if (subtraction) {
            num_c = Double.toString(Double.parseDouble(num_a) - Double.parseDouble(num_b)).trim();
        }
        if (multiply) {
            num_c = Double.toString(Double.parseDouble(num_a) * Double.parseDouble(num_b)).trim();
        }
        if (divide) {
            num_c = Double.toString(Double.parseDouble(num_a) / Double.parseDouble(num_b)).trim();
        }

    }
}