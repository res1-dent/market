package ru.hometech.markettogether.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.hometech.feature_rus_quality.navigation.rusQualityGraph
import ru.hometech.feature_shopping.navigation.shoppingGraph
import ru.hometech.markettogether.di.AppComponent
import ru.hometech.markettogether.ui.theme.MarketTogetherTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MarketTogetherTheme {
                Scaffold(
                    bottomBar = {
                        BottomBar(navController = navController)
                    },
                    floatingActionButton = {},
                    floatingActionButtonPosition = FabPosition.End
                ) { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = paddingValues.calculateBottomPadding()),
                        color = MaterialTheme.colorScheme.background,
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = MainGraph.ShoppingScreen.route
                        ) {
                            shoppingGraph(navController, MainGraph.ShoppingScreen.route)
                            rusQualityGraph(navController, MainGraph.RusQualityScreen.route)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing)
            AppComponent.release()
    }
}