package it.giobalda.notesapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.viewbinding.ViewBinding
import it.giobalda.notesapp.R
import it.giobalda.notesapp.models.note.NoteViewModel

/**
 * [BaseFragment]
 * Simple fragment with some shortcuts to be used by its child classes
 */
abstract class BaseFragment : Fragment() {

    //all implementation must implement it
    protected abstract val binding: ViewBinding

    /**
     * View model with navigation graph scope
     * It will be shared among all [BaseFragment] instances
     * Delegate creation of [noteViewModel] using Android navigation
     */
    val noteViewModel: NoteViewModel by navGraphViewModels(R.id.nav_graph_xml)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

}