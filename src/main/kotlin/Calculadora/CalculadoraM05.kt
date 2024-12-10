package Calculadora
import Utils.readInt
import java.util.Scanner

// Objeto Scanner global
val scan: Scanner = Scanner(System.`in`)

fun main() {

    var continuar: Int
    do {
        mostrarMenu()

        // Leer la operación seleccionada
        val operacion = readInt(
            "Elija una operación:",
            "Ingrese un número válido.",
            "El numero esta fuera del rango",
            0,
            7 // Validar dentro del rango de operaciones
        )

        if (operacion == 0) {
            println("Saliendo de la calculadora. ¡Hasta luego!")
            break
        }

        // Ejecutar la operación seleccionada
        ejecutarOperacion(operacion)

        println("\n¿Desea realizar otra operación? Ingrese 0 para salir o cualquier otro número para continuar.")
        continuar = readInt(
            "Ingrese su elección:",
            "Ingrese un número válido.",
            "",
            Int.MIN_VALUE,
            Int.MAX_VALUE
        )

    } while (continuar != 0)

    println("Saliendo de la calculadora. ¡Hasta luego!")
}
