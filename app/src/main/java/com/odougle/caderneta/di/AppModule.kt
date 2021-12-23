package com.odougle.caderneta.di

import android.app.Application
import androidx.room.Room
import com.odougle.caderneta.features.data.data_source.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : Database{
        return Room.databaseBuilder(
            app,
            Database::class.java,
            Database.DATABASE_NAME
        ).build()
    }
}