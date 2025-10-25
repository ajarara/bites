package io.ajarara.bites.bootstrap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.ajarara.bites.bootstrap.R
import io.ajarara.bites.bootstrap.databinding.FragmentDirectoryBinding
import io.ajarara.bites.septa.SeptaFragment

class DirectoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_directory, container, false)

        val binding = FragmentDirectoryBinding.inflate(inflater)
        binding.septa.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main, SeptaFragment())
                .addToBackStack(null)
                .commit()
        }
        return binding.root
    }
}