package com.genericapp.extnds.mozillarecpro

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Nooba(PratickRoy) on 07-07-2016.
 */
const val API_URL = "http://deliverit.co.in/"
val retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
val apiService = retrofit.create(ApiService::class.java)