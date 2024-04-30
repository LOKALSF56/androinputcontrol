package id.utbandung.myapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class datepicker : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    var hari = 0
    var bulan = 0
    var tahun = 0
    var jam = 0
    var menit = 0

    var spnhari = 0
    var spnbulan = 0
    var spntahun = 0
    var spnjam = 0
    var spnmenit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_datepicker)
        pickDate()
    }

    private fun getTimeCalendar() {
        val cal = Calendar.getInstance()
        hari = cal.get(Calendar.DAY_OF_MONTH)
        bulan = cal.get(Calendar.MONTH)
        tahun = cal.get(Calendar.YEAR)
        menit = cal.get(Calendar.MINUTE)
    }

    private fun pickDate() {
        val showButton: Button = findViewById(R.id.btndate)
        showButton.setOnClickListener {
            getTimeCalendar()
            DatePickerDialog(this, this, tahun, bulan, hari).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        spntahun = year
        spnbulan = month
        spnhari = dayOfMonth


        getTimeCalendar()
        TimePickerDialog(this, this, jam, menit, true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        // Simpan waktu yang dipilih oleh pengguna
        spnjam = hourOfDay
        spnmenit = minute

        val textView: TextView = findViewById(R.id.txt_tv)
        textView.text = "$spnhari/$spnbulan/$spntahun $spnjam:$spnmenit"


    }
}