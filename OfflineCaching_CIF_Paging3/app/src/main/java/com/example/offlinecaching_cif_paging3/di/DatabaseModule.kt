package com.example.offlinecaching_cif_paging3.di

import android.content.Context
import androidx.room.Room
import com.example.offlinecaching_cif_paging3.Constants.RESTAURANT_DATABASE
import com.example.offlinecaching_cif_paging3.paging.db.RestaurantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): RestaurantDatabase {
        return Room.databaseBuilder(
            context,
            RestaurantDatabase::class.java,
            RESTAURANT_DATABASE
        ).build()
    }


    @Provides
    fun provideRestaurantDao(database: RestaurantDatabase) = database.restaurantDao()

    @Provides
    fun provideRestaurantRemoteKeysDao(database: RestaurantDatabase) =
        database.restaurantRemoteKeysDao()


}