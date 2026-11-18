package com.example.calculadoraoperaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CalculadoraApp()
            }
        }
    }
}

// Clase con la lógica: aquí están todas las reglas de las operaciones
class Calculadora {

    fun sumar(a: Double, b: Double): Double {
        return a + b
    }

    fun restar(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    // Devuelve null si se intenta dividir entre cero
    fun dividir(a: Double, b: Double): Double? {
        if (b == 0.0) {
            return null
        }
        return a / b
    }
}

// Pantalla: solo muestra datos y llama a la clase Calculadora
@Composable
fun CalculadoraApp() {

    var primerNumero by remember { mutableStateOf("") }
    var segundoNumero by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    // Se conserva el mismo objeto mientras Compose actualiza la pantalla.
    val calculadora = remember { Calculadora() }

    // Convierte el texto a número (acepta coma o punto)
    fun leerNumeros(): Pair<Double, Double>? {
        val a = primerNumero.replace(",", ".").toDoubleOrNull()
        val b = segundoNumero.replace(",", ".").toDoubleOrNull()

        if (a == null || b == null) {
            resultado = "Ingrese dos números válidos"
            return null
        }
        return Pair(a, b)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Calculadora",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = primerNumero,
            onValueChange = { primerNumero = it },
            label = { Text("Primer número") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = segundoNumero,
            onValueChange = { segundoNumero = it },
            label = { Text("Segundo número") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val numeros = leerNumeros()
                if (numeros != null) {
                    resultado = "Resultado: " + calculadora.sumar(numeros.first, numeros.second)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar")
        }

        Button(
            onClick = {
                val numeros = leerNumeros()
                if (numeros != null) {
                    resultado = "Resultado: " + calculadora.restar(numeros.first, numeros.second)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Restar")
        }

        Button(
            onClick = {
                val numeros = leerNumeros()
                if (numeros != null) {
                    resultado = "Resultado: " + calculadora.multiplicar(numeros.first, numeros.second)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Multiplicar")
        }

        Button(
            onClick = {
                val numeros = leerNumeros()
                if (numeros != null) {
                    val division = calculadora.dividir(numeros.first, numeros.second)
                    if (division == null) {
                        resultado = "No es posible dividir entre cero"
                    } else {
                        resultado = "Resultado: $division"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Dividir")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = resultado,
            style = MaterialTheme.typography.titleMedium
        )
    }
}
