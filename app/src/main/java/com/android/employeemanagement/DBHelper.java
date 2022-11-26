package com.android.employeemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "Employee.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table EmployeeDetails(Name TEXT, Fathers_name TEXT, Employee_code INT primary key, Email TEXT, Mobile INT, Salary INT, Adhaar_Number INT, Address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists EmployeeDetails");

    }

    public Boolean insertdata(employeedetailadd employeedetailadd) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Name",employeedetailadd.getName());
        cv.put("Fathers_Name",employeedetailadd.getFname());
        cv.put("Employee_code",employeedetailadd.getEcode());
        cv.put("Email",employeedetailadd.getEmail());
        cv.put("Mobile",employeedetailadd.getMobile());
        cv.put("Salary",employeedetailadd.getSalary());
        cv.put("Adhaar_Number",employeedetailadd.getAnumber());
        cv.put("Address",employeedetailadd.getAddress());

        long result=sqLiteDatabase.insert("EmployeeDetails", null,cv);

        if(result==-1)
        {
            return false;
        }
        else {
            return true;
        }

    }


    public employeedetailadd searchitem(long item) {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("Select * from EmployeeDetails", null);
        employeedetailadd details =new employeedetailadd();
        if(cursor!=null) {
            cursor.moveToFirst();
            String name,fname,email,Add;
            long ecode,mob,salary,adhaar;
            do {
                name=cursor.getString(0);
                fname=cursor.getString(1);
                ecode=cursor.getLong(2);
                email=cursor.getString(3);
                mob=cursor.getLong(4);
                salary=cursor.getLong(5);
                adhaar=cursor.getLong(6);
                Add=cursor.getString(7);
                if(ecode==item){
                    details=new employeedetailadd(name,fname,ecode,email,mob,salary,adhaar,Add);
                    break;
                }
            }while(cursor.moveToNext());
            if (cursor.moveToLast()&&ecode!=item) {
                details.setEcode(-1);
            }
        }
        return details;
    }

    public List<employeedetailadd> allempdetails() {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("Select * from EmployeeDetails", null);
        employeedetailadd emp = new employeedetailadd();

        List<employeedetailadd> emplist = new ArrayList<>();

        //int i=0,j;
       // String[][] tabledata ={{"Tarun"}};
        if(cursor!=null) {
            cursor.moveToFirst();
            String name, fname, email, Add;
            long ecode, mob, salary, adhaar;
            do {
                name = cursor.getString(0);
                fname = cursor.getString(1);
                ecode = cursor.getLong(2);
                email = cursor.getString(3);
                mob = cursor.getLong(4);
                salary = cursor.getLong(5);
                adhaar = cursor.getLong(6);
                Add = cursor.getString(7);
                emp = new employeedetailadd(name, fname, ecode, email, mob, salary, adhaar, Add);

                emplist.add(emp);

            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return emplist;
    }

    public employeedetailadd employeeedit(employeedetailadd newdet) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("Select * from EmployeeDetails", null);
        employeedetailadd details =new employeedetailadd();
        if(cursor!=null) {
            cursor.moveToFirst();
            String name,fname,email,Add;
            long ecode,mob,salary,adhaar;
            do {
                name=cursor.getString(0);
                fname=cursor.getString(1);
                ecode=cursor.getLong(2);
                email=cursor.getString(3);
                mob=cursor.getLong(4);
                salary=cursor.getLong(5);
                adhaar=cursor.getLong(6);
                Add=cursor.getString(7);
                if(ecode== newdet.getEcode()){
                    details=new employeedetailadd(newdet.getName(),newdet.getFname(),newdet.getEcode(),newdet.getEmail(),newdet.getMobile(),newdet.getSalary(),newdet.getAnumber(),newdet.getAddress());
                    ContentValues cv=new ContentValues();
                    cv.put("Name",details.getName());
                    cv.put("Fathers_Name",details.getFname());
                    cv.put("Employee_code",details.getEcode());
                    cv.put("Email",details.getEmail());
                    cv.put("Mobile",details.getMobile());
                    cv.put("Salary",details.getSalary());
                    cv.put("Adhaar_Number",details.getAnumber());
                    cv.put("Address",details.getAddress());
                    long result=sqLiteDatabase.update("EmployeeDetails", cv,"Employee_code=?",new String[]{""+newdet.getEcode()});
                    break;
                }
            }while(cursor.moveToNext());
            if (cursor.moveToLast()&&ecode!=newdet.getEcode()) {
                details.setEcode(-1);
            }
        }
        return details;
    }


    public employeedetailadd checkcode(long item) {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("Select * from EmployeeDetails", null);
        employeedetailadd details =new employeedetailadd();
        if(cursor!=null) {
            cursor.moveToFirst();
            String name,fname,email,Add;
            long ecode,mob,salary,adhaar;
            do {
                name=cursor.getString(0);
                fname=cursor.getString(1);
                ecode=cursor.getLong(2);
                email=cursor.getString(3);
                mob=cursor.getLong(4);
                salary=cursor.getLong(5);
                adhaar=cursor.getLong(6);
                Add=cursor.getString(7);
                if(ecode==item){
                    details.setEcode(-2);
                    break;
                }
            }while(cursor.moveToNext());
            if (cursor.moveToLast()&&ecode!=item) {
                details.setEcode(-1);
            }
        }
        return details;
    }

    public employeedetailadd delete(long item) {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("Select * from EmployeeDetails", null);
        employeedetailadd details =new employeedetailadd();
        if(cursor!=null) {
            cursor.moveToFirst();
            String name,fname,email,Add;
            long ecode,mob,salary,adhaar;
            do {
                name=cursor.getString(0);
                fname=cursor.getString(1);
                ecode=cursor.getLong(2);
                email=cursor.getString(3);
                mob=cursor.getLong(4);
                salary=cursor.getLong(5);
                adhaar=cursor.getLong(6);
                Add=cursor.getString(7);
                if(ecode== item){
                    long result=sqLiteDatabase.delete("EmployeeDetails", "Employee_code=?",new String[]{""+item});
                    break;
                }
            }while(cursor.moveToNext());
            if (cursor.moveToLast()&&ecode!=item) {
                details.setEcode(-1);
            }
        }
        return details;
    }


}
