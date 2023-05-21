package com.example.madassignmentphase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_New_Item extends AppCompatActivity {

    EditText N_Name, N_ABN, N_Weekday_Rate, N_Saturday_Rate, N_Sunday_Rate;
    Button add_new_item;
    SharedPreferences n_sp;
    String N_NameStr, N_ABNStr, N_Weekday_RateStr, N_Sat_RateStr, N_Sunday_RateStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);

        N_Name = findViewById(R.id.editNewName);
        N_ABN = findViewById(R.id.editNewABN);
        N_Weekday_Rate = findViewById(R.id.editWeekdayRate);
        N_Saturday_Rate = findViewById(R.id.editTextTextSaturdayRate);
        N_Sunday_Rate = findViewById(R.id.editTextTextSundayRate);
        add_new_item = findViewById(R.id.addnewi);

        n_sp = getSharedPreferences("New Item", Context.MODE_PRIVATE);

        add_new_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            N_NameStr = N_Name.getText().toString();
            N_ABNStr = N_ABN.getText().toString();
            N_Weekday_RateStr = N_Weekday_Rate.getText().toString();
            N_Sat_RateStr = N_Saturday_Rate.getText().toString();
            N_Sunday_RateStr = N_Sunday_Rate.getText().toString();

            SharedPreferences.Editor n_editor = n_sp.edit();

            n_editor.putString("Name", N_NameStr);
            n_editor.putString("ABN", N_ABNStr);
            n_editor.putString("Weekday Rate", N_Weekday_RateStr);
            n_editor.putString("Saturday Rate", N_Sat_RateStr);
            n_editor.putString("Sunday Rate", N_Sunday_RateStr);
            n_editor.commit();
            Toast.makeText(Add_New_Item.this, "Information Saved", Toast.LENGTH_SHORT).show();
            }
        });


        Button btn = findViewById(R.id.close);
        Button two = findViewById(R.id.to_exp);

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
                Intent my2Int = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(my2Int);
            }
        });
    }
}