package ru.hometech.markettogether

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.hometech.markettogether.di.MainComponent
import ru.hometech.markettogether.di.Test
import ru.hometech.markettogether.ui.theme.MarkettogetherTheme
import javax.inject.Inject
import kotlin.reflect.KClass

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var newInt: Test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainComponent.getOrCreate(this).inject(this)
        Log.e("!!!", "newInt = $newInt")
        setContent {
            MarkettogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android, ${newInt.getInt()}")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing)
        MainComponent.release()
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
    MarkettogetherTheme {
        Greeting("Android")
    }
}