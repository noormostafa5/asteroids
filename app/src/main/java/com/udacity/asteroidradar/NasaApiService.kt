package com.udacity.asteroidradar

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.nasa.gov/planetary/apod?api_key=uS4bCFkpLmxfp696j047ruhZvfbQMXsko3lNzzLK"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object NasaApiService {
    val retrofitService : NasaApiService by lazy {
        retrofit.create(NasaApiService::class.java)

    }
}
interface NasaApi {
    @GET("Asteroids")
    fun getAsteroids():
            Call<String>
}
