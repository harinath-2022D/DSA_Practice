package org.dsa.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 12345;
        int count =countNumberOfDigits(n);
        int reverseNumber = reverseNumber(n);
        List<Integer> dividors = printDivisors(n);
        boolean isPrimeNum = checkIsPrimeNum(n);
    }

    private static boolean checkIsPrimeNum(int n) {
        // solution 1 brute force TC : O(N)
        int cnt = 0;
    /*
        for(int i = 1; i <= n; i++){

            if(n % i == 0){
                cnt++;
            }
            if(cnt > 2){
                return false;
            }
        }
        return true;
    */

        // solution 2 TC : O(sqrt(N))
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                cnt++;
                if((n % i) != i){
                    cnt++;
                }
            }

            if(cnt > 2){
                return false;
            }
        }
        return true;
    }

    private static List<Integer> printDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        // solution 1
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                list.add(i);
            }
        }

        // solution 2 TC : O(sqrt(N))
        // instead of using i <= Math.sqrt(n) => i * i <= n is better it is avoids calling external function
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                list.add(i);
                if((n % i) != i){
                    list.add(i);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    private static int reverseNumber(int n) {
        int reverseNum = 0;
        while(n > 0){
            reverseNum = (reverseNum * 10 ) + n % 10;
            n /= 10;
        }
        return reverseNum;
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
