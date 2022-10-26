package it.giobalda.notesapp.ui.note_detail

import it.giobalda.notesapp.databinding.FragmentNoteDetailBinding
import it.giobalda.notesapp.ui.base.BaseFragment

class NoteDetailFragment : BaseFragment() {

    override val binding by lazy {
        FragmentNoteDetailBinding.inflate(layoutInflater)
    }

    //private val args by navArgs<NoteDetailFragmentArgs>()

    /*
    private fun setupView() {
        val (_, text, type) = args.note

        binding.apply {
            tvText.text = text

            cardView.setCardBackgroundColor(
                requireContext().getColor(
                    type.colorId
                )
            )
        }
    }*/
}