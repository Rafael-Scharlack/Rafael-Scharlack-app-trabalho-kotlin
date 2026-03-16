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
                        composable("login") { LoginScreen(modifier = Modifier.padding(innerPadding), navController = navController) }
                        composable("menu") { MenuScreen(modifier = Modifier.padding(innerPadding), navController = navController) }

                        composable(
                            route = "perfil/{nome}",
                            arguments = listOf(navArgument("nome") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val nome = backStackEntry.arguments?.getString("nome") ?: ""
                            PerfilScreen(modifier = Modifier.padding(innerPadding), navController = navController, nomeUsuario = nome)
                        }

                        composable(
                            route = "pedidos/{numeroPedido}/{valorTotal}",
                            arguments = listOf(
                                navArgument("numeroPedido") { type = NavType.StringType },
                                navArgument("valorTotal") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val numero = backStackEntry.arguments?.getString("numeroPedido") ?: ""
                            val valor = backStackEntry.arguments?.getString("valorTotal") ?: ""
                            PedidosScreen(modifier = Modifier.padding(innerPadding), navController = navController, numeroPedido = numero, valorTotal = valor)
                        }
                    }
                }
            }
        }
    }
}