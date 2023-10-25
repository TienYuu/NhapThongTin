package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var rgbtn : Button
    private lateinit var rg : RadioGroup
    private lateinit var firstname : EditText
    private lateinit var lastname :EditText
    private lateinit var birthday : EditText
    private lateinit var address : EditText
    private lateinit var email : EditText
    private lateinit var checkbox : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint)
         rgbtn  = findViewById(R.id.regisBtn)
         rg  = findViewById(R.id.radioGroup)
         firstname  = findViewById(R.id.firstname)
         lastname  = findViewById(R.id.lastname)
        birthday  = findViewById(R.id.birthday)
         address  = findViewById(R.id.address)
        email  = findViewById(R.id.email)
        checkbox  = findViewById(R.id.checkBox)
        rgbtn.setOnClickListener() {
            if(!checkempty()) {
                Toast.makeText(this,"Vẫn còn ô chưa nhập",Toast.LENGTH_LONG).show()
            }
            else {
                if (!checkbox.isChecked) {
                    Toast.makeText(this,"Hãy đồng ý điều khoản sử dụng",Toast.LENGTH_LONG).show()
                }
                else {
                    if(checkDateFormat(birthday.text.toString()))
                    {Toast.makeText(this,"Nhập thành công",Toast.LENGTH_LONG).show()}
                    else {
                        Toast.makeText(this,"Nhập sai định dạng ngày",Toast.LENGTH_LONG).show()
                    }
                }
            }



        }
    }
    private  fun checkempty (): Boolean {
        if (rg.getCheckedRadioButtonId() == -1)
        {
            return false;
        }
        if (TextUtils.isEmpty(firstname.text.toString())) {
            return false;
        }
        if (TextUtils.isEmpty(lastname.text.toString())) {
            return false;
        }

        if (TextUtils.isEmpty(birthday.text.toString())) {
            return false;
        }

        if (TextUtils.isEmpty(address.text.toString())) {
            return false;
        }
        if (TextUtils.isEmpty(email.text.toString())) {
            return false;
        }
        return true
    }
    fun checkDateFormat(date: String): Boolean { // Kiểm tra định dạng xâu
        if (date.length != 10) {
            return false
        }
        for (i in 0 until 10) {
            if (i == 4 || i == 7) {
                if (date[i] != '/') {
                    return false
                }
            } else {
                if (!date[i].isDigit()) {
                    return false
                }
            }
        }
        return true
    }
}