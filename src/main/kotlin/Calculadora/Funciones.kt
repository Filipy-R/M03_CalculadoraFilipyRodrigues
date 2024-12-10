package Calculadora
import Utils.RED
import Utils.RESET
import Utils.readInt

fun mostrarMenu() {
    val calculadoraEmoji = "\uD83D\uDD22" //Emoji calculadora
    println(
        """
                                  ¡Bienvenido a la Calculadora!
        ***************                       
        * =========== *           Elija la operación que desea realizar:                                                             
        *   8 + 4 =12 *          1. Sumar
        *             *          2. Restar
        * *********** *          3. Multiplicar
        *  ( )   AC   *          4. Dividir
        *             *          5. Potencia
        *  +   -   ×  *          6. Raíz Cuadrada
        *  ÷   =   C  *          7. Factorial
        *             *          0. Salir
        *  7   8   9  *          
        *  4   5   6  *          
        *  1   2   3  *          
        *  0       OK *          
        ***************          
        """.trimIndent()
    )
}

fun ejecutarOperacion(operacion: Int) {
    val num1 = if (operacion in 1..7) {
        readInt(
            "Ingrese el primer número:",
            "Ingrese un número válido.",
            "",
            Int.MIN_VALUE,
            Int.MAX_VALUE
        )
    } else 0

    val num2 = if (operacion in 1..4 || operacion == 5) {
        readInt(
            "Ingrese el segundo número:",
            "Ingrese un número válido.",
            "",
            Int.MIN_VALUE,
            Int.MAX_VALUE
        )
    } else 0

    when (operacion) {
        1 -> println("Resultado de la suma: |${sumar(num1, num2)}|")
        2 -> println("Resultado de la resta: |${restar(num1, num2)}|")
        3 -> println("Resultado de la multiplicación: |${multiplicar(num1, num2)}|")
        4 -> println("Resultado de la división: |${dividir(num1, num2)}|")
        5 -> println("Resultado de la potencia: |${formatear(elevar(num1, num2))}|")
        6 -> println("Raíz cuadrada de $num1: |${(raizCuadrada(num1))}|")
        7 -> println("Factorial de $num1: |${factorial(num1)}|")
        else -> println("¡Operación inválida!")
    }
}

// Función para sumar
fun sumar(a: Int, b: Int) = a + b

// Función para restar
fun restar(a: Int, b: Int) = a - b

// Función para multiplicar
fun multiplicar(a: Int, b: Int) = a * b

// Función para dividir
fun dividir(a: Int, b: Int): String {
    return if (b == 0) {
        "${RED}Error: ¡División por cero!${RESET}"
    } else {
        formatear(a.toDouble() / b.toDouble())
    }
}

// Función para potencia
fun elevar(a: Int, b: Int): Double {
    return Math.pow(a.toDouble(), b.toDouble())
}

// Función para raíz cuadrada
fun raizCuadrada(a: Int): String {
    var numero = a
    while (numero < 0) {
        println("${RED}Error: ¡Número negativo!${RESET} Ingrese un número no negativo:")
        numero = readInt(
            "Ingrese un número válido para calcular la raíz cuadrada:",
            "Ingrese un número válido.",
            "",
            0, // Solo aceptamos números positivos
            Int.MAX_VALUE
        )
    }
    return formatear(Math.sqrt(numero.toDouble()))
}

// Función para factorial
fun factorial(n: Int): Int {
    return if (n < 0) {
        println("${RED}Error: ¡El factorial no está definido para números negativos!${RESET}")
        -1
    } else if (n == 0 || n == 1) {
        1
    } else {
        n * factorial(n - 1)
    }
}

// Función para formatear números decimales
fun formatear(valor: Double): String {
    return String.format("%.2f", valor)
}
