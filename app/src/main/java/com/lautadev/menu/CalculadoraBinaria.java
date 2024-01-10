package com.lautadev.menu;

public class CalculadoraBinaria {
    public static String sumarBi(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 2);
        int decimalNum2 = Integer.parseInt(num2, 2);
        int suma = decimalNum1 + decimalNum2;
        return Integer.toBinaryString(suma);
    }

    public static String restarBi(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 2);
        int decimalNum2 = Integer.parseInt(num2, 2);
        int resta = decimalNum1 - decimalNum2;
        return Integer.toBinaryString(resta);
    }

    public static String multiplicarBi(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 2);
        int decimalNum2 = Integer.parseInt(num2, 2);
        int multiplicacion = decimalNum1 * decimalNum2;
        return Integer.toBinaryString(multiplicacion);
    }

    public static String dividirBi(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 2);
        int decimalNum2 = Integer.parseInt(num2, 2);

        if (decimalNum2 == 0) {
            return "Error: división por cero";
        }

        int division = decimalNum1 / decimalNum2;
        return Integer.toBinaryString(division);
    }
}
