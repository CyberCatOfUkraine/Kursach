package com.shaman.kursach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class EditEmployeeActivity extends AppCompatActivity {

    EditText DepNumberEditText;
    EditText EmplNumberEditText;
    EditText SurnameEditText;
    EditText PosCodeEditText;
    EditText SalaryAmountEditText;
    Button UpdateBtn;
    Bundle arguments ;
    Employee _employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);


        DepNumberEditText=findViewById(R.id.EditDepNumberEditText);
        EmplNumberEditText=findViewById(R.id.EditEmplNumberEditText);
        SurnameEditText=findViewById(R.id.EditSurnameEditText);
        PosCodeEditText=findViewById(R.id.EditPositionCodeEditText);
        SalaryAmountEditText=findViewById(R.id.EditSalaryAmountEditText);

        UpdateBtn =findViewById(R.id.update_btn);

        arguments = getIntent().getExtras();
        _employee=SQLWrapper.GetById(parseInt(arguments.get("employeeId").toString()));

        try {

            DepNumberEditText.setText(String.valueOf(_employee.DepartmentNumber));
            EmplNumberEditText.setText(String.valueOf(_employee.EmployeeNumber));
            SurnameEditText.setText(String.valueOf(_employee.Surname));
            PosCodeEditText.setText(String.valueOf(_employee.PositionCode));
            SalaryAmountEditText.setText(String.valueOf(_employee.SalaryAmount));
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        UpdateBtn.setOnClickListener(this::employeeUpdateOnClick);

    }

    private void employeeUpdateOnClick(View v) {

        int id = parseInt(arguments.get("employeeId").toString());    // Hello World
        try {
            SQLWrapper.Modify(SQLWrapper.GetById(id),new Employee(parseInt(DepNumberEditText.getText().toString()), parseInt(EmplNumberEditText.getText().toString()), SurnameEditText.getText().toString(), parseInt(PosCodeEditText.getText().toString()), parseInt(SalaryAmountEditText.getText().toString())));
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}