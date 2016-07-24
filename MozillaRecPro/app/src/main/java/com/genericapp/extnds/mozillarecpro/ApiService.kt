package com.genericapp.extnds.mozillarecpro

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Nooba(PratickRoy) on 07-07-2016.
 */

interface ApiService {
    @GET("test.php/?tablename=shakestable")
    fun itemQuery(): Call<Table>

}


