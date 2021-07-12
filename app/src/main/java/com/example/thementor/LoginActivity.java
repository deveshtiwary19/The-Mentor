package com.example.thementor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button sendOtp;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Folllowing is the code to set the status bar as color
        Window window= LoginActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(LoginActivity.this, R.color.colorMain));


        //Restricting the lanscape orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initialize(); //Following is the method, to initialize all the objects with their rspective ids

        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),OTPActivity.class);
                startActivity(i);
            }
        });


    }

    private void initialize() {
        sendOtp=findViewById(R.id.sendOTp_Login);
    }


}