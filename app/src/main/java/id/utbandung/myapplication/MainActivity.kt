package id.utbandung.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txt1: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txt1 = findViewById(R.id.txt1)
        button = findViewById(R.id.button)

        txt1.text = "Halo EUY"
        button.setOnClickListener{
            val intentDestination = Intent(this@MainActivity,MainActivity2::class.java)
            //intentDestination.putExtra(MainActivity2.EXTRA_DATA,"Hello Ngabs")
            intentDestination.putExtra(MainActivity2.EXTRA_DATA,mahasewa("Jajang","22521903"))
            startActivity(intentDestination)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}