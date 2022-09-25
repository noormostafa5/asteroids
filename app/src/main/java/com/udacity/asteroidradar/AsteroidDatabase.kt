package com.udacity.asteroidradar

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import java.util.jar.Attributes


@Database(version = 1, entities = [Asteroid::class])
abstract class AsteroidDatabase : RoomDatabase() {

    abstract val dao: AsteroidDao

    companion object{
        @Volatile
        private lateinit var instance: AsteroidDatabase

        fun getInstance(context: Context): AsteroidDatabase{
            synchronized(AsteroidDatabase::class.java){
                if (!::instance.isInitialized){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AsteroidDatabase::class.java,
                        "AsteroidsDatabase").build()

                }
            }
            return instance
        }
    }

}

