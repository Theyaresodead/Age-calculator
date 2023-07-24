package com.example.agecalculator


import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
import androidx.annotation.RequiresApi


import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

abstract class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btndatepicker.setOnClickListener {view->
            clickDatePicker(view)
        }
    }
    fun clickDatePicker(view: View)
    {
         val mc=Calendar.getInstance()

        var month=mc.get(Calendar.MONTH)
        var date=mc.get(Calendar.DAY_OF_MONTH)
        val year=mc.get(Calendar.YEAR)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                Toast.makeText(this,"The year is $year , the month is $month , the date is $dayOfMonth",Toast.LENGTH_LONG).show()
            val selecteddate="$dayOfMonth/${month+1}/$year"
                sd.setText(selecteddate)
                val sdf=SimpleDateFormat("dd/mm/yyyy",Locale.ENGLISH)
                val theDate=sdf.parse(selecteddate)
                val sdtm=theDate!!.time/60000
                val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateTominutes=currentDate!!.time/60000
                val diff=currentDateTominutes- sdtm
                age.setText(diff.toString())

                                               } ,year,month,date).show()

    }
}


