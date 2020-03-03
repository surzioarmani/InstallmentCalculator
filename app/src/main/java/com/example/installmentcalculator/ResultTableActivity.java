package com.example.installmentcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ResultTableActivity extends AppCompatActivity {

    private ScrollView scrollView;
    int principlemoney, monthlypay, leftmoney, fee, total, productprice, installmentmonth, freemonth, interestrate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinstallmentresult);
        scrollView = findViewById(R.id.scrollView);
        scrollView.setVerticalScrollBarEnabled(true);

        Intent intent = getIntent();
        TextView NumberMonth = (TextView) findViewById(R.id.numbermonth);
        TextView LeftMoney = (TextView) findViewById(R.id.leftmoney);
        TextView Fee = (TextView) findViewById(R.id.fee);
        TextView PrincipleMoney = (TextView) findViewById(R.id.principlemoney);
        TextView MonthlyPay = (TextView) findViewById(R.id.monthlypay);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);


        scrollView.setHorizontalScrollBarEnabled(true);

        Option option = (Option) intent.getSerializableExtra("class");
        productprice = option.getProductprice();
        installmentmonth = option.getInstallmentmonth();
        freemonth = option.getFreemonth();
        interestrate = option.getInterestRate();
        total = option.getTotal();


        for (int i = 0; i < installmentmonth; i++) {
            NumberMonth.setText(String.valueOf(i));
            principlemoney = productprice / installmentmonth;
            monthlypay = (productprice + total) / installmentmonth;
            leftmoney = (principlemoney + total) - monthlypay;
            fee = total / installmentmonth;

            PrincipleMoney.setText(principlemoney);//무이자할부개념으로 나눈 월마다 내야하는 금액, 아니면 나눈거 지우기
            MonthlyPay.setText(monthlypay);
            LeftMoney.setText(leftmoney);
            Fee.setText(fee);
            NumberMonth.setText(installmentmonth);


        }


    }
}