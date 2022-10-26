package it.giobalda.notesapp.ui.main

import android.os.Bundle
import androidx.core.view.isVisible
import it.giobalda.notesapp.R
import it.giobalda.notesapp.databinding.FragmentMainBinding
import it.giobalda.notesapp.models.note.Note
import it.giobalda.notesapp.ui.base.BaseFragment
import it.giobalda.notesapp.ui.main.adapters.NoteAdapter
import it.giobalda.notesapp.utils.system.cap
import it.giobalda.notesapp.utils.system.low
import it.giobalda.notesapp.utils.ui.showAlert

class MainFragment : BaseFragment() {

    override val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val noteAdapter: NoteAdapter = NoteAdapter(
        onClick = {
            showNoteDetail(it)
        },
        onLongClick = {
            showRemovalAlert(it)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupView()
        setupObservers()
    }

    private fun setupView() {
        binding.recyclerNotes.adapter = noteAdapter

        //open new note view
        binding.btnNewNote.setOnClickListener {
            MainFragmentDirections.toNewNote(
                title = getString(R.string.new_note)
            ).go()
        }
    }

    private fun setupObservers() {
        noteViewModel.allNotes.observe(this) {
            //show view in case of empty list
            binding.emptyListView.root.isVisible = it.isEmpty()

            noteAdapter.submitList(it)
        }
    }

    //open detail
    private fun showNoteDetail(note: Note) {
        val stringType = note.type.name.low().cap()
        val title = getString(R.string.type_note_header, stringType)

        MainFragmentDirections.openNoteDetail(
            title, note
        ).go()
    }

    private fun showRemovalAlert(note: Note) {
        requireContext().showAlert(
            title = getString(R.string.remove_note_title),
            message = getString(R.string.remove_note_message),
            cancelable = true,
            onPositiveCallback = {
                noteViewModel.delete(note)
            }
        )
    }

}