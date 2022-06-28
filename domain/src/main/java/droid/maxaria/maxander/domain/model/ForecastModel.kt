package droid.maxaria.maxander.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "predicts")
data class ForecastModel(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val date: String,
    @ColumnInfo val horoscope: String,
    @ColumnInfo val sign: String
)