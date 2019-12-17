package com.gyosanila.mymoviejetpack.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.TvShowItem

/**
 * Created by ilgaputra15
 * on Sunday, 24/11/2019 22:37
 * Division Mobile - PT.Homecareindo Global Medika
 **/

@Database(entities = [MovieItem::class, TvShowItem::class], version = 1)
abstract class MyMovieRoomDatabase : RoomDatabase() {

    abstract fun movieDao(): MyMovieDao

    companion object {

        @Volatile
        private var INSTANCE: MyMovieRoomDatabase? = null

        fun getDatabase(context: Context): MyMovieRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyMovieRoomDatabase::class.java,
                    "my_movie_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}
