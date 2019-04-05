package com.treinamento.mdomingos.ceep.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.treinamento.mdomingos.ceep.R
import com.treinamento.mdomingos.ceep.model.Note
import kotlinx.android.synthetic.main.note_item.view.*

class NoteListAdapter(private val notes: List<Note>,
                      private val context: Context) : Adapter<NoteListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder?.let {
            it.bindView(note)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Note) {
            val title = itemView.note_item_title
            val description = itemView.note_item_description

            title.text = note.title
            description.text = note.description
        }

    }

}