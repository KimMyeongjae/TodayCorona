package com.example.inner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    private ImageView back;
    private Button msg1;
    private Button self1;
    private Button hospital1;
    private Button prevent1;
    private Button prevent2;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Menu.this, MainActivity.class); //지금 액티비티에서 다른 액티비티로 이동하는 인텐트 설정
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    //인텐트 플래그 설정
        startActivity(intent);  //인텐트 이동
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        back = findViewById(R.id.back);
        msg1 = findViewById(R.id.msg1);
        hospital1 = findViewById(R.id.hospital1);
        prevent1 = findViewById(R.id.prevent1);
        self1 = findViewById(R.id.self1);
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

        hospital1.setOnClickListener(new View.OnClickListener() {
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

        prevent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Prevent.class);
                startActivity(intent);
            }
        });

    }
}
