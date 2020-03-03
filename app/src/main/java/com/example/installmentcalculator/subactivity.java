package com.example.installmentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class subactivity extends AppCompatActivity{


    boolean isFirstInput = true;
    int resultNumber = 0;
    char operator = '+';

    TextView resultText; //하얀색인 이유는 레퍼런스


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);
    }
    public void buttonClick(View view) {
        Button getButton = findViewById(view.getId());


        switch (view.getId()) {
            case R.id.all_clear_button:
                isFirstInput = true;
                resultNumber = 0;
                operator = '+';
                resultText.setTextColor(0xFF666666);
                resultText.setText(String.valueOf(resultNumber));
                break;



            case R.id.plus_button:
            case R.id.substract_button:
            case R.id.division_button:
            case R.id.multiply_button:
                int lastNum = Integer.parseInt(resultText.getText().toString());
                if(operator == '+') {
                    resultNumber = resultNumber + lastNum;
                }else if(operator == '-'){
                    resultNumber = resultNumber - lastNum;

                }else if(operator == '/'){
                    resultNumber = resultNumber / lastNum;

                }else if(operator == '*'){
                    resultNumber = resultNumber * lastNum;

                }
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String. valueOf(resultNumber));
                isFirstInput = true;
                break;

            case R.id.num0_button:
            case R.id.num1_button:
            case R.id.num2_button:
            case R.id.num3_button:
            case R.id.num4_button:
            case R.id.num5_button:
            case R.id.num6_button:
            case R.id.num7_button:
            case R.id.num8_button:
            case R.id.num9_button:
                if (isFirstInput) {
                    resultText.setTextColor(0xFF000000);
                    resultText.setText(getButton.getText().toString());
                    isFirstInput = false;
                } else {
                    resultText.append(getButton.getText().toString());
                }
                break;

            default:
                Toast.makeText(getApplicationContext(), getButton.getText().toString() + "버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
