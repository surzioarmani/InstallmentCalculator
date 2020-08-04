package com.example.installmentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class SingleinstallmentActivity extends AppCompatActivity {

    EditText ProductPrice, Installmentmonth, InterestRate;
    Button Check, Result;
    TextView Total;

    String num1, num2,  num4;
    int total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinstallment);

        ProductPrice = findViewById(R.id.product_price);
        Installmentmonth =  findViewById(R.id.installment_month);
        InterestRate = findViewById(R.id.interest_rate);
        Check = findViewById(R.id.check);
        Result = findViewById(R.id.result_button);
        Total =  findViewById(R.id.total_price);




        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = ProductPrice.getText().toString();//제품가격num1
                num2 = Installmentmonth.getText().toString();//할부개월num2
                num4 = InterestRate.getText().toString();//수수료율num4


                int principlemoney = Integer.parseInt(num1) / Integer.parseInt(num2) ;

                for(int j=0;j<Integer.parseInt(num2);j++) {
                    total += (Integer.parseInt(num1) -(principlemoney*j))*Integer.parseInt(num4)/1200;

                }

//                total =Integer.parseInt(num1)*(Integer.parseInt(num2) - Integer.parseInt(num3) +1)*Integer.parseInt(num4) /24;

//                total = (Integer.parseInt(num1)*(Integer.parseInt(num2)+1)*Integer.parseInt(num4)/2)/1200;
                Total.setText(String.valueOf(total));//할부수수료 총액total


            }
        });


        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ResultTableActivity.class);

                intent.putExtra("ProductPrice",Integer.parseInt(num1));
                intent.putExtra("Installmentmonth", Integer.parseInt(num2));
                intent.putExtra("Total", total);
                intent.putExtra("rate",Integer.parseInt(num4));

                startActivity(intent);
            }

        });


    }






    }
