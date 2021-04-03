package com.shaman.kursach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.*;

public class AddEmployeeActivity extends AppCompatActivity {

    EditText DepNumberEditText;
    EditText EmplNumberEditText;
    EditText SurnameEditText;
    EditText PosCodeEditText;
    EditText SalaryAmountEditText;
    Button AddBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        DepNumberEditText=findViewById(R.id.DepNumberEditText);
        EmplNumberEditText=findViewById(R.id.EmplNumberEditText);
        SurnameEditText=findViewById(R.id.SurnameEditText);
        PosCodeEditText=findViewById(R.id.PosCodeEditText);
        SalaryAmountEditText=findViewById(R.id.SalaryAmountEditText);

        AddBtn=findViewById(R.id.add_btn);

        AddBtn.setOnClickListener(v->{
            SQLWrapper.Add(new Employee( parseInt(DepNumberEditText.getText().toString()), parseInt(EmplNumberEditText.getText().toString()),SurnameEditText.getText().toString(), parseInt(PosCodeEditText.getText().toString()), parseInt(SalaryAmountEditText.getText().toString())));
        this.finish();
        });
    }
}