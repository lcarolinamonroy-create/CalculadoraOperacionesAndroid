package com.example.calculadoraoperaciones

import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class CalculadoraTest {

    private val calculadora = Calculadora()

    private fun verificarResultado(esperado: Double, obtenido: Double) {
        assertTrue(
            "Se esperaba $esperado, pero se obtuvo $obtenido",
            kotlin.math.abs(esperado - obtenido) < 0.001
        )
    }

    @Test
    fun sumar_dos_numeros() {
        verificarResultado(15.0, calculadora.sumar(10.0, 5.0))
    }

    @Test
    fun restar_dos_numeros() {
        verificarResultado(5.0, calculadora.restar(10.0, 5.0))
    }

    @Test
    fun multiplicar_dos_numeros() {
        verificarResultado(50.0, calculadora.multiplicar(10.0, 5.0))
    }

    @Test
    fun dividir_dos_numeros() {
        val resultado = calculadora.dividir(10.0, 5.0)
        verificarResultado(2.0, resultado ?: 0.0)
    }

    @Test
    fun dividir_por_cero_devuelve_null() {
        assertNull(calculadora.dividir(10.0, 0.0))
    }
}
