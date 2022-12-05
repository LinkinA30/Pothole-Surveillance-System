package com.example.potholesurveillance;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Report extends AppCompatActivity {

    View submit_btn_feedback, detect_your_location, gallery_up, camera_up;
    ProgressDialog dialog;
    AutoCompleteTextView address_l1, address_l2;
    Bitmap bitmap;
    ImageView feedback_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_main);

        submit_btn_feedback = (View) findViewById(R.id.feedback_submit);
        detect_your_location = (View) findViewById(R.id.detect_location);
        address_l1 = (AutoCompleteTextView) findViewById(R.id.address_line1);
        address_l2 = (AutoCompleteTextView) findViewById(R.id.address_line2);
        dialog = new ProgressDialog(Report.this);
        feedback_img = (ImageView) findViewById(R.id.feedback_image);
        gallery_up = (View) findViewById(R.id.feedback_gallery);
        camera_up = (View) findViewById(R.id.feedback_camera);

        //permission
        getPermission();

        gallery_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 10);
            }
        });

        camera_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 12);
            }
        });

        submit_btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Report.this, ReportSuccess.class );
                startActivity(intent2);

                address_l1.setText("");
                address_l1.setHint("Street, Colony, Area");
                address_l1.setTextSize(16);

                address_l2.setText("");
                address_l2.setHint("Pincode");
                address_l2.setTextSize(16);

                feedback_img.setImageResource(R.drawable.report_pothole);

                Toast.makeText(Report.this, "Pothole Reported Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        detect_your_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setMessage("Detecting your location...");
                dialog.setIndeterminate(true);
                //dialog.setIndeterminate(true);
                dialog.setCancelable(false);
                dialog.show();
                long delayInMillis = 1000;
                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, delayInMillis);

                address_l1.setText("MIT World Peace University, Pune");
                address_l1.setTextSize(15);
                address_l2.setText("411030");
                address_l2.setTextSize(15);
            }


        });
    }

    int getMax(float[] arr){
        int max=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>arr[max]){
                max = i;
            }
        }
        return max;
    }

    void getPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Report.this, new String[]{Manifest.permission.CAMERA},11);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==11){
            if(grantResults.length>0){
                if(grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    this.getPermission();
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == 10){
            if(data!=null){
                Uri uri = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    feedback_img.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        else if(requestCode == 12){
            bitmap = (Bitmap) data.getExtras().get("data");
            feedback_img.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}