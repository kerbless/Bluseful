package com.example.bluseful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Objects
        Button calculate = findViewById(R.id.calculate);


        // Listeners
        calculate.setOnClickListener(view -> calc());
        /* DOES THE SAME AS LINES 22
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedback.setText(R.string.output_click);
            }
        }); */
    }

    private void calc() {
        EditText initial_stop = findViewById(R.id.initial_stop);
        EditText end_stop = findViewById(R.id.end_stop);
        EditText line = findViewById(R.id.aubtobus_line);
        EditText id = findViewById(R.id.personal_id);
        EditText balance = findViewById(R.id.balance);
        TextView feedback = findViewById(R.id.feedback);
        feedback.setText("");
        int empty_fields = 0;
        if (initial_stop.getText().toString().equals("")) {
            feedback.append(getString(R.string.no_inital_stop) + "\n");
            initial_stop.setHintTextColor(getResources().getColor(R.color.error));
            empty_fields++;
        }
        if (end_stop.getText().toString().equals("")) {
            feedback.append(getString(R.string.no_end_stop) + "\n");
            initial_stop.setHintTextColor(getResources().getColor(R.color.error));
            empty_fields++;
        }
        if (line.getText().toString().equals("")) {
            feedback.append(getString(R.string.no_line) + "\n");
            empty_fields++;
        }
        if (id.getText().toString().equals("")) {
            feedback.append(getString(R.string.no_id) + "\n");
            empty_fields++;
        }
        if (balance.getText().toString().equals("")) {
            feedback.append(getString(R.string.no_balance));
            empty_fields++;
        }
        System.out.println(empty_fields);
        if(empty_fields == 0) {
            feedback.setText(getString(R.string.success));
            feedback.append("\n");
            feedback.append(getString(R.string.initial_stop) + ": " + initial_stop.getText().toString());
            feedback.append("\n");
            feedback.append(getString(R.string.end_stop) + ": " + end_stop.getText().toString());
            feedback.append("\n");
            feedback.append(getString(R.string.bus_line) + ": " + line.getText().toString());
            feedback.append("\n");
            feedback.append(getString(R.string.personal_id) + ": " + id.getText().toString());
            feedback.append("\n");
            feedback.append(getString(R.string.balance) + ": " + balance.getText().toString());
            initial_stop.setText("");
            end_stop.setText("");
            line.setText("");
            id.setText("");
            balance.setText("");
        }
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }
        catch (NullPointerException ignored) {}
    }
}