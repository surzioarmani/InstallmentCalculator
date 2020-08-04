package com.example.installmentcalculator;


import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class ResultTableActivity extends AppCompatActivity {


//    ScrollView sv;

    int principlemoney, rate, monthlypay, leftmoney, fee, total, productprice, installmentmonth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinstallmentresult);



        LinearLayout table1 = findViewById(R.id.table);

        TextView[] leftM = new TextView[12];
        TextView[] feeM = new TextView[12];
        TextView[] originM = new TextView[12];
        TextView[] monthM = new TextView[12];
        TextView[] month = new TextView[12];
        
        
/// TODO: 2020-08-04  이름과 동일하지 않지만 순서상 바꿔두었으므로 건들지 말기 
        Integer[] monthMID = {R.id.leftM1, R.id.leftM2, R.id.leftM3, R.id.leftM4, R.id.leftM5, R.id.leftM6, R.id.leftM7, R.id.leftM8, R.id.leftM9, R.id.leftM10, R.id.leftM11, R.id.leftM12};
        Integer[] originMID = {R.id.feeM1, R.id.feeM2, R.id.feeM3, R.id.feeM4, R.id.feeM5, R.id.feeM6, R.id.feeM7, R.id.feeM8, R.id.feeM9, R.id.feeM10, R.id.feeM11, R.id.feeM12};
        Integer[] feeMID = {R.id.originM1, R.id.originM2, R.id.originM3, R.id.originM4, R.id.originM5, R.id.originM6, R.id.originM7, R.id.originM8, R.id.originM9, R.id.originM10, R.id.originM11, R.id.originM12};
        Integer[] leftMID = {R.id.monthM1, R.id.monthM2, R.id.monthM3, R.id.monthM4, R.id.monthM5, R.id.monthM6, R.id.monthM7, R.id.monthM8, R.id.monthM9, R.id.monthM10, R.id.monthM11, R.id.monthM12};


        productprice = getIntent().getIntExtra("ProductPrice", 0);
        installmentmonth = getIntent().getIntExtra("Installmentmonth", 0);
        total = getIntent().getIntExtra("Total", 0);
        rate = getIntent().getIntExtra("rate",0);



        for (int i = 0; i < 12; i++) {
            leftM[i] = (TextView) findViewById(leftMID[i]);
            feeM[i] = (TextView) findViewById(feeMID[i]);
            originM[i] = (TextView) findViewById(originMID[i]);
            monthM[i] = (TextView) findViewById(monthMID[i]);

        }

//        monthlypay = productprice / installmentmonth;//월별
        //fee = total / installmentmonth; //월 할부이자

        principlemoney = productprice / installmentmonth;// 원래 금액 할부



            for (int i = 0; i < installmentmonth; i++) {

                fee = (productprice -(principlemoney*(i)))*rate/1200;
                feeM[i].setText((fee)+"원");
                monthlypay = principlemoney + fee;
                monthM[i].setText((monthlypay)+"원");//총월납부액

                leftmoney = productprice - (principlemoney*(i+1)) ;//남은 금액

                leftM[i].setText(productprice-(principlemoney*(i+1))+"원");//할부원금잔액
                originM[i].setText((principlemoney)+"원");//할부원금상환액


            }

        }
    }
