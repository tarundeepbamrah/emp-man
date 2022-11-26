
package com.android.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_Employee extends AppCompatActivity {
    EditText code;
    Button edit,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);
        getWindow().setStatusBarColor(ContextCompat.getColor(Edit_Employee.this,R.color.teal_700));

        code=findViewById(R.id.code3);
        edit=findViewById(R.id.edit);
        delete=findViewById(R.id.delete);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    long editdetails = Long.parseLong(code.getText().toString());
                    DBHelper dataBaseHelper= new DBHelper(Edit_Employee.this);
                    employeedetailadd success= dataBaseHelper.checkcode(editdetails);
                    if(success.getEcode()==-2) {
                        Intent intent = new Intent (getApplicationContext(),DetailsforEdit.class);
                        String strcode= code.getText().toString();
                        intent.putExtra("itemkey",strcode);
                        startActivity(intent);

                    }
                    else if(success.getEcode()==-1){
                        Toast.makeText(Edit_Employee.this, "Employee not available", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(Edit_Employee.this, "Error:Enter Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    long deletedetails = Long.parseLong(code.getText().toString());
                    DBHelper dataBaseHelper= new DBHelper(Edit_Employee.this);
                    employeedetailadd success= dataBaseHelper.delete(deletedetails);
                    if(success.getEcode()!=-1) {
                        Toast.makeText(Edit_Employee.this, "Employee Details Deleted", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(Edit_Employee.this, "Employee not available", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(Edit_Employee.this, "Error:Enter Details", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}