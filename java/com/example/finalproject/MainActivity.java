// Package declaration for the project
package com.example.finalproject;

// Import necessary Android and Java classes
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge; // For enabling edge-to-edge display
import androidx.appcompat.app.AppCompatActivity; // Base class for activities with action bar support
import androidx.core.graphics.Insets; // To handle system bar insets
import androidx.core.view.ViewCompat; // Compatibility utility for views
import androidx.core.view.WindowInsetsCompat; // Compatibility class for window insets

// MainActivity class that extends AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Annotation to suppress warnings about missing inflated IDs
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Call the parent class's onCreate method

        // Enable edge-to-edge UI mode for immersive experience
        EdgeToEdge.enable(this);

        // Set the layout resource to be displayed as the main content of this activity
        setContentView(R.layout.activity_main);

        // Adjust the view's padding to account for system bars (status bar, navigation bar, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Get the dimensions of the system bars
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Apply padding to the view to prevent overlap with system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // Return the modified insets
        });

        // Reference buttons from the layout using their IDs
        Button btnAdmin = findViewById(R.id.btnAdmin);
        Button btnEmployee = findViewById(R.id.btnEmployee);

        // Set up a click listener for the "Admin" button
        btnAdmin.setOnClickListener(v -> {
            // Create an intent to navigate to the AdminLoginActivity
            Intent intent = new Intent(MainActivity.this, AdminLoginActivity.class);
            // Start the new activity
            startActivity(intent);
        });

        // Set up a click listener for the "Employee" button
        btnEmployee.setOnClickListener(v -> {
            // Create an intent to navigate to the EmployeeLoginActivity
            Intent intent = new Intent(MainActivity.this, EmployeeLoginActivity.class);
            // Start the new activity
            startActivity(intent);
        });
    }
}
