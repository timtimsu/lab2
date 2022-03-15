package main;

import java.util.ArrayList;

public class IntegerDesc {


    public static void binary() {
        Integer number = 379;
        String binaryString = Integer.toBinaryString(number);
        System.out.println("целое: " + number);
        System.out.println("двоичное представление: " + binaryString);
        Integer binaryNumber = Integer.valueOf(binaryString, 2);
        System.out.println("Из двоичной строки снова в число: " + binaryNumber);
        System.out.println();
        System.out.println();
        System.out.println("двоичный код подданный как строка ");
        String str3 = "1111101";
        System.out.println(str3);
        byte[] byteArray = str3.getBytes();
        System.out.print("оригинальный байтовый массив: ");

        for (int i = 0; i < byteArray.length; ++i) {
            System.out.print(byteArray[i] + " ");
        }
        System.out.println();
        String string1 = new String(byteArray);
        System.out.print(string1);
        Integer in = Integer.parseInt(string1, 2);
        System.out.println("полученное число " + in);
    }

    private static void printByte(byte a) {
        System.out.print(Integer.toBinaryString(a) + " ");
    }

    private static void printVar(String str) {
        System.out.println("Original variable: " + str);
        byte[] array = str.getBytes();
        System.out.println("Amount of bytes: " + array.length);
        System.out.print("byteInt: ");

        int i;
        for (i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.print("byteBinary: ");

        for (i = 0; i < array.length; ++i) {
            printByte(array[i]);
        }

    }

}