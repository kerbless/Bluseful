package com.example.bluseful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
        EditText autobus_line = findViewById(R.id.autobus_line);
        EditText personal_id = findViewById(R.id.personal_id);
        EditText balance = findViewById(R.id.balance);
        TextView feedback = findViewById(R.id.feedback);
        feedback.setText("");
        boolean ready = true;
        if(!testInput(initial_stop)) ready = false;
        if(!testInput(end_stop)) ready = false;
        if(!testInput(autobus_line)) ready = false;
        if(!testInput(personal_id)) ready = false;
        if(!testInput(balance)) ready = false;
        if(!ready) {
            feedback.setText(getString(R.string.missing_input));
        }
        else {
            feedback.setText(getString(R.string.input_success));
            feedback.append("\n");
            feedback.append(getString(R.string.initial_stop) + ": " + initial_stop.getText().toString());
            feedback.append("\n");
            feedback.append(getString(R.string.end_stop) + ": " + end_stop.getText().toString());
            feedback.append("\n");
            feedback.append(getString(R.string.bus_line) + ": " + autobus_line.getText().toString());
            feedback.append("\n");
            feedback.append(getString(R.string.personal_id) + ": " + personal_id.getText().toString());
            feedback.append("\n");
            feedback.append(getString(R.string.balance) + ": " + balance.getText().toString());
            initial_stop.setText("");
            initial_stop.setHintTextColor(getResources().getColor(R.color.hint));
            end_stop.setText("");
            end_stop.setHintTextColor(getResources().getColor(R.color.hint));
            autobus_line.setText("");
            autobus_line.setHintTextColor(getResources().getColor(R.color.hint));
            personal_id.setText("");
            personal_id.setHintTextColor(getResources().getColor(R.color.hint));
            balance.setText("");
            balance.setHintTextColor(getResources().getColor(R.color.hint));
        }
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }
        catch (NullPointerException ignored) {}
    }

    private boolean testInput(EditText x) {
        if (x.getText().toString().equals("")) {
            x.setHintTextColor(getResources().getColor(R.color.error));
            return false;
        }
        return true;
    }
}