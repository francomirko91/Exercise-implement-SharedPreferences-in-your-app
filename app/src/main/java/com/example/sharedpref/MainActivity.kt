package com.example.sharedpref

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpref.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var tvName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvName = binding.tvName


        binding.btn.setOnClickListener {

            val enteredText = binding.editText.text.toString()
            saveNameInSharedPref(enteredText)

        }
        displaySavedName()
    }

    private fun saveNameInSharedPref(enteredText: String) {

        //Opening the Shared Pref
        val sharedPref: SharedPreferences = getSharedPreferences("UserName", MODE_PRIVATE)

        //Writing data to Shared Pref
        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putString("name", enteredText)
        editor.commit()
    }

    //Reading data from Shared Pref
    private fun displaySavedName () {
        val sharedPreferences : SharedPreferences = getSharedPreferences("UserName", MODE_PRIVATE)

        var s1 : String? = sharedPreferences.getString("name","")
        tvName.text = s1

    }

}