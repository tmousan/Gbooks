package com.tmousan.gbooks.data.local.db

import android.content.Context
import androidx.room.*
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo

@Database(entities = [Item::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BookDatabase: RoomDatabase() {

    abstract fun getBookDao(): BookDao

    companion object{

        @Volatile
        private var instance: BookDatabase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock){
            instance ?: createdDatabase(context).also { bookDatabase ->
                instance = bookDatabase }
        }

        private fun createdDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, BookDatabase::class.java, "testbook_db.db"
            ).build()

    }
}