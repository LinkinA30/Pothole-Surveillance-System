package com.example.potholesurveillance;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.annotation.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import android.os.Bundle;

public class DashboardMain extends AppCompatActivity {

    String EmailHolder;
    TextView Email;
    View Logout;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    FirebaseUser mUser;
    DatabaseReference mDatabase_name;
    ImageView directions_page, detection_page, feedback_page, workinprog_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_main);

        Email = (TextView)findViewById(R.id.welcome_name);
        Logout = (View)findViewById(R.id.Logout);
        directions_page = (ImageView)findViewById(R.id.directionspg);
        detection_page = (ImageView) findViewById(R.id.detectionpg);
        feedback_page = (ImageView) findViewById(R.id.feedbackpg);
        workinprog_page = (ImageView) findViewById(R.id.workinprogresspg);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra(login.userEmail);

        // Setting up received email to TextView.
        Email.setText(EmailHolder);

        directions_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(DashboardMain.this, DirectionsMaps.class);
                startActivity(intent2);
            }
        });

        detection_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenet3 = new Intent(DashboardMain.this, Detection.class);
                startActivity(intenet3);
            }
        });

        feedback_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(DashboardMain.this, Report.class);
                startActivity(intent5);
            }
        });

        workinprog_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(DashboardMain.this, WorkProgress.class);
                startActivity(intent6);
            }
        });

        // Adding click listener to Log Out button.
        Logout.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View v) {


                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(DashboardMain.this,"Log Out Successfull", Toast.LENGTH_LONG).show();

                Intent intent=new Intent(DashboardMain.this,login.class);
                startActivity(intent);

                //Intent intent=new Intent(DashboardActivity.this,login.class);
                //startActivity(intent);
               /*if (v.getId() == R.id.button1) {
                    AuthUI.getInstance()
                            .signOut(this)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                public void onComplete(@NonNull Task<Void> task) {
                                    // user is now signed out
                                    startActivity(new Intent(DashboardActivity.this, login.class));
                                    finish();
                                }
                            });
                }*/

            }
        });
    }
}