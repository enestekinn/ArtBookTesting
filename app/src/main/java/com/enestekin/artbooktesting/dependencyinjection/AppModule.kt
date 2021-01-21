package com.enestekin.artbooktesting.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.enestekin.artbooktesting.R
import com.enestekin.artbooktesting.api.RetrofitApi
import com.enestekin.artbooktesting.repo.ArtRepository
import com.enestekin.artbooktesting.repo.ArtRepositoryInterface
import com.enestekin.artbooktesting.roomdb.ArtDao
import com.enestekin.artbooktesting.roomdb.ArtDatabase
import com.enestekin.artbooktesting.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

@Singleton
@Provides
    fun injectRoomDatabase(@ApplicationContext context : Context) =
            Room.databaseBuilder(
                    context,
                    ArtDatabase::class.java,
                    "ArtBookDB").build()

@Singleton
@Provides
fun injectDao(database: ArtDatabase) = database.artDao()

    @Singleton
    @Provides
    fun injectRetrofitAPI() : RetrofitApi {

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(RetrofitApi::class.java)
    }

    @Singleton
    @Provides
    fun injectNormalRepo(dao : ArtDao , api : RetrofitApi) = ArtRepository(dao,api) as ArtRepositoryInterface

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide.with(context)
            .setDefaultRequestOptions(
                    RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                            .error(R.drawable.ic_launcher_foreground)

            )

}