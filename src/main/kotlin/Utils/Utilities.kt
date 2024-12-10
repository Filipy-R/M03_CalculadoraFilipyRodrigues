package Utils

import java.util.*

val scan: Scanner = Scanner(System.`in`)

/**
 * This method can be used to read an Int value from the user through keyboard using java.util.Scanner in within a range
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @param pMessageErrorDV Data value error message to be shown to the user
 * @param pMin Min accepted value
 * @param pMax Max accepted value
 * @return outputValue Output value
 */
fun readInt(pMessageIn: String
            , pMessageErrorDT: String
            , pMessageErrorDV: String
            , pMin: Int
            , pMax: Int
): Int{

    var outputValue: Int = 0
    var correctDataType: Boolean = false

    do{
        println(BLUE + pMessageIn + RESET)
        correctDataType = scan.hasNextInt()

        if (!correctDataType){
            println(RED + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextInt()

            if (outputValue < pMin || outputValue > pMax){
                println(YELLOW + "WARNING: " + pMessageErrorDV + RESET)
                correctDataType = false
            }
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read a Float value from the user through keyboard using java.util.Scanner
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @return outputValue Output value
 */
fun readFloat(pMessageIn: String
              , pMessageErrorDT: String
): Float{

    var outputValue: Float = 0.0f
    var correctDataType: Boolean = false

    do{
        println(pMessageIn)
        correctDataType = scan.hasNextFloat()

        if (!correctDataType){
            println(RED + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextFloat()
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

