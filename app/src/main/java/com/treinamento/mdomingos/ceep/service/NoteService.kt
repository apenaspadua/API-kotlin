package com.treinamento.mdomingos.ceep.service

import com.treinamento.mdomingos.ceep.model.Note
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by Matheus de Padua on 05/04/2019.
 * mdomingos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
interface NoteService {

        @GET("notes")
        fun list(): Call<List<Note>>
}



