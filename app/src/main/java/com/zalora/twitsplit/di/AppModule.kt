package com.zalora.twitsplit.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.zalora.twitsplit.MyApplication
import com.zalora.twitsplit.db.TwitDao
import com.zalora.twitsplit.db.TwitDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesContext(application: MyApplication): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideDb(app: MyApplication): TwitDb {
        return Room .databaseBuilder(app, TwitDb::class.java, "twitdb.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideTwitDao(db: TwitDb): TwitDao {
        return db.twitDao()

    }
}