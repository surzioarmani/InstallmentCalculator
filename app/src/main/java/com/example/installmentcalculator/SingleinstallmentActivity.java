package com.example.installmentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SingleinstallmentActivity extends AppCompatActivity {

    EditText ProductPrice, Installmentmonth, Freemonth, InterestRate;
    Button Check, Result;
    TextView Total;

    String num1, num2, num3, num4;
    Integer total, Num1, Num2, Num3, Num4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinstallment);

        ProductPrice = (EditText) findViewById(R.id.product_price);
        Installmentmonth = (EditText) findViewById(R.id.installment_month);
        Freemonth = (EditText) findViewById(R.id.free_month);
        InterestRate = (EditText) findViewById(R.id.interest_rate);
        Check = (Button) findViewById(R.id.check);
        Result = (Button)findViewById(R.id.result_button);
        Total = (TextView)findViewById(R.id.total_price);

        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultTableActivity.class);
                Option option = new Option(Num1, Num2, Num3, Num4, total); //납부월수, 할부잔액, 원금, 수수료, 월납부액
                intent.putExtra("class", option);
                startActivity(intent);
            }

        });



        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = ProductPrice.getText().toString();//제품가격num1
                num2 = Installmentmonth.getText().toString();//할부개월num2
                num3 = Freemonth.getText().toString();//무이자개월num3
                num4 = InterestRate.getText().toString();//수수료율num4

                Num1 = Integer.parseInt(num1);
                Num2 = Integer.parseInt(num2);
                Num3 = Integer.parseInt(num3);
                Num4 = Integer.parseInt(num4);







                total = (Integer.parseInt(num1)*(Integer.parseInt(num2)+1)*Integer.parseInt(num4)/2)/1200;
                Total.setText(String.valueOf(total));//할부수수료 총액total




            }
        });
    }






    }
