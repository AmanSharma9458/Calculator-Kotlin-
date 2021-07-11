package com.example.android.calculatoractive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.calculatoractive.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var isSwitch:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.makeSwitch.setOnClickListener{
            if(isSwitch)
            {
                binding.mainConstraint.setBackgroundResource(R.color.black);
                binding.inputtext.setBackgroundResource(R.color.black);
                binding.outputtext.setBackgroundResource(R.color.black);
                isSwitch=false
            }
            else
            {
                binding.mainConstraint.setBackgroundResource(R.color.yellow);
                binding.inputtext.setBackgroundResource(R.color.lightGreen);
                binding.outputtext.setBackgroundResource(R.color.lightGreen);
                isSwitch=true
            }
        }

        binding.btnAc.setOnClickListener {
            binding.inputtext.text = ""
            binding.outputtext.text = ""
        }
        binding.btn0.setOnClickListener {
            binding.inputtext.append("0")
        }
        binding.btn1.setOnClickListener {
            binding.inputtext.append("1")
        }
        binding.btn2.setOnClickListener {
            binding.inputtext.append("2")
        }
        binding.btn3.setOnClickListener {
            binding.inputtext.append("3")
        }
        binding.btn4.setOnClickListener {
            binding.inputtext.append("4")
        }
        binding.btn5.setOnClickListener {
            binding.inputtext.append("5")
        }
        binding.btn6.setOnClickListener {
            binding.inputtext.append("6")
        }
        binding.btn7.setOnClickListener {
            binding.inputtext.append("7")
        }
        binding.btn8.setOnClickListener {
            binding.inputtext.append("8")
        }
        binding.btn9.setOnClickListener {
            binding.inputtext.append("9")
        }
        binding.btnDivide.setOnClickListener {
            binding.inputtext.append("/")
        }
        binding.btnMultiplication.setOnClickListener {
            binding.inputtext.append("*")
        }
        binding.btnPlus.setOnClickListener {
            binding.inputtext.append("+")
        }
        binding.btnMinus.setOnClickListener {
            binding.inputtext.append("-")
        }
        binding.btnStartBracket.setOnClickListener {
            binding.inputtext.append("(")
        }
        binding.btnEndBracket.setOnClickListener {
            binding.inputtext.append(")")
        }
        binding.btnDot.setOnClickListener {
            binding.btnDot.animate().apply {
                duration=1000
                binding.btnDot.scaleX=2F
                binding.btnDot.scaleY=2F
            }
            binding.btnDot.scaleX=1F
            binding.btnDot.scaleY=1F
            binding.inputtext.append(".")
        }
        binding.btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()
                if (result == longresult.toDouble()) {
                    binding.outputtext.text = longresult.toString()
                } else {
                    binding.outputtext.text = result.toString()
                }
            }
            catch(e: Exception){
                  binding.outputtext.text="Undefined!"
            }
        }


    }

    fun clickedMe(view: View) {}
}