package com.example.madassignmentphase2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExpenseActivity extends AppCompatActivity {

    EditText E_Name, E_SaturdayRate, E_SundayRate;
    Button add_new_expense;
    SharedPreferences e_sp;
    String E_NameStr, E_SaturdayRateStr, E_SundayRateStr;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        E_Name = findViewById(R.id.E_name);
        E_SaturdayRate = findViewById(R.id.editE_SR);
        E_SundayRate = findViewById(R.id.editE_SunR);
        add_new_expense = findViewById(R.id.add_new_expense);

        e_sp = getSharedPreferences("Expense", Context.MODE_PRIVATE);

        add_new_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                E_NameStr = E_Name.getText().toString();
                E_SaturdayRateStr = E_SaturdayRate.getText().toString();
                E_SundayRateStr = E_SundayRate.getText().toString();

                SharedPreferences.Editor e_editor = e_sp.edit();

                e_editor.putString("Name", E_NameStr);
                e_editor.putString("Saturday Rate", E_SaturdayRateStr);
                e_editor.putString("Sunday Rate", E_SundayRateStr);
                e_editor.commit();
                Toast.makeText(ExpenseActivity.this, "Information Saved", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = findViewById(R.id.to_pay);
        Button two = findViewById(R.id.gotomm);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInt = new Intent(getApplicationContext(), Add_New_Item.class);
                startActivity(myInt);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my2Int = new Intent(getApplicationContext(), Home_Page.class);
                startActivity(my2Int);
            }
        });
    }
}