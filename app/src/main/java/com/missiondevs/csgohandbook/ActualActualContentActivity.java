package com.missiondevs.csgohandbook;

/**
 * Created by adam2 on 8/1/2017.
 */
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.*;
import java.net.*;
import java.io.*;

import static com.missiondevs.csgohandbook.R.id.content_linear;

public class ActualActualContentActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.actual_content);
        String link = bundle.getString("link");
        String map = bundle.getString("map");
        String name = bundle.getString("name");
        StringBuilder a = new StringBuilder();
        try{
            URL throwFolder = new URL("https://drive.google.com/drive/u/2/folders/"+link);
            URL throwType = null;
            if (map.equals("dust2")){
                throwType = new URL("https://docs.google.com/document/d/1tv_wHNrwvwcPyrtlWBGRxpL6wKekvMTHWvi4JtZwo78");
            }
            else if (map.equals("cache")){
                throwType = new URL("https://docs.google.com/document/d/1jLX0L_ADZq-uEODRmGhQ8TFl3utF9QkkaHgd2DC0kMo");
            }
            else if (map.equals("overpass")){
                throwType = new URL("https://docs.google.com/document/d/1Ry5hx4yJ5trQ56HUGKuBrDqFXdMaHeFxtL2ir1LUCkQ");
            }
            else if (map.equals("nuke")){
                throwType = new URL("https://docs.google.com/document/d/1WXBZrtx-b0Jah0MTvMQ1JZ3YuWQZalg3zfCzBPebeic");
            }
            else if (map.equals("train")){
                throwType = new URL("https://docs.google.com/document/d/1_hT0Ue2vMn_mgWugSKZDZNcdclcy36rE95LbNmx_pRw");
            }
            else if (map.equals("inferno")){
                throwType = new URL("https://docs.google.com/document/d/1cw6A-m3J6Lf1K6zBKxSxlIYNYRpQJab6-vr6wTU45AM");
            }
            else if (map.equals("mirage")){
                throwType = new URL("https://docs.google.com/document/d/1bOGbsxTEnfqEIoAvHL9TIK2-Of6Ci-qZhh1V33fuvPA");
            }
            else if (map.equals("cobblestone")){
                throwType = new URL("https://docs.google.com/document/d/1GWutRQ8XhD6GZjxw9-FpksKboODD8FJCLl-zxMdsEAY");
            }
            URLConnection urlConn = throwType.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlConn.getInputStream(), "UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                a.append(inputLine);
            in.close();
            int indexOfThrow = a.indexOf(name);
            int indexOfColon = a.indexOf(":",indexOfThrow);
            int indexOfAST = a.indexOf("***",indexOfThrow);
            String throwIt = a.substring(indexOfColon+2,indexOfAST);

            a.setLength(0);

            URLConnection urlConn2 = throwFolder.openConnection();
            BufferedReader in2 = new BufferedReader(new InputStreamReader(
                    urlConn2.getInputStream(), "UTF-8"));
            inputLine = "";
            while ((inputLine = in2.readLine()) != null)
                a.append(inputLine);
            in2.close();


            ArrayList<Pic> pics = new ArrayList<>();
            String findStr = "x22image";
            String nameTemp;
            String linkTemp;
            int lastIndex = 0, count = 0, x22SecondOccurr, c;
            while(lastIndex != -1){
                c = 10;
                x22SecondOccurr = 0;
                lastIndex = a.indexOf(findStr,lastIndex);
                if(lastIndex != -1){
                    count++;
                    while(x22SecondOccurr == 0){
                        if (a.substring(lastIndex - c,lastIndex - c + 4).equals("\\x22")){
                            x22SecondOccurr = lastIndex-c;
                        }
                        c++;
                    }
                    nameTemp = (a.substring(x22SecondOccurr+4,lastIndex-10));
                    linkTemp = "https://drive.google.com/file/d/" + a.substring(x22SecondOccurr-80,x22SecondOccurr-52) + "/view";
                    pics.add(new Pic(linkTemp,nameTemp));
                    lastIndex += findStr.length();
                }
            }
            Collections.sort(pics);
            ImageView[] images = new ImageView[count];
            LinearLayout layout = (LinearLayout) findViewById(R.id.content_show);
            TextView text = new TextView(this);
            text.setText(throwIt);
            layout.addView(text);
            for (int i = 0; i < count; i++){
                images[i] = new ImageView(this);
                images[i].setImageDrawable(LoadImageFromWebOperations(pics.get(i).getLink()));
                layout.addView(images[i]);
            }
        }
        catch (Exception e){
            //ERROR REPORT HERE
        }



    }
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
    class Pic implements Comparable<Pic>{
        private String link;
        private String name;
        public Pic(String link, String name){
            this.link = link;
            this.name = name;
        }
        public String getLink(){
            return link;
        }
        public String getName(){
            return name;
        }
        public int compareTo(Pic pic){
            return this.name.compareTo(pic.getName());
        }
    }
}
