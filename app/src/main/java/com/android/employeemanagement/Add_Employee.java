package com.android.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Employee extends AppCompatActivity {
    EditText name,fname,ecode,email,mobile,salary,anumber,address;
    Button Addbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        getWindow().setStatusBarColor(ContextCompat.getColor(Add_Employee.this,R.color.teal_700));

        name=findViewById(R.id.name);
        fname=findViewById(R.id.fname);
        ecode=findViewById(R.id.code);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.mobile);
        salary=findViewById(R.id.salary);
        anumber=findViewById(R.id.adhaar);
        address=findViewById(R.id.address);
        Addbutton=findViewById(R.id.add);

        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employeedetailadd adddetails= new employeedetailadd();
                try {

                    adddetails = new employeedetailadd(name.getText().toString(), fname.getText().toString(), Long.parseLong(ecode.getText().toString()), email.getText().toString(), Long.parseLong(mobile.getText().toString()), Long.parseLong(salary.getText().toString()), Long.parseLong(anumber.getText().toString()), address.getText().toString());
                    DBHelper dataBaseHelper= new DBHelper(Add_Employee.this);
                        Boolean success = dataBaseHelper.insertdata(adddetails);
                        if (success) {
                            Toast.makeText(Add_Employee.this, "Sucessfully Added", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Add_Employee.this, "Employee already exist", Toast.LENGTH_SHORT).show();
                        }

                }
                catch (Exception e)
                {
                    Toast.makeText(Add_Employee.this, "Error:Enter Details", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}