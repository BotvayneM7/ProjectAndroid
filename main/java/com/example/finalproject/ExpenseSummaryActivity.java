package com.example.finalproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ExpenseSummaryActivity extends AppCompatActivity {

    private ListView expensesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_summary);

        expensesListView = findViewById(R.id.expensesListView);

        // Load expense data
        ArrayList<String> expenseList = loadExpenseData();

        // Set the adapter to display the expenses
        AdapterActivity adapter = new AdapterActivity(this, expenseList);
        expensesListView.setAdapter(adapter);
    }

    private ArrayList<String> loadExpenseData() {
        ArrayList<String> expenses = new ArrayList<>();

        // Load from SharedPreferences (Admin-added expenses)
        SharedPreferences sharedPreferences = getSharedPreferences("ExpenseData", MODE_PRIVATE);
        String expenseType = sharedPreferences.getString("expenseType", "No Expenses");
        String expenseAmount = sharedPreferences.getString("expenseAmount", "0");

        if (!expenseType.equals("No Expenses")) {
            expenses.add("Admin - " + expenseType + ": $" + expenseAmount);
        }

        // Add hardcoded or dynamically loaded employee expenses
        expenses.add("Employee - Travel Expense: $50");
        expenses.add("Employee - Meal Expense: $30");
        expenses.add("Employee - Office Supplies: $120");

        return expenses;
    }
}
