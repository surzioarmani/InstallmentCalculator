package com.example.installmentcalculator;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompareResultTableActivity extends AppCompatActivity {

    int principlemoney1, rate1, total1, productprice1, installmentmonth1,
    principlemoney2, rate2, total2, productprice2, installmentmonth2;

    TextView t_month1, t_inst1, t_money1, t_fee1, t_month2, t_inst2, t_money2, t_fee2, diff1, diff2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipleinstallmentresult);


        LinearLayout table1 = findViewById(R.id.table);

        t_month1 = findViewById(R.id.totalmonth1);
        t_inst1 = findViewById(R.id.total_inst_M1);
        t_money1 = findViewById(R.id.total_M1);
        t_fee1 = findViewById(R.id.total_feem1);
        t_month2 =findViewById(R.id.totalmonth2);
        t_inst2 = findViewById(R.id.total_inst_M2);
        t_money2 =findViewById(R.id.total_M2);
        t_fee2 = findViewById(R.id.total_feem2);
        diff1 = findViewById(R.id.diff1);
        diff2 = findViewById(R.id.diff2);


        productprice1 = getIntent().getIntExtra("ProductPrice1", 0);
        installmentmonth1 = getIntent().getIntExtra("Installmentmonth1", 0);
        total1 = getIntent().getIntExtra("Total1", 0);
        rate1 = getIntent().getIntExtra("rate1",0);

        productprice2 = getIntent().getIntExtra("ProductPrice2", 0);
        installmentmonth2 = getIntent().getIntExtra("Installmentmonth2", 0);
        total2 = getIntent().getIntExtra("Total2", 0);
        rate2 = getIntent().getIntExtra("rate2",0);



        principlemoney1 = productprice1 / installmentmonth1;// 원래 금액 할부
        principlemoney2 = productprice2 / installmentmonth2;// 원래 금액 할부


        t_month1.setText("총"+installmentmonth1+"차");
        t_inst1.setText((total1+productprice1)+"원");
        t_money1.setText((productprice1)+"원");
        t_fee1.setText((total1)+"원");
        t_month2.setText("총"+(installmentmonth2)+"차");
        t_inst2.setText((total2+productprice2)+"원");
        t_money2.setText((productprice2)+"원");
        t_fee2.setText((total2)+"원");

        if((total2+productprice2)-(total1+productprice1)>0){
            diff2.setText(((total2+productprice2)-(total1+productprice1))+"원");
            diff1.setText(((total1+productprice1)-(total2+productprice2))+"원");

        }
        else {
            diff2.setText(((total2 + productprice2) - (total1 + productprice1)) + "원");
            diff1.setText(((total1 + productprice1) - (total2 + productprice2)) + "원");
        }





    }


}

