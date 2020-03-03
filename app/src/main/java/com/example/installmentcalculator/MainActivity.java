package com.example.installmentcalculator;

import androidx.appcompat.app.AppCompatActivity;

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

//        how.setOnClickListener(this);
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

    }

}

