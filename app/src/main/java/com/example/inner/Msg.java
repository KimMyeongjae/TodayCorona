package com.example.inner;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Msg extends AppCompatActivity {
    private String Url = "http://apis.data.go.kr/1741000/DisasterMsg3/getDisasterMsg1List?serviceKey=rt3ZWGfDs0X0oQdxVXA0VZSKEDsug5L5SFkddQWfQFdijH2mus%2FmhoCSE1LSdQpv2WwDhF4xZ4iwzQd%2B1qje3g%3D%3D&pageNo=1&numOfRows=30&type=xml";
    private TextView text;
    private String data = "";
    private ListView msgView;
    private ArrayList<String> msgArray;
    private ImageView backMenu;

    private Context mContext;
    private MsgAdapter mAdapter;
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Msg.this, Menu.class); //지금 액티비티에서 다른 액티비티로 이동하는 인텐트 설정
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    //인텐트 플래그 설정
        startActivity(intent);  //인텐트 이동
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msglist);
        backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
            }
        });
        this.mContext = getApplicationContext();

        msgView = (ListView) findViewById(R.id.msgList);
        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            msgArray = new ArrayList<>();
            try {

                Document doc = Jsoup.connect(Url).get();
                Elements links = doc.select("msg");
                for (Element link : links) {
                    msgArray.add(link.text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mAdapter = new MsgAdapter(mContext, msgArray);
            msgView.setAdapter(mAdapter);
        }
    }
}
