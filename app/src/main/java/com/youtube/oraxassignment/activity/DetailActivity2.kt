package com.youtube.oraxassignment.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.youtube.oraxassignment.databinding.ActivityDetail2Binding
import com.youtube.oraxtechassignment.util.Constant

class DetailActivity2 : AppCompatActivity() {
    lateinit var  binding: ActivityDetail2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityDetail2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getDataValue()
    }
    private  fun getDataValue(){
        val title=intent.getStringExtra(Constant.TITLE)
        val description=intent.getStringExtra(Constant.DESCRIPTION)
        binding.titleTv.text="Title: ${title}"
        binding.descriptionTv.text="Description: ${description}"
    }
}