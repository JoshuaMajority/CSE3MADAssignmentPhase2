package com.example.madassignmentphase2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Add_Invoice extends AppCompatActivity {

    public static boolean InvoiceAdded;



    EditText Date, Time, PayCompany, Hours, Pay, Tax;
    Button add_invoice;
    SharedPreferences sp;
    String DateStr, TimeStr, PayCompanyStr, HoursStr, PayStr, TaxStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invoice);

        Date = findViewById(R.id.editTextDate);
        Time = findViewById(R.id.editTextTime);
        PayCompany = findViewById(R.id.editPayCompany);
        Hours = findViewById(R.id.editPayHours);
        Pay = findViewById(R.id.editPay);
        Tax = findViewById(R.id.editTax);
        add_invoice = findViewById(R.id.addinv);

        sp = getSharedPreferences("Invoice", Context.MODE_PRIVATE);
        add_invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateStr = Date.getText().toString();
                TimeStr = Time.getText().toString();
                PayCompanyStr = PayCompany.getText().toString();
                HoursStr = Hours.getText().toString();
                PayStr = Pay.getText().toString();
                TaxStr = Tax.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("Date", DateStr);
                editor.putString("Time", TimeStr);
                editor.putString("PayCompany", PayCompanyStr);
                editor.putString("Hours", HoursStr);
                editor.putString("Pay", PayStr);
                editor.putString("Tax", TaxStr);
                editor.commit();
                Toast.makeText(Add_Invoice.this, "Information Saved", Toast.LENGTH_SHORT).show();
                InvoiceAdded = true; // value from Spinner
                Intent intent = new Intent(Add_Invoice.this, Home_Page.class);
                startActivity(intent);
            }
        });


        Button btn = findViewById(R.id.cai);
        Button two = findViewById(R.id.toexpense);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInt = new Intent(getApplicationContext(), Home_Page.class);
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