package com.example.finalproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Button btnAdminLogin = findViewById(R.id.btnAdminLogin);

        // Example login action for Admin
        btnAdminLogin.setOnClickListener(v -> {
            // Implement login logic here
            Toast.makeText(AdminLoginActivity.this, "Admin Login Successful", Toast.LENGTH_SHORT).show();
            // Navigate to admin-specific functionality screen if needed
        });
    }
}
