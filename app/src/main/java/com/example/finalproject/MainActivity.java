package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare buttons for Admin and Employee login
    private Button btnAdmin, btnEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout for the main screen

        // Initialize the buttons by finding them by their IDs
        btnAdmin = findViewById(R.id.btnAdmin);
        btnEmployee = findViewById(R.id.btnEmployee);

        // Set an OnClickListener for the Admin button
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Admin Login Activity when the Admin button is clicked
                Intent intent = new Intent(MainActivity.this, AdminLoginActivity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for the Employee button
        btnEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Employee Login Activity when the Employee button is clicked
                Intent intent = new Intent(MainActivity.this, EmployeeLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
