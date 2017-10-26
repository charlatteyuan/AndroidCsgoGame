package com.missiondevs.csgohandbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by adam2 on 7/18/2017.
 */

public class FunctionActivity extends AppCompatActivity{
    public static String map = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        map = bundle.getString("map");
        setTitle("CSGO Handbook " + map);
        setContentView(R.layout.function_activity);


        Button smokeButton = (Button)findViewById(R.id.smoke);
        Button flash_mollyButton = (Button)findViewById(R.id.flash_molly);
        Button IGLButton = (Button)findViewById(R.id.igl);
        Button sprayButton = (Button)findViewById(R.id.spray);


        smokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent("com.example.package_path.ActualContentActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map",map);
                bundle.putString("function","smoke");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        flash_mollyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent("com.example.package_path.ActualContentActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map",map);
                bundle.putString("function","flashMolly");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        IGLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent("com.example.package_path.IGLActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map",map);
                bundle.putString("function","igl");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        sprayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent("com.example.package_path.sprayActivity");
                Bundle bundle = new Bundle();
                bundle.putString("map",map);
                bundle.putString("function","igl");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
