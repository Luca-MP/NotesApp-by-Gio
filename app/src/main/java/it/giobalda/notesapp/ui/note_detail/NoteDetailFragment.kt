package it.giobalda.notesapp.ui.note_detail

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import it.giobalda.notesapp.databinding.FragmentNoteDetailBinding
import it.giobalda.notesapp.ui.base.BaseFragment

class NoteDetailFragment : BaseFragment() {

    override val binding by lazy {
        FragmentNoteDetailBinding.inflate(layoutInflater)
    }

    private val args by navArgs<NoteDetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupView()
    }

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
    }
}