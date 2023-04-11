package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var checkBox: CheckBox
    lateinit var switchButton: Switch
    lateinit var saveButton: Button
    lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name_edittext)
        checkBox = findViewById(R.id.checkBox)
        switchButton = findViewById(R.id.switch_button)
        saveButton = findViewById(R.id.save_button)
        loadButton = findViewById(R.id.load_button)

        val sharedPref = this.getPreferences(MODE_PRIVATE)

        saveButton.setOnClickListener {
            sharedPref.edit().apply {
                putString("name", name.text.toString())
                putBoolean("internet", checkBox.isChecked)
                putBoolean("on_or_off", switchButton.isChecked)
                apply()
            }
        }

        loadButton.setOnClickListener {
            val sharedPref = this.getPreferences(MODE_PRIVATE)
            name.setText(sharedPref.getString("name", "No Name Given"))
            checkBox.isChecked = sharedPref.getBoolean("internet", false)
            switchButton.isChecked = sharedPref.getBoolean("on_or_off", false)
        }
    }
}