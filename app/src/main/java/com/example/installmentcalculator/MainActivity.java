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
        Button card = (Button) findViewById(R.id.cardInfo);

        final Button install = (Button) findViewById(R.id.installment_button);

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
                showhow();
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                showcard();
            }
        });
    }


    void showhow(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("할부계산기 이용법").setMessage("반갑습니다. 단국대학교 모바일시스템공학과 조수아입니다.\n원하시는 계산기를 선택 후 사용하시면 됩니다.\n2개이상의 할부 제품을 비교하고 싶으시다면\n할부계산기를 선택하시고 2개버튼을 클릭하세요\n할부계산기의 결과화면은 곧 업데이트될 예정입니다.");

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

    void showcard(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("카드할부정보").setMessage("카드 할부 정보는 이미지를 만든 후 추후 업데이트될 예정입니다.\n감사합니다.");


        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

}


