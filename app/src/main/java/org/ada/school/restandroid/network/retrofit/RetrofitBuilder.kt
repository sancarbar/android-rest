package org.ada.school.restandroid.network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.artic.edu/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}