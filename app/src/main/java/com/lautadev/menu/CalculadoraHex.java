package com.lautadev.menu;

public class CalculadoraHex {
    public static String sumarHex(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 16);
        int decimalNum2 = Integer.parseInt(num2, 16);
        int suma = decimalNum1 + decimalNum2;
        return Integer.toHexString(suma);
    }

    public static String restarHex(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 16);
        int decimalNum2 = Integer.parseInt(num2, 16);
        int resta = decimalNum1 - decimalNum2;
        return Integer.toHexString(resta);
    }

    public static String multiplicarHex(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 16);
        int decimalNum2 = Integer.parseInt(num2, 16);
        int multiplicacion = decimalNum1 * decimalNum2;
        return Integer.toHexString(multiplicacion);
    }

    public static String dividirHex(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 16);
        int decimalNum2 = Integer.parseInt(num2, 16);

        if (decimalNum2 == 0) {
            return "NaN";
        }

        int division = decimalNum1 / decimalNum2;
        return Integer.toHexString(division);
    }
}