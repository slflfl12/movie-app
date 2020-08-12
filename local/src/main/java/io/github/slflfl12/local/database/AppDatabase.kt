package io.github.slflfl12.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.slflfl12.local.converter.*
import io.github.slflfl12.local.dao.MovieDao
import io.github.slflfl12.local.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 3, exportSchema = true)
@TypeConverters(
    value = [IntegerListConverter::class, KeywordListConverter::class, ReviewListConverter::class,
        StringListConverter::class, VideoListConverter::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}