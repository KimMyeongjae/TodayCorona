package com.example.inner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {




    private String newsUrl = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=코로나";
    private String innerUrl ="";
    private String locationUrl = "";

    private TextView text;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView loc;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private ListView newsView;
    private ImageView menuTab;


    private String newsData = "";
    private String decideData = "";
    private String decideData2 = "";
    private String clearData = "";
    private String clearData2 = "";
    private String deathData = "";
    private String deathData2 = "";
    private String loData = "";

    private Integer nowDay ;
    private Integer yesDay ;

    private String loDeciedRes;
    private String loIncreasedRes;
    private String loClearRes;
    private String loDeathRes;
    private String deciedRes;
    private String clearRes;
    private String deathRes;

    private ArrayList<String> loDecide;
    private ArrayList<String> loIncrease;
    private ArrayList<String> loDeath;
    private ArrayList<String> loClear;
    private ArrayList<String> newsArray;

    private Context mContext;
    private NewsAdapater nAdapter;
    private long backTime= 0;

    @Override

    public void onBackPressed(){

        if(System.currentTimeMillis() - backTime >= 2000){
            backTime=System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),"한번더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }

        else if(System.currentTimeMillis() - backTime < 2000 ){
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext = getApplicationContext();

        Button lobtn = findViewById(R.id.loBtn);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.lDecide);
        txt5 = (TextView) findViewById(R.id.lClear);
        txt6 = (TextView) findViewById(R.id.lDeath);
        loc = (TextView) findViewById(R.id.loc);
        newsView = (ListView) findViewById(R.id.newsList);
        menuTab = findViewById(R.id.menuTab);



        menuTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
            }
        });


        lobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Location.class);
                startActivityForResult(intent, 101);
            }
        });
        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                loc.setText(name);
            }
        }
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
            Date nowDate = new Date();
            SimpleDateFormat Date = new SimpleDateFormat("yyyyMMdd");
            Calendar c1 = Calendar.getInstance();
            c1.add(Calendar.DATE,-1);
            nowDay = Integer.parseInt(Date.format(nowDate));
            yesDay = Integer.parseInt(Date.format(c1.getTime()));

            innerUrl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=rt3ZWGfDs0X0oQdxVXA0VZSKEDsug5L5SFkddQWfQFdijH2mus%2FmhoCSE1LSdQpv2WwDhF4xZ4iwzQd%2B1qje3g%3D%3D&pageNo=1&numOfRows=10&startCreateDt="
            + yesDay + "&endCreateDt=" + nowDay;
            locationUrl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=rt3ZWGfDs0X0oQdxVXA0VZSKEDsug5L5SFkddQWfQFdijH2mus%2FmhoCSE1LSdQpv2WwDhF4xZ4iwzQd%2B1qje3g%3D%3D&pageNo=1&numOfRows=10&startCreateDt="
            + yesDay + "&endCreateDt=" + nowDay;

            loDecide = new ArrayList<>();
            loIncrease = new ArrayList<>();
            loDeath = new ArrayList<>();
            loClear = new ArrayList<>();
            newsArray = new ArrayList<>();
            try {
                Document newsd = Jsoup.connect(newsUrl).get();
                Document innerd = Jsoup.connect(innerUrl).get();
                Document locationed = Jsoup.connect(locationUrl).get();
                Elements news = newsd.select("a[title]");
                Element decide = innerd.select("decideCnt").first();
                Element decide2 = innerd.select("decideCnt").last();
                Element clear = innerd.select("clearCnt").first();
                Element clear2 = innerd.select("clearCnt").last();
                Element death = innerd.select("deathCnt").first();
                Element death2 = innerd.select("deathCnt").last();
                Elements location = locationed.select("gubun");
                Elements loDecided = locationed.select("defCnt");
                Elements loIncreased = locationed.select("incDec");
                Elements loDeathed = locationed.select("deathCnt");
                Elements loCleared = locationed.select("isolClearCnt");

                for (Element link : news) {
                    newsArray.add(link.text());
                }
                for (Element de : loDecided){
                    loDecide.add(de.text());
                }
                for (Element inc : loIncreased){
                    loIncrease.add(inc.text());
                }
                for (Element dth : loDeathed){
                    loDeath.add(dth.text());
                }
                for(Element clr : loCleared){
                    loClear.add(clr.text());
                }


                loData = loc.getText().toString();
                        switch (loData) {
                            case "제주":
                                loDeciedRes = loDecide.get(1);
                                loIncreasedRes = loIncrease.get(1);
                                loDeathRes = loDeath.get(1);
                                loClearRes = loClear.get(1);
                                break;
                            case "경남":
                                loDeciedRes = loDecide.get(2);
                                loIncreasedRes = loIncrease.get(2);
                                loDeathRes = loDeath.get(2);
                                loClearRes = loClear.get(2);
                                break;
                            case "경북":
                                loDeciedRes = loDecide.get(3);
                                loIncreasedRes = loIncrease.get(3);
                                loDeathRes = loDeath.get(3);
                                loClearRes = loClear.get(3);
                                break;
                            case "전남":
                                loDeciedRes = loDecide.get(4);
                                loIncreasedRes = loIncrease.get(4);
                                loDeathRes = loDeath.get(4);
                                loClearRes = loClear.get(4);
                                break;
                            case "전북":
                                loDeciedRes = loDecide.get(5);
                                loIncreasedRes = loIncrease.get(5);
                                loDeathRes = loDeath.get(5);
                                loClearRes = loClear.get(5);
                                break;
                            case "충남":
                                loDeciedRes = loDecide.get(6);
                                loIncreasedRes = loIncrease.get(6);
                                loDeathRes = loDeath.get(6);
                                loClearRes = loClear.get(6);
                                break;
                            case "충북":
                                loDeciedRes = loDecide.get(7);
                                loIncreasedRes = loIncrease.get(7);
                                loDeathRes = loDeath.get(7);
                                loClearRes = loClear.get(7);
                                break;
                            case "강원":
                                loDeciedRes = loDecide.get(8);
                                loIncreasedRes = loIncrease.get(8);
                                loDeathRes = loDeath.get(8);
                                loClearRes = loClear.get(8);
                                break;
                            case "경기":
                                loDeciedRes = loDecide.get(9);
                                loIncreasedRes = loIncrease.get(9);
                                loDeathRes = loDeath.get(9);
                                loClearRes = loClear.get(9);
                                break;
                            case "세종":
                                loDeciedRes = loDecide.get(10);
                                loIncreasedRes = loIncrease.get(10);
                                loDeathRes = loDeath.get(10);
                                loClearRes = loClear.get(10);
                                break;
                            case "울산":
                                loDeciedRes = loDecide.get(11);
                                loIncreasedRes = loIncrease.get(11);
                                loDeathRes = loDeath.get(11);
                                loClearRes = loClear.get(11);
                                break;
                            case "대전":
                                loDeciedRes = loDecide.get(12);
                                loIncreasedRes = loIncrease.get(12);
                                loDeathRes = loDeath.get(12);
                                loClearRes = loClear.get(12);
                                break;
                            case "광주":
                                loDeciedRes = loDecide.get(13);
                                loIncreasedRes = loIncrease.get(13);
                                loDeathRes = loDeath.get(13);
                                loClearRes = loClear.get(13);
                                break;
                            case "인천":
                                loDeciedRes = loDecide.get(14);
                                loIncreasedRes = loIncrease.get(14);
                                loDeathRes = loDeath.get(14);
                                loClearRes = loClear.get(14);
                                break;
                            case "대구":
                                loDeciedRes = loDecide.get(15);
                                loIncreasedRes = loIncrease.get(15);
                                loDeathRes = loDeath.get(15);
                                loClearRes = loClear.get(15);
                                break;
                            case "부산":
                                loDeciedRes = loDecide.get(16);
                                loIncreasedRes = loIncrease.get(16);
                                loDeathRes = loDeath.get(16);
                                loClearRes = loClear.get(16);
                                break;
                            case "서울":
                                loDeciedRes = loDecide.get(17);
                                loIncreasedRes = loIncrease.get(17);
                                loDeathRes = loDeath.get(17);
                                loClearRes = loClear.get(17);
                                break;
                        }



                decideData = decide.text();
                decideData2 = decide2.text();
                deciedRes = String.valueOf(Integer.parseInt(decideData) - Integer.parseInt(decideData2));
                
                clearData = clear.text();
                clearData2 = clear2.text();
                clearRes = String.valueOf(Integer.parseInt(clearData) - Integer.parseInt(clearData2));

                deathData = death.text();
                deathData2 = death2.text();
                deathRes = String.valueOf(Integer.parseInt(deathData) - Integer.parseInt(deathData2));

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            nAdapter = new NewsAdapater(mContext, newsArray);
            newsView.setAdapter(nAdapter);
            txt1.setText("확진자 \n" + decideData + "명\n(" + deciedRes +"명)");
            txt2.setText("격리해제 \n" +clearData + "명\n(" + clearRes + "명)");
            txt3.setText("사망자 \n" +deathData + "명\n(" + deathRes + "명)");
            txt4.setText("신규 확진자 \n" + loIncreasedRes + "명\n(총"+loDeciedRes+"명)");
            txt5.setText("격리해제\n" + loClearRes + "명");
            txt6.setText("사망자\n" + loDeathRes + "명");
        }
    }
}