package com.treinamento.mdomingos.ceep

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.treinamento.mdomingos.ceep.adapter.NoteListAdapter
import com.treinamento.mdomingos.ceep.model.Note
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val recyclerView = note_list_recyclerview
        recyclerView.adapter = NoteListAdapter(notes(), this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }

    private fun notes(): List<Note>{
        return listOf(Note("Leitura", "Livro de Kotlin com Android"),
                      Note("Pesquisa","Como posso melhorar o código dos meus projetos"),
                      Note("Estudo","Como sincronizar minha App com Web Service")
        )
    }
}
