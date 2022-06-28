package droid.maxaria.maxander.simplehoroscope.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import droid.maxaria.maxander.data.RepositoryImpl
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.data.database.AppRoomDatabase
import droid.maxaria.maxander.data.database.PredictDao
import droid.maxaria.maxander.domain.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun provideRepository(apiProvider: ApiProvider,dao: PredictDao):Repository {
        return RepositoryImpl(apiProvider = apiProvider, predictDao = dao)
    }
    @Provides
    fun provideDao(appRoomDatabase: AppRoomDatabase): PredictDao {
        return appRoomDatabase.getRoomDao()
    }
    @Provides
    @Singleton
    fun provideAppRoomDatabase(@ApplicationContext context: Context):AppRoomDatabase{
        return Room.databaseBuilder(context,AppRoomDatabase::class.java,"PredictDatabase").build()
    }
}