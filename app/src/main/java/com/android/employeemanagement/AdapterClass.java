package com.android.employeemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {
Context context;
List<employeedetailadd> listofemployees;

    public AdapterClass(Context context, List<employeedetailadd> listofemployees) {
        this.context = context;
        this.listofemployees = listofemployees;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(context).inflate(R.layout.recyclerviewlayout,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(listofemployees.get(position).getName());
        holder.fname.setText(listofemployees.get(position).getFname());
        holder.ecode.setText(listofemployees.get(position).getstringEcode());
        holder.mail.setText(listofemployees.get(position).getEmail());
        holder.mobile.setText(listofemployees.get(position).getstringMobile());
        holder.salary.setText(listofemployees.get(position).getstringSalary());
        holder.anumber.setText(listofemployees.get(position).getstringAnumber());
        holder.address.setText(listofemployees.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return listofemployees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,fname,ecode,mail,mobile,salary,anumber,address;
        Button edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            name= itemView.findViewById(R.id.n);
            fname= itemView.findViewById(R.id.fn);
            ecode= itemView.findViewById(R.id.ec);
            mail= itemView.findViewById(R.id.em);
            mobile= itemView.findViewById(R.id.m);
            salary= itemView.findViewById(R.id.s);
            anumber= itemView.findViewById(R.id.an);
            address= itemView.findViewById(R.id.a);

        }
    }

}
