package com.example.inner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Location extends AppCompatActivity {

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Location.this, MainActivity.class); //지금 액티비티에서 다른 액티비티로 이동하는 인텐트 설정
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    //인텐트 플래그 설정
        startActivity(intent);  //인텐트 이동
        finish();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        Button seoul = findViewById(R.id.seoul);
        Button jeju = findViewById(R.id.jeju);
        Button gyeongnam = findViewById(R.id.gyeongnam);
        Button gyeongbuk = findViewById(R.id.gyeongbuk);
        Button jeonnam = findViewById(R.id.jeonnam);
        Button jeonbuk = findViewById(R.id.jeonbuk);
        Button chungnam = findViewById(R.id.chungnam);
        Button chungbuk = findViewById(R.id.chungbuk);
        Button gangwon = findViewById(R.id.gangwon);
        Button sejong = findViewById(R.id.sejong);
        Button ulsan = findViewById(R.id.ulsan);
        Button daejon = findViewById(R.id.daejeon);
        Button gwangju = findViewById(R.id.gwangju);
        Button incheon = findViewById(R.id.incheon);
        Button daegu = findViewById(R.id.daegu);
        Button busan = findViewById(R.id.busan);
        Button gyeonggi = findViewById(R.id.gyeonggi);

        seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", seoul.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        jeju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", jeju.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        gyeongnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", gyeongnam.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        gyeongbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", gyeongbuk.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        jeonnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", jeonnam.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        jeonbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", jeonbuk.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        chungnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", chungnam.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        chungbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", chungbuk.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        gangwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", gangwon.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        sejong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", sejong.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        ulsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", ulsan.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        daejon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", daejon.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        gwangju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", gwangju.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        incheon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", incheon.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        daegu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", daegu.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        busan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", busan.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        gyeonggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name", gyeonggi.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
