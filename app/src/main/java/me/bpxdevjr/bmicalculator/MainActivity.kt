package me.bpxdevjr.bmicalculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etweight: EditText = findViewById(R.id.etweight)
        var etheight: EditText = findViewById(R.id.etheight)
        var btncalculate: Button = findViewById(R.id.btncalculate)
        var txtresult: TextView = findViewById(R.id.txtresult)

        btncalculate.setOnClickListener {
            if (!etweight.text.isEmpty() || !etheight.text.isEmpty()) {

                var weight: Float = etweight.text.toString().toFloat()
                var height: Float = etheight.text.toString().toFloat() / 100

                var result: Float = weight / (height * height)

                when {
                    result < 18.5 -> txtresult.text = "Your BMI is: $result\nCategory: Underweight"
                    result < 25.0 -> txtresult.text =
                        "Your BMI is: $result\nCategory: Normal weight"

                    result < 30.0 -> txtresult.text = "Your BMI is: $result\nCategory: Overweight"
                    else -> txtresult.text = "Your BMI is: $result\nCategory: Obese"
                }
            } else {
                
                txtresult.text = "Please fill out the two fields with proper numbers"
            }


        }

    }

}