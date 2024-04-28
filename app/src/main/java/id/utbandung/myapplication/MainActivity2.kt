package id.utbandung.myapplication

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    private lateinit var txt1: TextView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        txt1 = findViewById(R.id.txt1)
        val mahasewa =if(Build.VERSION.SDK_INT>=33){
            intent.getParcelableExtra(EXTRA_DATA, mahasewa::class.java)
        }
        else{
            @Suppress("DEPRECIATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }
        if(mahasewa!=null){
            txt1.text = mahasewa.name
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}