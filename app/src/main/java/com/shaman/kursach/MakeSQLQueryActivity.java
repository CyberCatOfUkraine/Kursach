package com.shaman.kursach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MakeSQLQueryActivity extends AppCompatActivity {

    Button MakeSQLQuery;
    TextView SqlResultTextView;
    EditText SqlInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_s_q_l_query);

        MakeSQLQuery= findViewById(R.id.confirm_sql_query_btn);
        SqlResultTextView=findViewById(R.id.queryResultTextView);
        SqlInputEditText=findViewById(R.id.sql_query_EditText);

        MakeSQLQuery.setOnClickListener(x->{
            try {
                String result;
                result= SQLWrapper.MakeSQL(SqlInputEditText.getText().toString());
                SqlResultTextView.setText(result);
                SqlInputEditText.setText("");
            } catch (Exception e) {
                SqlResultTextView.setText(e.getMessage());
            }
        });
    }

}