package com.udacity.asteroidradar

import androidx.lifecycle.LiveData
import androidx.room.*
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.AsteroidDatabase


@Dao
interface AsteroidDao {

    @Query("SELECT * from Asteroid  Order by closeApproachDate")
    fun getAll(): LiveData<List<Asteroid>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(asteroids: List<Asteroid>)



}