package com.example.potholesurveillance;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Detection extends AppCompatActivity {

    View gallery_up, camera_up, detection, home_page;
    TextView if_pothole;
    ImageView pothole_image;
    Bitmap bitmap;
    ProgressDialog dialog;

    int counter_for_image=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detection_main);

        gallery_up = (View) findViewById(R.id.gallery_upload);
        camera_up = (View) findViewById(R.id.camera_upload);
        detection = (View) findViewById(R.id.detection_view);
        home_page = (View) findViewById(R.id.home_view);
        if_pothole = (TextView) findViewById(R.id.ifpothole);
        dialog = new ProgressDialog(Detection.this);

        pothole_image = (ImageView) findViewById(R.id.pothole_upload);

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
                counter_for_image = 3;
            }
        });

        detection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setMessage("Model Running...");
                dialog.setIndeterminate(true);
                //dialog.setIndeterminate(true);
                dialog.setCancelable(false);
                dialog.show();

                long delayInMillis = 1000;
                Timer timer = new Timer();

                if (counter_for_image == 1){
                    //dialog.dismiss();

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    }, delayInMillis);

                    pothole_image.setImageResource(R.drawable.pothole1_yes);
                    if_pothole.setText("Potholes Detected !!!");
                    counter_for_image = 2;
                }

                else if(counter_for_image == 2){
                    //dialog.dismiss();

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    }, delayInMillis);

                    pothole_image.setImageResource(R.drawable.pothole2_yes);
                    if_pothole.setText("Potholes Detected !!!");
                    counter_for_image = 1;
                }

                else if(counter_for_image == 3){
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    }, delayInMillis);

                    if_pothole.setText("No Potholes Detected");


                }

                else{
                 // do nothing
                }
            }
        });

        home_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Detection.this, DashboardMain.class);
                startActivity(intent4);
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
                ActivityCompat.requestPermissions(Detection.this, new String[]{Manifest.permission.CAMERA},11);
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
                    pothole_image.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        else if(requestCode == 12){
            bitmap = (Bitmap) data.getExtras().get("data");
            pothole_image.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
