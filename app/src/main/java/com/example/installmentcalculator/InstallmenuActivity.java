package com.example.installmentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InstallmenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installmentmenu);
        Log.d("ACTIVITY", "oncreate 호출");
        Toast.makeText(getApplicationContext(), "onCreate 호출", Toast.LENGTH_SHORT).show();


        Button single = (Button) findViewById((R.id.single_button));
        Button compare = (Button) findViewById(R.id.compare_button);


        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SingleinstallmentActivity.class);
                startActivity(intent);
            }
        });
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CompareinstallmentActivity.class);
                startActivity(intent);
            }
        });

    }

}


