package main;


public class DoubleDesc {

    public static void binary() {
        Double number = 111.5456;
        System.out.println("число: " + number);
        Double binaryNumber =  getBinary(number);
        printVar(binaryNumber.toString());
        System.out.println();
        System.out.println("Из двоичной строки снова в число: " + number);
        System.out.println();
        System.out.println();
        String numberFromString = "1111101.1111101";
        System.out.println("двоичный код подданный как строка: " + numberFromString);
        System.out.println("число, полученное из строки: " + getNumber(numberFromString));
        printVar(numberFromString);
    }

    private static void printByte(byte [] byteArray) {
    
        for (int i = 0; i < byteArray.length; i++)
            Integer.toBinaryString(byteArray[i] & 0xFF);
    }

    private static Double getBinary(Double number) {
       
        Integer numberDecimal = new Double(Double.parseDouble(number.toString().trim())).intValue();

        Double numberDivide = number - numberDecimal;
        
        Double decimalPart = 0.0;
        int counter = 1;

        while (numberDecimal != 0)
        {
            decimalPart += numberDecimal % 2 * counter;
            numberDecimal /= 2;
            counter *= 10;
        }

        Double dividePart = 0.0;
        Double currentFirst = 0.0;
        Integer current = 0;

        for (double i = 0; i < 5; i++)
        {
            currentFirst = numberDivide * 2.0;
            current = new Double(Double.parseDouble(currentFirst.toString().trim())).intValue();
            
            dividePart += current * Math.pow(10.0, i);
           
            numberDivide = currentFirst - current;
            current = 0;
            currentFirst = 0.0;
        }

        Double result = decimalPart + dividePart / 100000;
        return result;
    }

    private static Double getNumber(String numberFromString) {
        
        Double number = Double.parseDouble(numberFromString);
        Integer numberDecimal = new Double(Double.parseDouble(number.toString().trim())).intValue();
        
        char [] array = numberFromString.toCharArray();

        Integer index = 0;
        for (int i = 0; i < numberFromString.length(); i++)
            {
                if (array[i] == '.')
                {
                    index = i+1;
                    i = numberFromString.length() - 1;
                }
            }
        
        Double dividePart = 0.0;
        Integer count = 1;

        for (int i = index; i < numberFromString.length(); i++)
        {
            Integer current = array[i] - 48;
            dividePart += current * Math.pow(2.0, count*(-1));
            count++;
        }
        
        Double decimalPart = 0.0;
        
        String currentStringDecimal = Integer.toString(numberDecimal);
    
        for (int i = 0; i < currentStringDecimal.length(); i++) {
            decimalPart += (numberDecimal % 10)*Math.pow(2.0, i);
            numberDecimal /= 10;
        }

        Double result = decimalPart + dividePart;
        return result;
    }

    private static void printVar(String value) {
       
        System.out.println("двоичная запись: " + value);
       
        byte [] byteArray = value.getBytes();
       
        System.out.println("Размер в байтах: " + (byteArray.length-1));
        System.out.print("byteInt: ");

        for (int i = 0; i < byteArray.length; i++)
            if (byteArray[i] != 46)
                System.out.print(byteArray[i] + " ");
        
        printByte(byteArray);
    }
}