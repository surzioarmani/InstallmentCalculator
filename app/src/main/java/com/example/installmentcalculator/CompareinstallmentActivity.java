package com.example.installmentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompareinstallmentActivity  extends AppCompatActivity {

    EditText ProductPrice1, ProductPrice2, Installmentmonth1, Installmentmonth2, Freemonth1, Freemonth2, InterestRate1, InterestRate2;
    Button Check, Result;
    TextView Total1, Total2;

    String num1, num2, num3, num4, num5, num6, num7, num8;
    Integer total1, total2, Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipleinstallment);

        ProductPrice1 = (EditText) findViewById(R.id.product_price1);
        ProductPrice2 = (EditText) findViewById(R.id.product_price2);
        Installmentmonth1 = (EditText) findViewById(R.id.installment_month);
        Freemonth1 = (EditText) findViewById(R.id.free_month);
        InterestRate1 = (EditText) findViewById(R.id.interest_rate);
        Check = (Button) findViewById(R.id.check);
        Total1 = (TextView)findViewById(R.id.total_price1);
        Installmentmonth2 = (EditText) findViewById(R.id.installment_month2);
        Freemonth2 = (EditText) findViewById(R.id.free_month2);
        InterestRate2 = (EditText) findViewById(R.id.interest_rate2);
        Result = (Button)findViewById(R.id.result_button);
        Total2 = (TextView)findViewById(R.id.total_price2);

        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CompareinstallmentActivity.class);
                Option option1 = new Option(Num1, Num2, Num3, Num4, total1); //납부월수, 할부잔액, 원금, 수수료, 월납부액
                Option option2 = new Option(Num5, Num6, Num7, Num8, total2);
                intent.putExtra("class1", option1);
                intent.putExtra("class2", option1);

                startActivity(intent);
            }

        });



        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///1번째 제품
                num1 = ProductPrice1.getText().toString();//제품가격num1
                num2 = Installmentmonth1.getText().toString();//할부개월num2
                num3 = Freemonth1.getText().toString();//무이자개월num3
                num4 = InterestRate1.getText().toString();//수수료율num4

                Num1 = Integer.parseInt(num1);
                Num2 = Integer.parseInt(num2);
                Num3 = Integer.parseInt(num3);
                Num4 = Integer.parseInt(num4);

                total1 = (Integer.parseInt(num1)*(Integer.parseInt(num2)+1)*Integer.parseInt(num4)/2)/1200;
                Total1.setText(String.valueOf(total1));//할부수수료 총액total

                ///2번째 제품
                num5 = ProductPrice2.getText().toString();//제품가격num5
                num6 = Installmentmonth2.getText().toString();//할부개월num6
                num7 = Freemonth2.getText().toString();//무이자개월num7
                num8 = InterestRate2.getText().toString();//수수료율num8

                Num5 = Integer.parseInt(num5);
                Num6 = Integer.parseInt(num6);
                Num7 = Integer.parseInt(num7);
                Num8 = Integer.parseInt(num8);

                total2 = (Integer.parseInt(num5)*(Integer.parseInt(num6)+1)*Integer.parseInt(num8)/2)/1200;
                Total2.setText(String.valueOf(total2));//할부수수료 총액total

                ///////////////돌아가게 되면 코드 클린하게 다시 만질게





            }
        });
    }






}
