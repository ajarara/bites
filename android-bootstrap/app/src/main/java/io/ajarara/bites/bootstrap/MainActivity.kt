package io.ajarara.bites.bootstrap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import io.ajarara.bites.bootstrap.ui.theme.BootstrapTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BootstrapTheme {
        Greeting("Android")
    }
}
