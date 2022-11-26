package com.android.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.DialogCompat;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Search_Employee extends AppCompatActivity {

    EditText code;
    Button search,cancel;
    TextView name,fname,ecode,email,mob,salary,adhaar,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);
        getWindow().setStatusBarColor(ContextCompat.getColor(Search_Employee.this,R.color.teal_700));

        code= findViewById(R.id.code2);
        search=findViewById(R.id.add2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    long searchdetails = Long.parseLong(code.getText().toString());
                    DBHelper dataBaseHelper= new DBHelper(Search_Employee.this);
                    employeedetailadd success= dataBaseHelper.searchitem(searchdetails);
                    if(success.getEcode()!=-1) {
                       // Toast.makeText(Search_Employee.this, success.toString(), Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder=new AlertDialog.Builder(Search_Employee.this);
                        View view1 = LayoutInflater.from(Search_Employee.this).inflate(R.layout.dialogbox,null);
                        name=view1.findViewById(R.id.n);
                        fname=view1.findViewById(R.id.fn);
                        ecode=view1.findViewById(R.id.ec);
                        email=view1.findViewById(R.id.em);
                        mob=view1.findViewById(R.id.m);
                        salary=view1.findViewById(R.id.s);
                        adhaar=view1.findViewById(R.id.an);
                        address=view1.findViewById(R.id.a);
                        cancel=view1.findViewById(R.id.cancel);

                        name.setText(success.getName());
                        fname.setText(success.getFname());
                        ecode.setText(""+success.getEcode());
                        email.setText(success.getEmail());
                        mob.setText(""+success.getMobile());
                        salary.setText(""+success.getSalary());
                        adhaar.setText(""+success.getAnumber());
                        address.setText(success.getAddress());

                        builder.setView(view1);

                        AlertDialog dialog=builder.create();

                        dialog.getWindow().getAttributes().windowAnimations=R.style.animation;
                        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialogbackground));
                        dialog.setCancelable(false);
                        dialog.show();

                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });

                    }
                    else{
                        Toast.makeText(Search_Employee.this, "Employee not available", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(Search_Employee.this, "Error:Enter Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}