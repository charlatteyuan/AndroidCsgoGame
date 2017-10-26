package com.missiondevs.csgohandbook;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.net.*;
import java.io.*;
import java.util.*;



public class ActualContentActivity extends AppCompatActivity{
    public static ArrayList<String> nextLink;
    public static ArrayList<String> buttonNames;
    public static String map;
    public static String function;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.content_selection);
        map = bundle.getString("map");
        function = bundle.getString("function");
        URL mapFunc = null;
        StringBuilder a = new StringBuilder();
        try {
            if (map.equals("dust2") && function.equals("smoke")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcZTljYnFxQVBQNXM");
            }
            else if (map.equals("dust2") && function.equals("flashMolly")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcX2lCT1dkdjlOU1U");
            }
            else if (map.equals("cache") && function.equals("smoke")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcT2NGM2QxYUhTUFE");
            }
            else if (map.equals("cache") && function.equals("flashMolly")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcSGRRWkJkUnFDWUU");
            }
            else if (map.equals("mirage") && function.equals("smoke")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcTXVJS0lnSGV3TGM");
            }
            else if (map.equals("mirage") && function.equals("flashMolly")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcZFg5VXdKNnNLZGM");
            }
            else if (map.equals("cobblestone") && function.equals("smoke")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcd2pyejdENVN5aG8");
            }
            else if (map.equals("cobblestone") && function.equals("flashMolly")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcTFRjQ29vdlJTaWc");
            }
            else if (map.equals("inferno") && function.equals("smoke")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcRXNwUURGVzFzcW8");
            }
            else if (map.equals("inferno") && function.equals("flashMolly")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcOUhGZnhSTWlWTHM");
            }
            else if (map.equals("nuke") && function.equals("smoke")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcbHV3X2t5Yk1MYnc");
            }
            else if (map.equals("nuke") && function.equals("flashMolly")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcWkhLRFJLdmdfSVk");
            }
            else if (map.equals("overpass") && function.equals("smoke")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcYWJfcnpwTFRNUTg");
            }
            else if (map.equals("overpass") && function.equals("flashMolly")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcMGhaM0k3enBMWUk");
            }
            else if (map.equals("train") && function.equals("smoke")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcdVo2X2Y1c1oyUFk");
            }
            else if (map.equals("train") && function.equals("flashMolly")) {
                mapFunc = new URL("https://drive.google.com/drive/folders/0B57YPbBS7dRcT2hOQmlRNzN6d28");
            }
            URLConnection urlConn = mapFunc.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlConn.getInputStream(), "UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                a.append(inputLine);
            in.close();

        }
        catch (Exception e){
            //error report?
        }
        String findStr = "x22application";
        int lastIndex = 0, count = 0, x22SecondOccurr = 0, c = 3;
        while(lastIndex != -1){
            int counter = 0;
            c = 3;
            lastIndex = a.indexOf(findStr,lastIndex);
            if(lastIndex != -1){
                count++;
                x22SecondOccurr = lastIndex - 6;
                while(counter < 1){
                    if (a.substring(x22SecondOccurr - c,x22SecondOccurr - c + 4).equals("\\x22")){
                        counter++;
                    }
                    c++;
                }
                buttonNames.add(a.substring(x22SecondOccurr-c+5,x22SecondOccurr));
                nextLink.add(a.substring(x22SecondOccurr-c-79,x22SecondOccurr-c-51));
                lastIndex += findStr.length();
            }
        }
        Button[] buttons = new Button[count];
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        LinearLayout layout = (LinearLayout) findViewById(R.id.content_linear);
        for (int i = 0; i < count; i++){
            buttons[i] = new Button(this);
            buttons[i].setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            buttons[i].setMinHeight(height/5);
            buttons[i].setText(buttonNames.get(i));
            layout.addView(buttons[i]);
        }
        for (int i = 0; i < count; i++){
            final int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent intent = new Intent("com.example.package_path.ActualContentActivity");
                    Bundle bundle = new Bundle();
                    bundle.putString("map",map);
                    bundle.putString("name",buttonNames.get(finalI));
                    bundle.putString("link",nextLink.get(finalI));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
    }
}
