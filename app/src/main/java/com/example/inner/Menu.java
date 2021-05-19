package com.example.inner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    private ImageView back;
    private Button msg1;
    private Button msg2;
    private Button self1;
    private Button self2;
    private Button hospital1;
    private Button hospital2;
    private Button prevent1;
    private Button prevent2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        back = findViewById(R.id.back);
        msg1 = findViewById(R.id.msg1);
        msg2 = findViewById(R.id.msg2);
        hospital1 = findViewById(R.id.hospital1);
        hospital2 = findViewById(R.id.hospital2);
        prevent1 = findViewById(R.id.prevent1);
        prevent2 = findViewById(R.id.prevent2);
        self1 = findViewById(R.id.self1);
        self2 = findViewById(R.id.self2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        self1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Self.class);
                startActivity(intent);
            }
        });
        self2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Self.class);
                startActivity(intent);
            }
        });
        hospital1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hospital.class);
                startActivity(intent);
            }
        });
        hospital2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hospital.class);
                startActivity(intent);
            }
        });
        msg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Msg.class);
                startActivity(intent);
            }
        });
        msg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Msg.class);
                startActivity(intent);
            }
        });
        prevent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Prevent.class);
                startActivity(intent);
            }
        });
        prevent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Prevent.class);
                startActivity(intent);
            }
        });
    }
}
