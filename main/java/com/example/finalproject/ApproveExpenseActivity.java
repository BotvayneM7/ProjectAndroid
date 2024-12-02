package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;

public class ApproveExpenseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_expense);

        // Get expense details from intent
        String expenseID = getIntent().getStringExtra("expenseID");
        String expenseType = getIntent().getStringExtra("expenseType");
        String expenseAmount = getIntent().getStringExtra("expenseAmount");

        // Display expense details
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView expenseDetails = findViewById(R.id.expenseDetails);
        expenseDetails.setText("Expense Type: " + expenseType + "\nAmount: " + expenseAmount);

        Button approveButton = findViewById(R.id.btnApprove);
        Button declineButton = findViewById(R.id.btnDecline);

        approveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the status to approved and notify employee
                updateExpenseStatus(expenseID, "Approved");
                Toast.makeText(ApproveExpenseActivity.this, "Expense Approved!", Toast.LENGTH_SHORT).show();
                finish(); // Go back to AdminDashboardActivity
            }
        });

        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the status to declined and notify employee
                updateExpenseStatus(expenseID, "Declined");
                Toast.makeText(ApproveExpenseActivity.this, "Expense Declined!", Toast.LENGTH_SHORT).show();
                finish(); // Go back to AdminDashboardActivity
            }
        });
    }

    // Method to update the status of the expense (for example, in SharedPreferences or a database)
    private void updateExpenseStatus(String expenseID, String status) {
        // Update the status of the expense in SharedPreferences or database
        // Example with SharedPreferences:
        SharedPreferences sharedPreferences = getSharedPreferences("ExpenseData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(expenseID + "_status", status);
        editor.apply();
    }
}
