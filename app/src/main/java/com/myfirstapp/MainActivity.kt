package com.myfirstapp

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var selectedDate:TextView?=null
    private var change:TextView?=null
    private var ageinmin:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnclick=findViewById<Button>(R.id.click)
        val mytext=findViewById<TextView>(R.id.myText)
        selectedDate=findViewById(R.id.selectedDate)
        change=findViewById(R.id.change)
        ageinmin=findViewById(R.id.result)
        btnclick.setOnClickListener {
            clickdate()
        }
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("blue")))
    }

    fun clickdate(){
        val mycalendar=Calendar.getInstance()
        val year=mycalendar.get(Calendar.YEAR)
        val month=mycalendar.get(Calendar.MONTH)
        val day=mycalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener
        { view, year, month, day->Toast.makeText(this,"Rate This App",Toast.LENGTH_LONG).show()
            val date="$day/${month+1}/$year"
            selectedDate?.setText(date)

            val str="Your Selected Date"
            change?.setText(str)

            val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate=sdf.parse(date)                        //date will not be in string & can perform calculation

            val selectedDateInMinutes=theDate.time/3600000
            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes=currentDate.time/3600000
            val diff_in_min=currentDateInMinutes-selectedDateInMinutes
            ageinmin?.setText(diff_in_min.toString())

        },year,month,day).show()
    }

}