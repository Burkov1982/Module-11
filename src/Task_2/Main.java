package Task_2;

import java.util.StringJoiner;

public class Main {

    static int n = 15;
    static int[] arrOfNum;
    static String[] result;
    static StringJoiner joiner = new StringJoiner(", ");

    public static void main(String[] args) {
        generateArrOfNum(n);

        Thread A =  new Thread(() -> fizz(arrOfNum, result));
        Thread B = new Thread(() -> buzz(arrOfNum, result));
        Thread C = new Thread(() -> fizzbuzz(arrOfNum, result));
        Thread D = new Thread(() -> number(arrOfNum, result));

        A.start();
        B.start();
        C.start();
        D.start();

        try {
            A.join();
            B.join();
            C.join();
            D.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        for (String s:result) {
            joiner.add(s);
        }

        System.out.println(joiner.toString());
    }

    public static void generateArrOfNum(int n){
        arrOfNum = new int[n];
        result = new String[n];
        for (int i = 0; i < n; i++) {
            arrOfNum[i] = i+1;
        }
    }

    public static void fizz(int[] arrOfNum, String[] result1){
        for (int i = 0; i < arrOfNum.length; i++) {
            int temp = arrOfNum[i];
            if (temp%3==0 && temp%5!=0){
                result[i] = "fizz";
            }
        }
    }

    public static void buzz(int[] arrOfNum, String[] result1){
        for (int i = 0; i < arrOfNum.length; i++){
            int temp = arrOfNum[i];
            if(temp%3!=0 && temp%5==0){
                result[i] = "buzz";
            }
        }
    }

    public static void fizzbuzz(int[] arrOfNum, String[] result1){
        for (int i = 0; i < arrOfNum.length; i++) {
            int temp = arrOfNum[i];
            if (temp%3==0 && temp%5==0){
                result[i] = "fizzbuzz";
            }
        }
    }

    public static void number(int[] arrOfNum, String[] result1){
        for (int i = 0; i < arrOfNum.length; i++) {
            int temp = arrOfNum[i];
            if (temp%3!=0 && temp%5!=0){
                result[i] = String.valueOf(temp);

            }
        }
    }
}
