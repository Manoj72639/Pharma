package com.example.massthree.pharma;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(5 * 1000);
                    functionrun();
                    // After 5 seconds redirect to another intent
                   /* Intent i = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(i);*/



                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };
        background.start();


    }
    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
    private void functionrun()
    {

        if (isNetworkAvailable(SplashScreen.this))
        {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i);
            if (ActivityCompat.checkSelfPermission(SplashScreen.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED&&
                    ActivityCompat.checkSelfPermission(SplashScreen.this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED )
            {
                ActivityCompat.requestPermissions(SplashScreen.this,new String[]
                        {Manifest.permission.CAMERA,
                                READ_EXTERNAL_STORAGE },1);
            }

        }
        else
        {
            Intent i = new Intent(getBaseContext(), InternetChecking.class);

            startActivity(i);
        }


    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
