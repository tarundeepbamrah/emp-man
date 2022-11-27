package com.android.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.List;

public class Employee_Details extends AppCompatActivity {
    //ListView lv;
    RecyclerView recyclerView;
    AdapterClass employeeadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        getWindow().setStatusBarColor(ContextCompat.getColor(Employee_Details.this,R.color.teal_700));
        recyclerView=findViewById(R.id.listofemployeedetail);
        //lv= findViewById(R.id.lv);

        try {

            DBHelper dataBaseHelper = new DBHelper(Employee_Details.this);
            List<employeedetailadd> data = dataBaseHelper.allempdetails();
            //if (data !=null) {
            employeeadapter=new AdapterClass(Employee_Details.this,data);
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(Employee_Details.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(employeeadapter);
        }

        catch (Exception e)
        {
            Toast.makeText(Employee_Details.this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
}