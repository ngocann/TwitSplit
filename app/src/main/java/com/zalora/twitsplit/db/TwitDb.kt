package com.zalora.twitsplit.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.zalora.twitsplit.model.Twit

@Database(
        entities = [
            Twit::class],
        version = 1,
        exportSchema = false)
abstract class TwitDb : RoomDatabase() {
    abstract fun twitDao(): TwitDao
}