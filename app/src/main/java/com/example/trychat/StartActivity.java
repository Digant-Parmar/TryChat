package com.example.trychat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    Button btnStartLogin, btnStartRegis;

    @Override
    protected void onStart() {
        super.onStart();

        // Auto Login if has logged in before
        if(FirebaseAuth.getInstance().getCurrentUser() !=null){
            startActivity(new Intent(StartActivity.this,MainActivity.class));
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStartLogin = findViewById(R.id.btnStartLogin);
        btnStartRegis = findViewById(R.id.btnStartRegister);

        btnStartRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,RegistrationActivity.class));
            }
        });

        btnStartLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(StartActivity.this,LoginActivity.class)));
            }
        });
    }
}