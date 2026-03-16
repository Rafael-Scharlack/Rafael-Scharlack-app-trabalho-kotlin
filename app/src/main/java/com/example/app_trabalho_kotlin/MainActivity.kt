package com.example.app_trabalho_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app_trabalho_kotlin.screens.LoginScreen
import com.example.app_trabalho_kotlin.screens.MenuScreen
import com.example.app_trabalho_kotlin.screens.PedidosScreen
import com.example.app_trabalho_kotlin.screens.PerfilScreen
import com.example.app_trabalho_kotlin.ui.theme.ApptrabalhokotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApptrabalhokotlinTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }
                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome") { type = NavType.StringType },
                                navArgument("idade") { type = NavType.IntType }
                            )
                        ) {
                            val nome = it.arguments?.getString("nome", "Usuário Genérico")
                            val idade = it.arguments?.getInt("idade", 0)
                            PerfilScreen(Modifier.padding(innerPadding), navController, nome!!, idade!!)
                        }
                        composable(
                            route = "pedidos?cliente={cliente}",
                            arguments = listOf(navArgument("cliente") { defaultValue = "Cliente Genérico" })
                        ) {
                            PedidosScreen(Modifier.padding(innerPadding), navController, it.arguments?.getString("cliente"))
                        }
                    }
                }
            }
        }
    }
}