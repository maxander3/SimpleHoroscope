package droid.maxaria.maxander.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "predicts", primaryKeys = ["date","sign"])
data class ForecastModel(
    @ColumnInfo val date: String,
    @ColumnInfo val horoscope: String,
    @ColumnInfo val sign: String
):Serializable