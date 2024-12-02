package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    // Declare UI elements for username, password fields, and login button
    EditText adminUsername, adminPassword;
    Button btnAdminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login); // Set the layout for this activity (login screen)

        // Initialize UI elements by binding them with their corresponding IDs in the layout
        adminUsername = findViewById(R.id.adminUsername);
        adminPassword = findViewById(R.id.adminPassword);
        btnAdminLogin = findViewById(R.id.btnAdminLogin);

        // Set an OnClickListener for the login button to handle user input
        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text input from the username and password fields
                String username = adminUsername.getText().toString();
                String password = adminPassword.getText().toString();

                // Validate the credentials entered by the user
                if (isValidLogin(username, password)) {
                    // If credentials are valid, navigate to the Admin Dashboard activity
                    Intent intent = new Intent(AdminLoginActivity.this, AdminDashboardActivity.class);
                    startActivity(intent);
                    finish(); // Close the current login activity to prevent the user from returning to it
                } else {
                    // Show a Toast message if the login credentials are invalid
                    Toast.makeText(AdminLoginActivity.this, "Invalid credentials, try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to validate the entered username and password
    private boolean isValidLogin(String username, String password) {
        // Example hard-coded validation logic (replace with real validation logic)
        return username.equals("admin") && password.equals("admin123");
    }
}
