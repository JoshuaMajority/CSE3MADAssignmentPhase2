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
import android.widget.RadioButton;
import android.widget.Toast;

public class ExpenseActivity extends AppCompatActivity {

    EditText E_Name, E_PayRate;
    Button add_new_expense;
    SharedPreferences e_sp;
    String E_NameStr, E_PayRateStr;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        RadioButton weeklyRB = findViewById(R.id.weekb);
        RadioButton monthlyRB = findViewById(R.id.monthb);
        RadioButton sixmonthlyRB = findViewById(R.id.sixmonthb);

        E_Name = findViewById(R.id.E_name);
        E_PayRate = findViewById(R.id.editE_PR);
        add_new_expense = findViewById(R.id.add_new_expense);

        e_sp = getSharedPreferences("Expense", Context.MODE_PRIVATE);

        weeklyRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String intervalStr = "weekly";
                SharedPreferences.Editor e_editor = getSharedPreferences("Invoice", Context.MODE_PRIVATE).edit();
                e_editor.putString("Weekly", intervalStr);
                e_editor.apply();
            }
        });

        monthlyRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String intervalStr = "monthly";
                SharedPreferences.Editor e_editor = getSharedPreferences("Expense", Context.MODE_PRIVATE).edit();
                e_editor.putString("Monthly", intervalStr);
                e_editor.apply();
            }
        });

        sixmonthlyRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String intervalStr = "6 monthly";
                SharedPreferences.Editor e_editor = getSharedPreferences("Expense", Context.MODE_PRIVATE).edit();
                e_editor.putString("6 Monthly", intervalStr);
                e_editor.apply();
            }
        });

        add_new_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                E_NameStr = E_Name.getText().toString();
                E_PayRateStr = E_PayRate.getText().toString();

                SharedPreferences.Editor e_editor = e_sp.edit();

                e_editor.putString("Name", E_NameStr);
                e_editor.putString("Pay Rate", E_PayRateStr);
                e_editor.commit();
                Toast.makeText(ExpenseActivity.this, "Information Saved", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = findViewById(R.id.to_pay);
        Button two = findViewById(R.id.gotomm);

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
                Intent my2Int = new Intent(getApplicationContext(), Home_Page.class);
                startActivity(my2Int);
            }
        });
    }
}