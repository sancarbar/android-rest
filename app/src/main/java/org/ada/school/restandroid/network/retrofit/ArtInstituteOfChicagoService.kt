package org.ada.school.restandroid.network.retrofit

import org.ada.school.restandroid.network.dto.ArtWorkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtInstituteOfChicagoService {

    //https://api.artic.edu/api/v1/artworks?page=1&limit=10

    @GET("artworks")
    suspend fun getArtWorks(@Query("page") page: Int, @Query("limit") limit: Int):
            Response<ArtWorkResponse>
}