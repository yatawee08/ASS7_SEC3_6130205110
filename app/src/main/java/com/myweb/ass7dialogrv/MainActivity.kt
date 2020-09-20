package com.myweb.ass7dialogrv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_employee_layout.*

class MainActivity : AppCompatActivity() {
    val employeeList = arrayListOf<Employees>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeData()

        recycler_view.adapter = EmployeeAdapter(this.employeeList, applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
    }

    fun employeeData(){
        employeeList.add(Employees("Danny", "Male", "danny@kku.ac.th", 30000))
        employeeList.add(Employees("Sara", "Female", "sara@kku.ac.th", 34000))

    }
    fun addEmployee(view: View) {
        val myDialogView = LayoutInflater.from(this).inflate(R.layout.add_employee_layout, null)
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.setView(myDialogView)
        val myAlertDialog = myBuilder.show()


        myAlertDialog.btnAdd.setOnClickListener(){
            val radioGroupId: Int = myAlertDialog.radioGroup.checkedRadioButtonId
            val selected: RadioButton? = myAlertDialog.findViewById(radioGroupId)
            val name = myAlertDialog.edt_name.text.toString()
            val gender = selected?.text.toString()
            var mail = myAlertDialog.edt_mail.text.toString()
            var salary = myAlertDialog.edt_salary.text.toString().toInt()

            employeeList.add(Employees(name, gender, mail, salary))
            recycler_view.adapter?.notifyDataSetChanged()
            myAlertDialog.dismiss()
        }
        myAlertDialog.btnCancel.setOnClickListener(){
            myAlertDialog.dismiss()
        }
    }
}