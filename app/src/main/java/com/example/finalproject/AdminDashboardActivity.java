package com.example.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view); // Make sure this is the correct layout

        // Find the button in the layout using the correct ID
        Button btnAddExpense = findViewById(R.id.btnAddExpense);

        // Check if the button was found successfully
        if (btnAddExpense != null) {
            // Set the click listener for the button
            btnAddExpense.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the button click here
                    Log.d("AdminDashboardActivity", "Add Expense button clicked!");
                    // You can navigate to another activity, show a dialog, etc.
                }
            });
        } else {
            // Log an error if the button is not found
            Log.e("AdminDashboardActivity", "Button with ID 'btnAddExpense' is null. Please check the layout XML.");
        }
    }
}
