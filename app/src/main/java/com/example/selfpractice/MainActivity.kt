package com.example.selfpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.selfpractice.ui.theme.SelfPracticeTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SelfPracticeTheme {
//                MyScaffoldApp()
                NavigationApp()
            }
        }
    }
}
//
// Creating a screen structure with a Scaffold Composable and slots
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyScaffoldApp() {
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = { Text("TOP BAR") },
//                modifier = Modifier.statusBarsPadding(),
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                    containerColor =
//                        MaterialTheme.colorScheme.surfaceContainer
//                )
//            )
//        },
//        bottomBar = {
//            BottomAppBar(
//                modifier = Modifier.fillMaxWidth().height(56.dp)
//            ) {
//                Box(
//                    modifier = Modifier.fillMaxWidth(),
//                    contentAlignment = Alignment.Center
//                )
//                {
//                    Text(text = "BOTTOM BAR")
//                }
//            }
//        },
//        content = { innerPadding ->
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(innerPadding),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "BODY CONTENT",
//                    modifier = Modifier.padding(16.dp),
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//    )
//}

// Building a navigation graph
@Serializable
data object Home

@Serializable
data object Detail

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    // Removed 'builder =' and extra parentheses
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen(navController)
        }
        composable<Detail> {
            DetailScreen(navController)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home Screen", fontSize=28.sp,
            modifier = Modifier.align(Alignment.TopCenter))
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { navController.navigate(Detail) }, // Navigates forward
        ) {
            Text(text = "Go to Detail Screen", fontSize= 22.sp)
        }
    }
}

@Composable
fun DetailScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Detail Screen", fontSize=28.sp,
            modifier = Modifier.align(Alignment.TopCenter))
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { navController.navigate(Home) }, // Better: goes back to Home
        ) {
            Text(text = "Go Back to Home", fontSize= 22.sp)
        }
    }
}