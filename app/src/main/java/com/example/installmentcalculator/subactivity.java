package com.example.installmentcalculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class subactivity extends AppCompatActivity {


    boolean isFirstInput = true;
    int resultNumber = 0;
    char operator = '+';
    final String CLEAR_INPUUT_TEXT = "0";


    TextView resultText; //하얀색인 이유는 레퍼런스


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);
        resultText =  findViewById(R.id.result_text);
    }


    // AC, CE, BE 가 클릭되었을 때 실행되는 메소드
    public void buttonClick(View view) {

        switch (view.getId()) {
            case R.id.all_clear_button:
                resultNumber = 0;
                operator = '+';
                setClearText(CLEAR_INPUUT_TEXT);
                break;

            case R.id.clear_entry_button:
                setClearText(CLEAR_INPUUT_TEXT);
                break;

            case R.id.backsapce_button:
                if(resultText.getText().toString().length() > 1){
                    String getResultText = resultText.getText().toString();
                    String subString = getResultText.substring(0,getResultText.length() -1);
                    resultText.setText(subString);
                }
                else{
                    setClearText(CLEAR_INPUUT_TEXT);
                }
                break;

            case R.id.decimal_button:
                Log.e("buttonClick", "buttonClick 시작 : decimal_button버 튼이 클릭되었습니다.");
                break;

            default:
                break;
        }
    }

    // 입력된 숫자를 클리어 시켜 주는 메소드
    public void setClearText(String clearText){
        isFirstInput = true;
        resultText.setTextColor(0xFF666666);
        resultText.setText(clearText);
    }

    // 0 ~ 9 버튼이 클릭되었을때 실행되는 메소드
    public void numButtonClick(View view){
        Button getButton = findViewById(view.getId());

        if (isFirstInput) {
            resultText.setTextColor(0xFF000000);
            resultText.setText(getButton.getText().toString());
            isFirstInput = false;
        } else {
            if(resultText.getText().toString().equals(CLEAR_INPUUT_TEXT)){
                Toast.makeText(getApplicationContext(), "0으로 시작하는 정수는 없습니다.", Toast.LENGTH_SHORT).show();
                setClearText(CLEAR_INPUUT_TEXT);
            }  else {
                resultText.append(getButton.getText().toString());
            }
        }
    }



    // 연산자가 클릭 되었을 때 클릭 되는 메소드
    public void operatorClick(View view) {
        Button getButton = findViewById(view.getId());

        if (view.getId() == R.id.result_button) {
            if (isFirstInput) {
                resultNumber = 0;
                operator = '+';
                setClearText(CLEAR_INPUUT_TEXT);
                // TODO: 2020-07-29 다음에 실수형 계산기 만들때 윈도우 계산기처럼 =을 두번 이상 누를때 실행 방법과 같이 구현할것!

            } else {
                resultNumber = intCal(resultNumber, Integer.parseInt(resultText.getText().toString()), operator);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
            }

        } else {
            if(isFirstInput){
                operator = getButton.getText().toString().charAt(0);
            } else {
                int lastNum = Integer.parseInt(resultText.getText().toString());
                resultNumber = intCal(resultNumber, lastNum, operator);
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
            }
        }
    }


    // 사칙연산을 해서 값을 반환해 주는 메소드
    public int intCal(int result, int lastNum, char operator){
        if(operator == '+'){
            result += lastNum;
        } else if(operator == '-'){
            result -= lastNum;
        } else if(operator == '/'){
            result /= lastNum;
        } else if(operator == '*'){
            result *= lastNum;
        }
        return result;
    }

}
