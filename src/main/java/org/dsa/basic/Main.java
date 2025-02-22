package org.dsa.basic;

public class Main {
    public static void main(String[] args) {
        int n = 12345;
        int count =countNumberOfDigits(n);
    }
    /* TC : log 10 (N) because number is dividing every time with 10
    * */
    private static int countNumberOfDigits(int n) {
        // we can also use log10 function of Math library
        // int count =  Math.log10(Math.abs(number)) + 1;
        int count = 0;
        while(n > 0){
            count += 1;
            n = n / 10;
        }
        return count;
    }
}
