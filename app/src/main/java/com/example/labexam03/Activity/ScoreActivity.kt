package com.example.labexam03.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labexam03.R
import com.example.labexam03.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    var score:Int =0
    lateinit var binding:ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        score = intent.getIntExtra("Score", 0)

        binding.apply {
            scoreTxt.text=score.toString()
            backBtn.setOnClickListener {
                startActivity(Intent(this@ScoreActivity,MainActivity::class.java))
                finish()
            }
        }
    }
}