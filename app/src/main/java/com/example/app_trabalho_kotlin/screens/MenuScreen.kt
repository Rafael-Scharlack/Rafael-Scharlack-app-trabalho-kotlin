package com.example.app_trabalho_kotlin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize().background(Color(0xFFF5F5F5)).padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val btnMod = Modifier.size(width = 200.dp, height = 48.dp)
        Button(onClick = { navController.navigate("perfil/Fulano de Tal/27") }, modifier = btnMod) {
            Text(text = "Perfil")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("pedidos?cliente=Rafael") }, modifier = btnMod) {
            Text(text = "Pedidos")
        }
    }
}