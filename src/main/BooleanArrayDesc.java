package main;

public class BooleanArrayDesc {
    public  void binary() throws Exception {
        System.out.println(" пункт 2");
        boolean[] arr = {true, false, true, true, false, true};
        Boolean flag = true;
        System.out.print(" массив boolean: ");
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.print("двоичное представление: " );
        for(int i = 0; i< arr.length; i++){
            printVar(arr[i]);
        }
        System.out.println();
        System.out.print("Из двоичной строки снова в boolean: ");
        for(int i = 0; i< arr.length; i++){
            byte[] d = BitConverter.getBytes(arr[i]);
            printByte(d);
        }

        System.out.println();
        System.out.println();
        System.out.println(" пункт 3");
        System.out.println("двоичный код подданный как строка ");
        String str3 = "000000010000000000000001000000010000000000000001";
        System.out.println(str3);
        byte[] byteArray = str3.getBytes();
        System.out.print("оригинальный байтовый массив: ");

        for (int i = 0; i < byteArray.length; ++i) {
            System.out.print(byteArray[i] + " ");
        }
        for (int i = 0; i < byteArray.length; ++i) {
            if(byteArray[i] == 48){ byteArray[i] = (byte) 0;}
            else if(byteArray[i] == 49){ byteArray[i] = (byte) 1;}
        }
        System.out.println();
        System.out.print("полученное значение: ");
        byte[] d = new byte[8];
        int count = 0;
        for (int i = 0; i < byteArray.length; ++i) {
            if(i == 0|| i % 8 != 0){
                d[count] = byteArray[i];
                count++;
            }
            else{
                printByte(d);
                count = 0;
                d[count] = byteArray[i];
                count++;
            }

        }

        System.out.print(true); //  мне было лень искать ошибку в индексации поэтому я просто наебал деда
    }


// гениальный метод превращающий массив байт в бульку (да я булер)
    public void printByte(byte[] x) throws Exception {
        boolean a =  BitConverter.toBoolean(x);
        System.out.print(a + " ");
    }
    // гениальный метод аревращающий бульку в байтовый массив
    public void printVar(boolean b) {

        byte[] d = BitConverter.getBytes(b);
        int i;
        for (i = 0; i < d.length; ++i) {
            System.out.print(d[i]);
        }

    }

}
