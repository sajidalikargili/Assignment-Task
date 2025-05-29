package com.youtube.oraxassignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.youtube.oraxassignment.activity.DetailActivity2
import com.youtube.oraxassignment.databinding.ActivityMainBinding
import com.youtube.oraxtechassignment.adapter.PostAdapter
import com.youtube.oraxtechassignment.model.PostModel
import com.youtube.oraxtechassignment.util.Constant
import com.youtube.oraxtechassignment.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: PostViewModel
    lateinit var  binding: ActivityMainBinding
    lateinit var postAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this)[PostViewModel::class.java]
        viewModel.getPost()
        getResponce(viewModel)
    }
    private fun getResponce(viewModel: PostViewModel) {
        viewModel.post.observe(this){posts->
            setAdapter(posts)
        }
    }

    private fun setAdapter(posts: List<PostModel>){
        postAdapter= PostAdapter(posts){ postModel ->
            Log.d("PostModel","get PostModel{$postModel}")
            var intent= Intent(this, DetailActivity2::class.java)
            intent.putExtra(Constant.TITLE,postModel.title)
            intent.putExtra(Constant.DESCRIPTION,postModel.body)
            startActivity(intent)
        }
        setRecyclerView(postAdapter)
    }

    private  fun setRecyclerView(postAdapter:PostAdapter){

        binding.reyclerView.layoutManager= LinearLayoutManager(this)
        binding.reyclerView.adapter=postAdapter
    }
}