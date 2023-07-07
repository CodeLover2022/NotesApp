package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.databinding.ActivityUpdateNoteBinding

class UpdateNote : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val id=intent.getIntExtra("id")
        val title=intent.getStringExtra("title")
        val note=intent.getStringExtra("note")



    }
}