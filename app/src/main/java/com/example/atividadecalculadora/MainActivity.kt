package com.example.atividadecalculadora

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atividadecalculadora.ui.theme.AtividadeCalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtividadeCalculadoraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainScreen(innerPadding: PaddingValues) {
    // input precisa ser "lembrado" (remember) e a cada alteração de "estado" (mutableStateOf)
    // é exigido o recompose da MainScreen
    // by <- delegate faz com que input seja igual a input.value e vira uma String diretamente
    // Antes input era MutableState<String> e agora ele é uma String, com o delegate (by)
    var v1 by remember { mutableStateOf("") }
    var v2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
        // input do número a ser identificado se é par ou ímpar
        TextField(
            value = v1,
            onValueChange = {
                v1 = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = v2,
            onValueChange = {
                v2 = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.padding(innerPadding).fillMaxWidth(), // Faz a linha ocupar toda a largura
        ) {
            // dispara o evento de identificação
            Button(
                onClick = {
                    if (v1.isBlank() || v2.isBlank()) {
                        result += "Preencha os valores!\n"
                    } else {
                        try {
                            val valor1 = v1.toDouble()
                            val valor2 = v2.toDouble()
                            val soma = valor1 + valor2
                            result = soma.toString()

                        } catch (e: NumberFormatException) {
                            result += "Erro! digite um valor válido.\n"
                        }
                    }
                },
            )

            {
                Text("+")
            }


            Button(
                onClick = {
                    if (v1.isBlank() || v2.isBlank()) {
                        result += "Preencha os valores!\n"
                    } else {
                        try {
                            val valor1 = v1.toDouble()
                            val valor2 = v2.toDouble()
                            val subtracao = valor1 - valor2
                            result = subtracao.toString()

                        } catch (e: NumberFormatException) {
                            result += "Erro! digite um valor válido.\n"
                        }
                    }
                },
            )

            {
                Text("-")
            }


            Button(
                onClick = {
                    if (v1.isBlank() || v2.isBlank()) {
                        result += "Preencha os valores!\n"
                    } else {
                        try {
                            val valor1 = v1.toDouble()
                            val valor2 = v2.toDouble()
                            val multiplicacao = valor1 * valor2
                            result = multiplicacao.toString()

                        } catch (e: NumberFormatException) {
                            result += "Erro! digite um valor válido.\n"
                        }
                    }
                },
            )

            {
                Text("*")
            }

            Button(
                onClick = {
                    if (v1.isBlank() || v2.isBlank()) {
                        result += "Preencha os valores!\n"
                    } else {
                        try {
                            val valor1 = v1.toDouble()
                            val valor2 = v2.toDouble()
                            val divisao = valor1 / valor2
                            result = divisao.toString()

                        } catch (e: NumberFormatException) {
                            result += "Erro! digite um valor válido.\n"
                        }
                    }
                },
            )

            {
                Text("/")
            }
        }
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()).fillMaxWidth()
        ) {
            Text(result)
        }
    }
    Log.d("MainScreenDebug", "Recompose!")
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(PaddingValues(0.dp))
}