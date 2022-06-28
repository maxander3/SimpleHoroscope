package droid.maxaria.maxander.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import droid.maxaria.maxander.domain.model.ForecastModel

@Database(entities = [ForecastModel::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getRoomDao(): PredictDao
}