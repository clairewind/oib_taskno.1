package com.example.unit3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private EditText fromUnit;
    private EditText toUnit;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        fromUnit = findViewById(R.id.fromUnit);
        toUnit = findViewById(R.id.toUnit);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        String input = inputValue.getText().toString();
        String from = fromUnit.getText().toString();
        String to = toUnit.getText().toString();

        if (input.isEmpty() || from.isEmpty() || to.isEmpty()) {
            resultText.setText("Please enter all values");
            return;
        }

        double inputValue = Double.parseDouble(input);
        double result = 0;

        switch (from) {
            case "cm":
                if (to.equals("m")) {
                    result = inputValue / 100;
                } else if (to.equals("cm")) {
                    result = inputValue;
                }
                break;
            case "m":
                if (to.equals("cm")) {
                    result = inputValue * 100;
                } else if (to.equals("m")) {
                    result = inputValue;
                }
                break;
            case "g":
                if (to.equals("kg")) {
                    result = inputValue / 1000;
                } else if (to.equals("g")) {
                    result = inputValue;
                }
                break;
            case "kg":
                if (to.equals("g")) {
                    result = inputValue * 1000;
                } else if (to.equals("kg")) {
                    result = inputValue;
                }
                break;
            default:
                resultText.setText("Conversion not supported");
                return;
        }

        resultText.setText(String.format("Result: %.2f %s", result, to));
    }
}
