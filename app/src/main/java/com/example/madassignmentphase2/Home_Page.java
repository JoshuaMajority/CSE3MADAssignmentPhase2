package com.example.madassignmentphase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button btn = findViewById(R.id.addin);
        Button two = findViewById(R.id.sett);
        Button three = findViewById(R.id.tomainmenu);
        Button four = findViewById(R.id.toshare);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInt = new Intent(getApplicationContext(), Add_Invoice.class);
                startActivity(myInt);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my2Int = new Intent(getApplicationContext(), Settings_Page.class);
                startActivity(my2Int);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my3Int = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(my3Int);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my4Int = new Intent(getApplicationContext(), Share_Page.class);
                startActivity(my4Int);
            }
        });
    }
}