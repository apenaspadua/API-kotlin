package com.treinamento.mdomingos.ceep

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.telecom.Call
import android.util.Log
import com.treinamento.mdomingos.ceep.adapter.NoteListAdapter
import com.treinamento.mdomingos.ceep.model.Note
import com.treinamento.mdomingos.ceep.service.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_note_list.*
import retrofit2.Response
import javax.security.auth.callback.Callback

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val call = RetrofitInitializer().noteService().list()

        call.enqueue(object : Callback<List<Note>?> {
            override fun onResponse(call: Call<List<Note>?>?,
                                    response: Response<List<Note>?>?) {
                response?.body()?.let {
                    val notes: List<Note> = it
                    configureList(notes)
                }
            }

            override fun onFailure(call: Call<List<Note>?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    private fun configureList(notes: List<Note>) {
        val recyclerView = note_list_recyclerview
        recyclerView.adapter = NoteListAdapter(notes, this)
        val layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

}

