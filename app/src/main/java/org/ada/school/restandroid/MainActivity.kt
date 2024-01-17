package org.ada.school.restandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.ada.school.restandroid.network.dto.ArtWorkResponse
import org.ada.school.restandroid.network.retrofit.ArtInstituteOfChicagoService
import org.ada.school.restandroid.network.retrofit.RetrofitBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            testRestApi()
        }
    }

    private suspend fun testRestApi() {
        val retrofitBuilder = RetrofitBuilder()
        val retrofit = retrofitBuilder.getRetrofit()
        val service = retrofit.create(ArtInstituteOfChicagoService::class.java)
        service.getArtWorks(1, 10).body()?.let { artWorkResponse: ArtWorkResponse ->
            Log.d("MainActivity", "ArtWorkResponse: $artWorkResponse")
        }

    }
}