package com.android.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailsforEdit extends AppCompatActivity {

    EditText name,fname,email,mobile,salary,anumber,address;
    Button Addbutton;
    String ecode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsfor_edit);

        getWindow().setStatusBarColor(ContextCompat.getColor(DetailsforEdit.this,R.color.teal_700));

        name=findViewById(R.id.edname);
        fname=findViewById(R.id.edfname);
        email=findViewById(R.id.edemail);
        mobile=findViewById(R.id.edmobile);
        salary=findViewById(R.id.edsalary);
        anumber=findViewById(R.id.edadhaar);
        address=findViewById(R.id.edaddress);
        Addbutton=findViewById(R.id.editadd);
        Intent intent= getIntent();
        ecode=intent.getStringExtra("itemkey");



        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employeedetailadd editdetails= new employeedetailadd();
                try {

                    editdetails = new employeedetailadd(name.getText().toString(), fname.getText().toString(), Long.parseLong(ecode), email.getText().toString(), Long.parseLong(mobile.getText().toString()), Long.parseLong(salary.getText().toString()), Long.parseLong(anumber.getText().toString()), address.getText().toString());
                    DBHelper dataBaseHelper= new DBHelper(DetailsforEdit.this);
                    Long l=Long.parseLong(ecode);
                    employeedetailadd success= dataBaseHelper.employeeedit(editdetails);
                    if (success.getEcode()!=-1) {
                        Toast.makeText(DetailsforEdit.this, "Sucessfully Updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailsforEdit.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(DetailsforEdit.this, "Error:Enter Details", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}