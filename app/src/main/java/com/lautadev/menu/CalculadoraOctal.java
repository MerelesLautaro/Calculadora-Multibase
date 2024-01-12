package com.lautadev.menu;

public class CalculadoraOctal {
    public static String sumarOctal(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 8);
        int decimalNum2 = Integer.parseInt(num2, 8);
        int suma = decimalNum1 + decimalNum2;
        return Integer.toOctalString(suma);
    }

    public static String restarOctal(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 8);
        int decimalNum2 = Integer.parseInt(num2, 8);
        int resta = decimalNum1 - decimalNum2;
        return Integer.toOctalString(resta);
    }

    public static String multiplicarOctal(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 8);
        int decimalNum2 = Integer.parseInt(num2, 8);
        int multiplicacion = decimalNum1 * decimalNum2;
        return Integer.toOctalString(multiplicacion);
    }

    public static String dividirOctal(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 8);
        int decimalNum2 = Integer.parseInt(num2, 8);

        if (decimalNum2 == 0) {
            return "NaN";
        }

        int division = decimalNum1 / decimalNum2;
        return Integer.toOctalString(division);
    }
}
