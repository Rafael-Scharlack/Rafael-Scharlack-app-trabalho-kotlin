package com.example.app_trabalho_kotlin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PedidosScreen(modifier: Modifier = Modifier, navController: NavController, cliente: String?) {
    Box(modifier = modifier.fillMaxSize().background(Color(0xFFFA9A9A9)).padding(32.dp)) {
        Text(
            text = "PEDIDOS - $cliente",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Button(
            onClick = { navController.navigate("menu") },
            modifier = Modifier.align(Alignment.Center).size(width = 200.dp, height = 48.dp)
        ) {
            Text(text = "Voltar")
        }
    }
}