package it.giobalda.notesapp.ui.main.view_holders

import androidx.recyclerview.widget.RecyclerView
import it.giobalda.notesapp.databinding.ItemNoteBinding
import it.giobalda.notesapp.models.note.Note

class NoteViewHolder(
    private val binding: ItemNoteBinding,
    val onClick: (Note) -> Unit,
    val onLongClick: (Note) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var note: Note

    init {
        itemView.setOnClickListener {
            onClick(note)
        }

        itemView.setOnLongClickListener {
            onLongClick(note)
            true
        }
    }

    fun bind(note: Note) {
        this.note = note

        val (_, text, type) = note

        binding.tvText.text = text

        //color based on note type
        binding.root.setCardBackgroundColor(
            itemView.context.getColor(type.colorId)
        )
    }
}