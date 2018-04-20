package com.example.massthree.pharma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InternetChecking extends AppCompatActivity {

    Button bttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_checking);
        bttn=(Button)findViewById(R.id.bttn);


        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InternetChecking.this.finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                startActivity(intent);
                }
        });
    }
}