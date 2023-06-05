package ru.hometech.markettogether

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.hometech.core_common.daggerViewModel
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.content.ShoppingScreen
import ru.hometech.feature_shopping.ui.di.ShoppingComponent
import ru.hometech.markettogether.di.MainComponent
import ru.hometech.markettogether.ui.theme.MarkettogetherTheme
import kotlin.reflect.KClass

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarkettogetherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController,
                        startDestination = NavigationDestination.MainScreen.destination
                    ) {
                        Log.e("!!!", "graph ")
                        composable(NavigationDestination.MainScreen.destination) {
                            it.addObserver(MainComponent::release)
                            val viewModel: MainViewModel = daggerViewModel(
                                vm = MainViewModel::class,
                                component = MainComponent.getOrCreate(this@MainActivity),
                            )
                            Greeting(
                                viewModel = viewModel,
                                navigate = { dest ->
                                    navController.navigate(dest.destination)
                                }

                            )
                        }
                        composable(NavigationDestination.ShoppingScreen.destination) {
                            it.addObserver(ShoppingComponent::release)
                            val viewModel: ShoppingViewModel = daggerViewModel(
                                vm = ShoppingViewModel::class,
                                component = ShoppingComponent.getOrCreate()
                            )
                            ShoppingScreen(viewModel = viewModel)
                        }
                    }
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

private fun NavBackStackEntry.addObserver(onReleaseComponent: () -> Unit) {
    val observer = LifecycleEventObserver { s, event ->
        if (event == Lifecycle.Event.ON_DESTROY) {
            onReleaseComponent()
            Log.e("!!!", "component released")
        }
    }
    getLifecycle().addObserver(observer)
}

@Composable
fun Greeting(
    viewModel: MainViewModel,
    navigate: (NavigationDestination) -> Unit
) {
    Column {
        Button(
            onClick = {
                navigate(NavigationDestination.ShoppingScreen)
            }
        ) {
            Text(text = "to shopping")
        }
    }

}