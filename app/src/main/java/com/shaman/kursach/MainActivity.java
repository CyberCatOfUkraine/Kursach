package com.shaman.kursach;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button AddEmpBtn;
    Button MakeSQLQuery;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AddEmpBtn =findViewById(R.id.add_btn);
        AddEmpBtn.setOnClickListener(v -> {

            Intent intent = new Intent(this, AddEmployeeActivity.class);
            startActivity(intent);
            UpdateScrollBar();
        });
        MakeSQLQuery=findViewById(R.id.make_sql_query_btn);
        MakeSQLQuery.setOnClickListener(x->{
            Intent intent = new Intent(this, MakeSQLQueryActivity.class);
            startActivity(intent);
            UpdateScrollBar();
        });
        UpdateScrollBar();
    }

    @SuppressLint("SetTextI18n")
    void UpdateScrollBar(){

        ArrayList<Employee> employees=SQLWrapper.GetAll();
        if (employees==null)
            return;
        TableLayout tableLayout = findViewById(R.id.main_Table);
        if (tableLayout.getChildCount()>1)
            tableLayout.removeViewAt(1);

        for (Employee employee : employees)
        {

            TableRow tableRow=new TableRow(this);

            TextView depNumberTextView = new TextView(this);
            TextView emplNumberTextView = new TextView(this);
            TextView surnameTextView = new TextView(this);
            TextView posCodeTextView = new TextView(this);
            TextView salaryAmountTextView = new TextView(this);

            depNumberTextView.setText(employee.DepartmentNumber.toString());
            emplNumberTextView.setText(employee.EmployeeNumber.toString());
            surnameTextView.setText(employee.Surname);
            posCodeTextView.setText(employee.PositionCode.toString());
            salaryAmountTextView.setText(employee.SalaryAmount.toString());

            tableRow.addView(depNumberTextView);
            tableRow.addView(emplNumberTextView);
            tableRow.addView(surnameTextView);
            tableRow.addView(posCodeTextView);
            tableRow.addView(salaryAmountTextView);

            tableLayout.addView(tableRow);

            tableRow.setOnClickListener(v->{
                CustomDialogFragment dialog = new CustomDialogFragment(tableLayout,tableRow,employee,this);
                dialog.show(getSupportFragmentManager(), "custom");
            });

        }
    }

}