package com.missiondevs.csgohandbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Button dust2Button = (Button) findViewById(R.id.dust2);
        Button cacheButton = (Button) findViewById(R.id.cache);
        Button mirageButton = (Button) findViewById(R.id.mirage);
        Button infernoButton = (Button) findViewById(R.id.inferno);
        Button cobblestoneButton = (Button) findViewById(R.id.cobblestone);
        Button overpassButton = (Button) findViewById(R.id.overpass);
        Button trainButton = (Button) findViewById(R.id.train);
        Button nukeButton = (Button) findViewById(R.id.nuke);
        dust2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.package_path.FunctionActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map", "dust2");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        cacheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.package_path.FunctionActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map", "cache");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mirageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.package_path.FunctionActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map", "mirage");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        infernoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.package_path.FunctionActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map", "inferno");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        cobblestoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.package_path.FunctionActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map", "cobblestone");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        overpassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.package_path.FunctionActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map", "overpass");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.package_path.FunctionActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map", "train");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        nukeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.package_path.FunctionActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map", "nuke");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}

