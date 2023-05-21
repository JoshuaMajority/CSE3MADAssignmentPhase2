package com.example.madassignmentphase2;

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

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class ExpenseActivity extends AppCompatActivity {

    EditText E_Name, E_PayRate;
    Button add_new_expense;
    SharedPreferences e_sp;
    String E_NameStr, E_PayRateStr;

    String Interval;

    Set<String> expenseSet;

    public static boolean ExpenceAdded;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        RadioButton weeklyRB = findViewById(R.id.weekb);
        RadioButton monthlyRB = findViewById(R.id.monthb);
        RadioButton sixmonthlyRB = findViewById(R.id.sixmonthb);

        E_Name = findViewById(R.id.editE_Name);
        E_PayRate = findViewById(R.id.editE_PR);
        add_new_expense = findViewById(R.id.addnewexpense);

        e_sp = getSharedPreferences("Expense Data", Context.MODE_PRIVATE);
        expenseSet = e_sp.getStringSet("Expense", new HashSet<>());


        weeklyRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String intervalStr = "weekly";
                Interval = "weekly";
                SharedPreferences.Editor e_editor = e_sp.edit();
                e_editor.putString("expenseWeeklyInterval", intervalStr);
                e_editor.apply();
            }
        });

        monthlyRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String intervalStr = "monthly";
                Interval = "monthly";
                SharedPreferences.Editor e_editor = e_sp.edit();
                e_editor.putString("expenseMonthlyInterval", intervalStr);
                e_editor.apply();
            }
        });

        sixmonthlyRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String intervalStr = "6 monthly";
                Interval = "6monthly";
                SharedPreferences.Editor e_editor = e_sp.edit();
                e_editor.putString("expenseSixMonthlyInterval", intervalStr);
                e_editor.apply();
            }
        });

        add_new_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                E_NameStr = E_Name.getText().toString();
                E_PayRateStr = E_PayRate.getText().toString();

                SharedPreferences.Editor e_editor = e_sp.edit();

                String eExpenseStr = E_NameStr + "," + E_PayRateStr + "," + Interval;

                if (expenseSet != null && !expenseSet.isEmpty()) {
                    expenseSet.add(eExpenseStr);
                } else {
                    expenseSet = new HashSet<>();
                    expenseSet.add(eExpenseStr);
                }

                e_editor.putStringSet("Expense", expenseSet);
                e_editor.apply();
                Toast.makeText(ExpenseActivity.this, "Expense added successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ExpenseActivity.this, Home_Page.class);
                startActivity(intent);
                ExpenceAdded = true;

            }
        });
    }
}