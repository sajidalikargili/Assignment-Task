package com.youtube.oraxtechassignment.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.youtube.oraxassignment.databinding.RecyclerviewRowItemBinding
import com.youtube.oraxtechassignment.model.PostModel


class PostAdapter(private val postlist:List<PostModel>,
                  private val onItemClick:(PostModel)->Unit
    ): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
inner class PostViewHolder(private val binding: RecyclerviewRowItemBinding ):RecyclerView.ViewHolder(binding.root){
    fun bind(postModel: PostModel){
        binding.titleTv.text= "Title: ${postModel.title}"
        binding.descriptionTv.text= "Description: ${postModel.title}"
        itemView.setOnClickListener {
           onItemClick(postModel)
        }
    }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding=RecyclerviewRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
      return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postlist[position])
    }
}