package com.youtube.oraxtechassignment.retrofit
import com.youtube.oraxtechassignment.model.PostModel
import retrofit2.http.GET

interface ApiService {
   @GET("posts")
  suspend fun getPost():List<PostModel>
}