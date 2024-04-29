package id.utbandung.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val showButton: Button = findViewById(R.id.btnshow)
        showButton.setOnClickListener{
            showAlertDialog()
        }
    }
    private fun showAlertDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Aquma")
            .setMessage("Uninstall Aplikasi? ")
            .setPositiveButton("yes"){ dialog, which ->
            Toast.makeText(this,"Aplikasi Berhasil di Uninstall",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("no"){dialog, which ->
                dialog.dismiss()
            }
        val alertDialog: AlertDialog=builder.create()
        alertDialog.show()
    }
}