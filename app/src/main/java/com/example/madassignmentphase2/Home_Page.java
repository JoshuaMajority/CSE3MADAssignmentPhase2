package com.example.madassignmentphase2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Home_Page extends AppCompatActivity {

    AnyChartView anyChartView;

    String[] months = {"January", "Febuary", "March", "April"};

    int[] salary = {16000, 21000, 34000, 55000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button btn = findViewById(R.id.addin);
        Button two = findViewById(R.id.sett);
        Button three = findViewById(R.id.tomainmenu);
        Button four = findViewById(R.id.toshare);



        Pie pie = AnyChart.pie();
        List<DataEntry> data = new ArrayList<>();
        //data.add(new ValueDataEntry("John", 10000));

        Double TotalExpense = 0.00;
        Double payRate = 0.00;
        if (Add_Invoice.InvoiceAdded == true) {
            SharedPreferences sp = getApplicationContext().getSharedPreferences("Invoice", Context.MODE_PRIVATE);
            String payCompany = sp.getString("PayCompany", "");
            Double pay = Double.parseDouble(sp.getString("Pay", ""));
            data.add(new ValueDataEntry(payCompany, pay));
            //Add_Invoice.InvoiceAdded = false;
        }

        if (ExpenseActivity.ExpenceAdded == true) {
            Add_Invoice.InvoiceAdded = false;
            SharedPreferences sp1 = getApplicationContext().getSharedPreferences("Expense Data", Context.MODE_PRIVATE);
            Set<String> expenseSet = sp1.getStringSet("Expense", new HashSet<>());
            Iterator<String> itr = expenseSet.iterator();


            while (itr.hasNext()) {
                Log.d("myTag23", "Problem");
                String[] arrOfExpense = itr.next().split(",");
                Log.d("myTag24", "Problem");
                if (arrOfExpense[2] == "weekly") {
                    payRate = Double.parseDouble(arrOfExpense[1]);
                    TotalExpense = TotalExpense + payRate;
                    data.add(new ValueDataEntry(arrOfExpense[0], payRate));
                } else if (arrOfExpense[2].equals("monthly")) {
                    payRate = Double.parseDouble(arrOfExpense[1]) / 4.34524;
                    Log.d("myTag4", Double.toString(payRate));
                    TotalExpense = TotalExpense + payRate;
                    data.add(new ValueDataEntry(arrOfExpense[0], payRate));
                } else if (arrOfExpense[2] == "6monthly") {
                    payRate = Double.parseDouble(arrOfExpense[1]) / 26.0715;
                    TotalExpense = TotalExpense + payRate;
                    data.add(new ValueDataEntry(arrOfExpense[0], payRate));
                }
            }
            Add_Invoice.InvoiceAdded = true;
        }



        pie.data(data);

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.anyChartView);
        anyChartView.setChart(pie);




        //AnyChartView anyChartView = (AnyChartView) findViewById(R.id.anyChartView);

        //setupChartView();

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

