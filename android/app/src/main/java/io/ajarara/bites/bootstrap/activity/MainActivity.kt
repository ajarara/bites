package io.ajarara.bites.bootstrap.activity

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import dagger.hilt.android.AndroidEntryPoint
import io.ajarara.bites.bootstrap.R
import io.ajarara.bites.bootstrap.fragment.DirectoryFragment
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myView = findViewById<FrameLayout>(R.id.inset_protection)

        ViewCompat.setOnApplyWindowInsetsListener(myView) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.updatePadding(
                left = insets.left,
                top = insets.top,
                right = insets.right,
                bottom = insets.bottom
            )

            WindowInsetsCompat.CONSUMED
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.main, DirectoryFragment())
            .commitNow()
    }

    override fun onPause() {
        super.onPause()
        println("Ahmad $this#onPause")
    }

    override fun onStop() {
        super.onStop()
        println("Ahmad $this#onStop")
    }

    override fun onResume() {
        super.onResume()
        println("Ahmad $this#onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Ahmad $this#onDestroy")
    }
}


class Frob @Inject constructor() {

}