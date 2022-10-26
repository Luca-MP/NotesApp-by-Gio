package it.giobalda.notesapp.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import it.giobalda.notesapp.databinding.ItemNoteBinding
import it.giobalda.notesapp.models.note.Note
import it.giobalda.notesapp.ui.main.view_holders.NoteViewHolder

/**
 * [NoteAdapter]
 *
 * Adapts a notes list to the [NoteViewHolder] UI
 * Uses [NoteCallback] to update the list with minimum GPU cost -> great performance
 */

class NoteAdapter(
    val onClick: ((Note) -> Unit)? = null,
    val onLongClick: ((Note) -> Unit)? = null,
) : ListAdapter<Note, NoteViewHolder>(NoteCallback()) {

    //creation of single viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context)
            ),
            onClick = {
                onClick?.invoke(it)
            },
            onLongClick = {
                onLongClick?.invoke(it)
            }
        )

    /**
     * Called every time an item is updated or recycled
     * - [holder] will bind view to data (first time)
     * - [holder] will recycle view with new data (on recycle)
     */
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    /**
     * When data changes, it calculates the difference between old and new list
     * to update the UI with minimum cost
     */
    class NoteCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem
    }
}