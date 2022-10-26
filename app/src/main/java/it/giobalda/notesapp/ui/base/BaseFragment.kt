package it.giobalda.notesapp.ui.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.viewbinding.ViewBinding
import it.giobalda.notesapp.R
import it.giobalda.notesapp.models.note.NoteViewModel
import timber.log.Timber
import kotlin.Exception

/**
 * [BaseFragment]
 * Simple fragment with some shortcuts to be used by its child classes
 */
abstract class BaseFragment : Fragment() {

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

    override fun onPause() {
        super.onPause()

        closeKeyboard()
    }

    /**
     * Avoid bad route exception
     */
    fun NavDirections.go() {
        try {
            findNavController().navigate(this)
        } catch (ex: Exception) {
            Timber.d("Bad route")
        }
    }

    fun goBack() {
        findNavController().navigateUp()
    }

    private fun closeKeyboard() {
        val inputMethodManager =
            requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}