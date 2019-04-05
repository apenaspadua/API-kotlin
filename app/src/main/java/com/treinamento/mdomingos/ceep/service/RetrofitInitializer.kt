package com.treinamento.mdomingos.ceep.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Matheus de Padua on 05/04/2019.
 * mdomingos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://your_ip:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun noteService() = retrofit.create(NoteService::class.java)


}