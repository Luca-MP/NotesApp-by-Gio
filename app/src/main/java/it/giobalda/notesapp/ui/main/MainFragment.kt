package it.giobalda.notesapp.ui.main

import android.os.Bundle
import androidx.core.view.isVisible
import com.google.android.material.card.MaterialCardView
import it.giobalda.notesapp.R
import it.giobalda.notesapp.databinding.FragmentMainBinding
import it.giobalda.notesapp.databinding.ItemNoteBinding
import it.giobalda.notesapp.models.note.Note
import it.giobalda.notesapp.ui.base.BaseFragment
import it.giobalda.notesapp.utils.system.cap
import it.giobalda.notesapp.utils.system.low
import it.giobalda.notesapp.utils.ui.showAlert

class MainFragment : BaseFragment() {

    override val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupView()
        setupObservers()
    }

    private fun setupView() {
        //TODO: open new not on btn click
    }

    private fun setupObservers() {
        noteViewModel.allNotes.observe(this) { notesList ->
            binding.llNotes.removeAllViews()

            notesList.forEach { note ->
                val noteView = buildNoteView(note)
                binding.llNotes.addView(noteView)
            }

            binding.emptyListView.root.isVisible = notesList.isEmpty()
        }
    }

    /**
     * Builds note view [MaterialCardView] using [note] data
     * Then sets click listener and longClick listener
     */
    private fun buildNoteView(note: Note): MaterialCardView {
        val noteBinding = ItemNoteBinding.inflate(layoutInflater).apply {
            tvText.text = note.text

            //set color based on note type
            root.setCardBackgroundColor(
                requireContext().getColor(note.type.colorId)
            )

            //TODO: open note detail on click
            //TODO: remove note on long click
        }

        return noteBinding.root
    }

    //open detail
    private fun showNoteDetail(note: Note) {
        val stringType = note.type.name.low().cap()
        val title = getString(R.string.type_note_header, stringType)
    }

    private fun showRemovalAlert(note: Note) {
        requireContext().showAlert(
            title = getString(R.string.remove_note_title),
            message = getString(R.string.remove_note_message),
            cancelable = true,
            onPositiveCallback = {
                noteViewModel.removeFromList(note)
            }
        )
    }

}