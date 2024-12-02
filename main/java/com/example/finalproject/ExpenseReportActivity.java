package com.example.finalproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExpenseReportActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_report);

        // Retrieve expense data from SharedPreferences or database
        SharedPreferences prefs = getSharedPreferences("ExpenseData", MODE_PRIVATE);
        String expenseType = prefs.getString("expenseType", "No expense type");
        String expenseAmount = prefs.getString("expenseAmount", "No amount");

        // Display the expense details
        TextView expenseReport = findViewById(R.id.expenseReport);
        expenseReport.setText("Expense Type: " + expenseType + "\n" + "Amount: " + expenseAmount);

        // If you want to handle the total expenses, you can update the TextView for total expenses dynamically.
        TextView totalExpenses = findViewById(R.id.total_expenses);
        double total = 0.0; // Set this dynamically based on total expense calculation
        totalExpenses.setText("Total Expenses: $" + total);
    }
}
