package com.example.q3

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
//global variable
        var flag : String = "sum"
//here .. create a spinner items (options)
        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("add","subtract","multiply","divide")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
//code here
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            resultTV.text = when(flag){
                "add" -> add(x,y).toString()
                "subtract" -> subtract(x,y).toString()
                "multiply" -> multiply(x,y).toString()
                else -> divide(x,y).toString()
            }
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                flag = options.get(p2) //p2 is the index of selected item
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle.getString("key")
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }


        }
}
public fun add(a: Int, b: Int): Int {
    return a+b
}
public fun subtract(a: Int, b: Int): Int {
    return a-b
}
public fun multiply(a: Int, b: Int): Int {
    return a*b
}
public fun divide(a: Int, b: Int): Double {
    return a.toDouble()/b.toDouble()
}