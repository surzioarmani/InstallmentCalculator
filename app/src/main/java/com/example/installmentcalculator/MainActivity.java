package com.example.installmentcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.w3c.dom.Text;
import android.view.View.OnClickListener;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ACTIVITY", "oncreate 호출");
        Toast.makeText(getApplicationContext(), "onCreate 호출", Toast.LENGTH_SHORT).show();


        Button how = (Button) findViewById((R.id.how_button));
        Button cal = (Button) findViewById(R.id.calculator_button);
        final Button install = (Button) findViewById(R.id.installment_button);

       //   how.setOnClickListener(this);
//        cal.setOnClickListener(this);
//        install.setOnClickListener(this);

         cal.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), subactivity.class);
                 startActivity(intent);
             }
         });

        install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstallmenuActivity.class);
                startActivity(intent);
            }
        });

        how.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    void show(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("할부계산기 이용법").setMessage("반갑습니다. 단국대학교 모바일시스템공학과 조수아입니다.\n원하시는 계산기를 사용해주세요.\n2개이상의 할부 제품을 비교하고 싶으시다면\n할부계산기를 선택하시고 2개버튼을 클릭하세요");

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

}


