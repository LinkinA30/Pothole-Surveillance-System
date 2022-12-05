package com.example.potholesurveillance;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;


public class AdminDashboard extends AppCompatActivity {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    String AdminNameHolder;
    TextView name_admin;
    ImageView ad_directions_button, ad_work_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_admin);

        barChart = findViewById(R.id.today_bar);
        name_admin = findViewById(R.id.admin_name);

        ad_directions_button = (ImageView) findViewById(R.id.admin_dir_b);
        ad_work_button = (ImageView) findViewById(R.id.admin_work_b);


        ad_directions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AdminDashboard.this, AdminDirections.class );
                startActivity(intent2);
            }
        });

        ad_work_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(AdminDashboard.this, AdminUserReports.class);
                startActivity(intent3);
            }
        });

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        AdminNameHolder = intent.getStringExtra(login.Admin_n);

        // Setting up received email to TextView.
        name_admin.setText(AdminNameHolder);
        getEntries();

        barDataSet = new BarDataSet(barEntries, "");
        barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(10f);
    }

    private void getEntries() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(2f, 2));
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(6f, 1));
        barEntries.add(new BarEntry(8f, 3));

    }
}
