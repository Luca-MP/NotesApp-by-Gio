package it.giobalda.notesapp.ui.main

import it.giobalda.notesapp.databinding.FragmentMainBinding
import it.giobalda.notesapp.ui.base.BaseFragment

class MainFragment : BaseFragment() {

    override val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }
}