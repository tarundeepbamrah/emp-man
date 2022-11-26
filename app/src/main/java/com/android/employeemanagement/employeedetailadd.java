package com.android.employeemanagement;

public class employeedetailadd {
    private String name,fname,email,address;
    private long ecode,mobile,salary,anumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getEcode() { return ecode; }

    public String getstringEcode() {return ""+ecode; }


    public void setEcode(long ecode) {
        this.ecode = ecode;
    }

    public long getMobile() {
        return mobile;
    }

    public String getstringMobile() {return ""+mobile; }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public long getSalary() {
        return salary;
    }

    public String getstringSalary() {return ""+salary; }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getAnumber() {
        return anumber;
    }

    public String getstringAnumber() {return ""+anumber; }

    public void setAnumber(long anumber) {
        this.anumber = anumber;
    }

    public employeedetailadd(String name, String fname, long ecode, String email, long mobile, long salary, long anumber, String address)
    {
        this.name=name;
        this.fname=fname;
        this.ecode=ecode;
        this.email=email;
        this.mobile=mobile;
        this.salary=salary;
        this.anumber=anumber;
        this.address=address;

    }

    public employeedetailadd() { }

    public String[] getarray() {
        String[] array={name,fname,""+ecode,email,""+mobile,""+salary,""+anumber,address};
        return array;
    }


    @Override
    public String toString() {
        return "employeedetailadd{" +
                "name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", ecode=" + ecode +
                ", mobile=" + mobile +
                ", salary=" + salary +
                ", anumber=" + anumber +
                '}';
    }
}
