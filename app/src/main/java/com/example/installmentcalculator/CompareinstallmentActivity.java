package com.example.installmentcalculator;

/*
final update 2020.07.29
author: Suah Jo
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompareinstallmentActivity  extends AppCompatActivity {

    EditText ProductPrice1, ProductPrice2, Installmentmonth1, Installmentmonth2,InterestRate1, InterestRate2;
    Button Check, Result;
    TextView Total1, Total2;

    String num1, num2, num4, num5, num6,  num8;
    int total1, total2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipleinstallment);

        total1=0;
        total2=0;

        Check = (Button) findViewById(R.id.check);
        Result = (Button)findViewById(R.id.result_button);

        ProductPrice1 = (EditText) findViewById(R.id.product_price1);
        ProductPrice2 = (EditText) findViewById(R.id.product_price2);

        Installmentmonth1 = (EditText) findViewById(R.id.installment_month1);
        InterestRate1 = (EditText) findViewById(R.id.interest_rate1);
        Total1 = (TextView)findViewById(R.id.total_price1);

        Installmentmonth2 = (EditText) findViewById(R.id.installment_month2);
        InterestRate2 = (EditText) findViewById(R.id.interest_rate2);
        Total2 = (TextView)findViewById(R.id.total_price2);





        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///1번째 제품
                num1 = ProductPrice1.getText().toString();//제품가격num1
                num2 = Installmentmonth1.getText().toString();//할부개월num2
                num4 = InterestRate1.getText().toString();//수수료율num4

                ///2번째 제품
                num5 = ProductPrice2.getText().toString();//제품가격num5
                num6 = Installmentmonth2.getText().toString();//할부개월num6
                num8 = InterestRate2.getText().toString();//수수료율num8


                int principlemoney1 = Integer.parseInt(num1) / Integer.parseInt(num2) ;
                int principlemoney2 = Integer.parseInt(num5) / Integer.parseInt(num6) ;


                for(int j=0;j<Integer.parseInt(num2);j++) {
                    total1 += (Integer.parseInt(num1) -(principlemoney1*j))*Integer.parseInt(num4)/1200;


                }
                for(int j=0;j<Integer.parseInt(num6);j++) {
                    total2 += (Integer.parseInt(num1) -(principlemoney2*j))*Integer.parseInt(num4)/1200;

                }

                Total1.setText(String.valueOf(total1));//할부수수료 총액total
                Total2.setText(String.valueOf(total2));//할부수수료 총액total


            }
        });

        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CompareResultTableActivity.class);

                intent.putExtra("ProductPrice1",Integer.parseInt(num1));
                intent.putExtra("Installmentmonth1", Integer.parseInt(num2));
                intent.putExtra("Total1", total1);
                intent.putExtra("rate1",Integer.parseInt(num4));

                intent.putExtra("ProductPrice2",Integer.parseInt(num5));
                intent.putExtra("Installmentmonth2", Integer.parseInt(num6));
                intent.putExtra("Total2", total2);
                intent.putExtra("rate2",Integer.parseInt(num8));

                startActivity(intent);
            }

        });



    }
}
