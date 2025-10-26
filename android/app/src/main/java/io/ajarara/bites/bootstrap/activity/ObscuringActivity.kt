package io.ajarara.bites.bootstrap.activity

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import io.ajarara.bites.bootstrap.databinding.ActivityObscuringBinding

// trigger on pause but not on stop
class ObscuringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityObscuringBinding.inflate(layoutInflater)
        binding.btnClose.setOnClickListener { finish() }
        setContentView(binding.root)
    }
}