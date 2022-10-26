package it.giobalda.notesapp.ui.new_note

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import it.giobalda.notesapp.R
import it.giobalda.notesapp.databinding.FragmentNewNoteBinding
import it.giobalda.notesapp.models.note.Note
import it.giobalda.notesapp.models.note.NoteType
import it.giobalda.notesapp.ui.base.BaseFragment
import it.giobalda.notesapp.utils.system.cap
import it.giobalda.notesapp.utils.system.low
import it.giobalda.notesapp.utils.ui.showToast

class NewNoteFragment : BaseFragment() {

    override val binding by lazy {
        FragmentNewNoteBinding.inflate(layoutInflater)
    }

    val noteTypes = NoteType.values()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.apply {

            //Lower case, then cap
            val typeNames = noteTypes.map { it.name.low().cap() }

            //show note types
            spinnerType.adapter = ArrayAdapter(
                requireContext(),
                R.layout.tv_note_type,
                typeNames
            )

            //set background color based on note type
            spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val colorId = noteTypes[position].colorId

                    binding.relativeLayout.setBackgroundColor(
                        requireContext().getColor(
                            colorId
                        )
                    )

                    binding.spinnerType.setPopupBackgroundResource(
                        colorId
                    )
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}

            }

            //save
            btnSave.setOnClickListener {
                val noteText = etText.text.toString()

                if (noteText.isNotBlank()) { //valid note
                    noteViewModel.addToList(
                        Note(
                            text = noteText,
                            type = noteTypes[spinnerType.selectedItemPosition]
                        )
                    )

                    //exit
                    goBack()
                } else { //invalid -> show error
                    requireContext().showToast(
                        getString(R.string.empty_note_error)
                    )
                }
            }
        }
    }
}