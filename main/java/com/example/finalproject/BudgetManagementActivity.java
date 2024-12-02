package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BudgetManagementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_management);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText budgetLimitInput = findViewById(R.id.budgetLimitInput);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnSaveLimit = findViewById(R.id.btnSaveLimit);

        btnSaveLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String limit = budgetLimitInput.getText().toString().trim();

                // Check if the input is valid (a positive number)
                if (limit.isEmpty()) {
                    Toast.makeText(BudgetManagementActivity.this, "Please enter a budget limit", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double budgetLimit = Double.parseDouble(limit);
                    if (budgetLimit <= 0) {
                        Toast.makeText(BudgetManagementActivity.this, "Budget limit must be a positive number", Toast.LENGTH_SHORT).show();
                    } else {
                        // Save the valid budget limit in SharedPreferences
                        SharedPreferences prefs = getSharedPreferences("BudgetData", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("budgetLimit", String.valueOf(budgetLimit));
                        editor.apply();
                        Toast.makeText(BudgetManagementActivity.this, "Budget Limit Saved", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    // Handle invalid number format
                    Toast.makeText(BudgetManagementActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
