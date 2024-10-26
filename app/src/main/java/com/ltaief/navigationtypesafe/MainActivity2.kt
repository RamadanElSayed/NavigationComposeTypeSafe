package com.ltaief.navigationtypesafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ltaief.navigationtypesafe.ui.theme.NavigationComposeTypeSafeTheme
import kotlinx.serialization.Serializable

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationComposeTypeSafeTheme {
                window.navigationBarColor = colorScheme.background.toArgb()
                val navController: NavHostController = rememberNavController()
                MyBottomBar2(navController)
            }
        }
    }
}


@Serializable
data object Home

@Serializable
data class Profile(val name: String)

@Serializable
data object Search


@Composable
fun MyBottomBar2(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = Color.Transparent) {
                IconButton(
                    onClick = {
                        navController.navigate(Home)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Filled.Home, contentDescription = "Home")
                }

                IconButton(
                    onClick = {
                        navController.navigate(Search)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                }

                IconButton(
                    onClick = {
                        navController.navigate(Profile("John Doe"))
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Filled.Face, contentDescription = "Profile")
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Home> {
                HomeScreen2()
            }
            composable<Search> {
                SearchScreen2()
            }
            composable<Profile> {
                val profile = it.toRoute<Profile>()
                ProfileScreen2(profile.name)
            }
        }
    }
}

@Composable
fun HomeScreen2() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun SearchScreen2() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Search", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun ProfileScreen2(name: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = name, textAlign = TextAlign.Center)
        }
    }
}
