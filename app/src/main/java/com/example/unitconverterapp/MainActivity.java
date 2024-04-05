package com.example.unitconverterapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //subCategories for nested spinner
    Spinner spinner_1, spinner_2;
    List<String> subCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        List<String> categories = new ArrayList<>();
        categories.add("Length");
        categories.add("Weight");
        categories.add("Temperature");

        spinner_1 = findViewById(R.id.LengthUnits);
        spinner_2 = findViewById(R.id.WeightUnits);

        ArrayAdapter<String> adapter_1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        adapter_1.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        Spinner TypeofConversion = findViewById(R.id.TypeOfConversion);
        TypeofConversion.setAdapter(adapter_1);
        TypeofConversion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        } );

        //Different Length Unit Conversion Units
        Spinner Lengthunits = findViewById(R.id.LengthUnits);
        ArrayAdapter<CharSequence> adapter_LengthUnits = ArrayAdapter.createFromResource(
                this,
                R.array.LengthUnits,
                android.R.layout.simple_spinner_item
        );
        adapter_LengthUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Lengthunits.setAdapter(adapter_LengthUnits);

        //Different Weight Unit Conversion Units
        Spinner Weightunits = findViewById(R.id.WeightUnits);
        ArrayAdapter<CharSequence> adapter_WeightUnits = ArrayAdapter.createFromResource(
                this,
                R.array.WeightUnits,
                android.R.layout.simple_spinner_item
        );
        adapter_WeightUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Weightunits.setAdapter(adapter_WeightUnits);

        Button button = findViewById(R.id.button);
        TextView results = findViewById(R.id.textView);
        EditText input = findViewById(R.id.editTextText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TypeofConversion.getSelectedItem().toString().equals("Length")) {
                    double value = Double.parseDouble(input.getText().toString());
                    if (spinner_1.getSelectedItem().toString().equals("Inch"))
                    {
                        value = value * 2.54;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_1.getSelectedItem().toString().equals("Foot"))
                    {
                        value = value * 30.48;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_1.getSelectedItem().toString().equals("Yard"))
                    {
                        value = value * 91.44;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_1.getSelectedItem().toString().equals("Mile"))
                    {
                        value = value * 185200;
                        results.setText(Double.toString(value));
                    }
                    results.setText(Double.toString(value));
                    if (spinner_2.getSelectedItem().toString().equals("Inch"))
                    {
                        value = value / 2.54;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Foot"))
                    {
                        value = value / 30.48;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Yard"))
                    {
                        value = value / 91.44;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Mile"))
                    {
                        value = value / 185200;
                        results.setText(Double.toString(value));
                    }
                }
                if (TypeofConversion.getSelectedItem().toString().equals("Weight")){
                    double value = Double.parseDouble(input.getText().toString());
                    if (spinner_1.getSelectedItem().toString().equals("Pound"))
                    {
                        value = value * 453.592;
                    }
                    if (spinner_1.getSelectedItem().toString().equals("Ounce"))
                    {
                        value = value * 28.3495;
                    }
                    if (spinner_1.getSelectedItem().toString().equals("Ton"))
                    {
                        value = value * 907185;
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Pound"))
                    {
                        value = value / 453.592;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Ounce"))
                    {
                        value = value / 28.3495;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Ton"))
                    {
                        value = value / 907185;
                        results.setText(Double.toString(value));
                    }
                }
                if (TypeofConversion.getSelectedItem().toString().equals("Temperature"))
                {
                    double value = Double.parseDouble(input.getText().toString());
                    if (spinner_1.getSelectedItem().toString().equals("Celsius"))
                    {
                        value = value * 1;
                    }
                    if (spinner_1.getSelectedItem().toString().equals("Fahrenheit"))
                    {
                        value = (value-32) * 5/9;
                    }
                    if (spinner_1.getSelectedItem().toString().equals("Kelvin"))
                    {
                        value = value - 273.15;
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Celsius"))
                    {
                        value = value / 1;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Fahrenheit"))
                    {
                        value = (value * 9/5)+32;
                        results.setText(Double.toString(value));
                    }
                    if (spinner_2.getSelectedItem().toString().equals("Kelvin"))
                    {
                        value = value + 273.15;
                        results.setText(Double.toString(value));
                    }
                }

            }
        });

        TypeofConversion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (adapterView.getItemAtPosition(position).equals("Length"))
                {
                    subCategories.clear();
                    subCategories.add("Inch"); subCategories.add("Foot");subCategories.add("Yard");subCategories.add("Mile");
                    fillSpinner();

                }
                else if (adapterView.getItemAtPosition(position).equals("Weight"))
                {
                    subCategories.clear();
                    subCategories.add("Pound"); subCategories.add("Ounce");subCategories.add("Ton");
                    fillSpinner();
                }
                else if (adapterView.getItemAtPosition(position).equals("Temperature"))
                {
                    subCategories.clear();
                    subCategories.add("Celsius"); subCategories.add("Fahrenheit");subCategories.add("Kelvin");
                    fillSpinner();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textView2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    public void fillSpinner()
    {
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,subCategories);
        adapter_2.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner_1.setAdapter(adapter_2);
        spinner_2.setAdapter(adapter_2);
    }
}