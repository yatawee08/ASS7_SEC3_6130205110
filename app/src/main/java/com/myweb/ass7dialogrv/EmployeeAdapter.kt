package com.myweb.ass7dialogrv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(val item: List<Employees>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.emp_item_layout, parent, false)
        return ViewHolder(view_item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName?.text = item[position].name
        holder.tvGender?.text = item[position].gender
        holder.tvMail?.text = item[position].mail
        holder.tvSalary?.text =item[position].salary.toString()
    }
    override fun getItemCount(): Int {
        return item.size
    }

}