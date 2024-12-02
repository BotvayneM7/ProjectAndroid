package com.example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view); // Ensure this is the correct layout

        // Find the views in the layout
        EditText expenseType = findViewById(R.id.expenseType);
        EditText expenseAmount = findViewById(R.id.expenseAmount);
        Button btnSaveExpense = findViewById(R.id.btnSaveExpense);
        Button btnAddExpense = findViewById(R.id.btnAddExpense);

        // Set click listener for the 'Add Expense' button
        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the input fields for expense type and amount
                expenseType.setVisibility(View.VISIBLE);
                expenseAmount.setVisibility(View.VISIBLE);
                btnSaveExpense.setVisibility(View.VISIBLE);
            }
        });

        // Set click listener for the 'Save Expense' button
        btnSaveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expenseTypeStr = expenseType.getText().toString();
                String expenseAmountStr = expenseAmount.getText().toString();

                // Validate inputs
                if (expenseTypeStr.isEmpty() || expenseAmountStr.isEmpty()) {
                    Toast.makeText(AdminDashboardActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save data to SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("ExpenseData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("expenseType", expenseTypeStr);
                editor.putString("expenseAmount", expenseAmountStr);
                editor.apply();

                // Log success and show a Toast message
                Log.d("AdminDashboardActivity", "Expense saved successfully!");
                Toast.makeText(AdminDashboardActivity.this, "Expense saved!", Toast.LENGTH_SHORT).show();

                // Optionally, navigate to EmployeeDashboardActivity
                Intent intent = new Intent(AdminDashboardActivity.this, EmployeeViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
