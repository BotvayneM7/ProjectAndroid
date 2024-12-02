package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubmitExpenseActivity extends AppCompatActivity {

    private EditText expenseTypeInput, expenseAmountInput;
    private Button submitExpenseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_expense);

        // Initialize views
        expenseTypeInput = findViewById(R.id.expenseTypeInput);
        expenseAmountInput = findViewById(R.id.expenseAmountInput);
        submitExpenseButton = findViewById(R.id.submitExpenseButton);

        // Set click listener for the button
        submitExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expenseType = expenseTypeInput.getText().toString().trim();
                String expenseAmount = expenseAmountInput.getText().toString().trim();

                if (!expenseType.isEmpty() && !expenseAmount.isEmpty()) {
                    // Save the expense for review (you can save to SharedPreferences, database, or send to server)
                    Toast.makeText(SubmitExpenseActivity.this, "Expense submitted for review!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SubmitExpenseActivity.this, "Please fill out all fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button goBackToDashboardButton = findViewById(R.id.goBackToDashboardButton);

        goBackToDashboardButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, EmployeeViewActivity.class);
            startActivity(intent);
            finish();
        });


    }
}
