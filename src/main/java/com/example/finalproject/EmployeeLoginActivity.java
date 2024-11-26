package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class EmployeeLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        Button btnEmployeeLogin = findViewById(R.id.btnEmployeeLogin);


        btnEmployeeLogin.setOnClickListener(v -> {
            boolean isLoginSuccessful = true;

            if (isLoginSuccessful) {
                Toast.makeText(EmployeeLoginActivity.this, "Employee Login Successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EmployeeLoginActivity.this,EmployeeViewActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(EmployeeLoginActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
