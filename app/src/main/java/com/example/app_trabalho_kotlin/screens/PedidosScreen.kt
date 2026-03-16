package com.example.app_trabalho_kotlin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFF3E0))
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MEUS PEDIDOS - $cliente",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFE65100)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("menu") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE65100))
        ) {
            Text(
                text = "Voltar ao Menu",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}