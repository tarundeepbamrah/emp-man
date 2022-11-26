package com.android.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Employee extends AppCompatActivity {
    ImageButton add,search,details,edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        getWindow().setStatusBarColor(ContextCompat.getColor(Employee.this,R.color.teal_700));


        add=findViewById(R.id.add_employee);
        search=findViewById(R.id.employee_search);
        details=findViewById(R.id.employee_details);
        edit=findViewById(R.id.employee_edit);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Employee.this,Add_Employee.class);
                startActivity(i);

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Employee.this,Search_Employee.class);
                startActivity(i);
            }
        });

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Employee.this,Employee_Details.class);
                startActivity(i);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Employee.this,Edit_Employee.class);
                startActivity(i);
            }
        });

    }
}