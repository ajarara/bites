package io.ajarara.bites.bootstrap.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.ajarara.bites.bootstrap.R
import io.ajarara.bites.bootstrap.activity.MainActivity
import io.ajarara.bites.bootstrap.activity.ObscuringActivity
import io.ajarara.bites.bootstrap.databinding.FragmentDirectoryBinding
import io.ajarara.bites.bootstrap.foreground.ReentryService
import io.ajarara.bites.septa.SeptaFragment

class DirectoryFragment : Fragment() {

    private var context: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }

    override fun onDetach() {
        super.onDetach()
        this.context = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDirectoryBinding.inflate(inflater)
        binding.recur.setOnClickListener {
            context?.let {
                it.startActivity(
                    Intent(it, MainActivity::class.java)
                )
            }
        }
        binding.septa.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main, SeptaFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.obscuring.setOnClickListener {
            context?.let {
                val transition = Intent(it, ObscuringActivity::class.java)
                it.startActivity(transition)
            }
        }

        binding.service.setOnClickListener {
            context?.let {
                val serviceIntent = Intent(it, ReentryService::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    println("Ahmad startForegroundService")
                    it.startForegroundService(
                        serviceIntent
                    )
                } else {
                    println("Ahmad startService")
                    it.startService(serviceIntent)
                }
            }
        }
        return binding.root
    }
}