package org.dsa.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 12345;
        int x = 25;
        int count =countNumberOfDigits(n);
        int reverseNumber = reverseNumber(n);
        List<Integer> divisors = printDivisors(n);
        boolean isPrimeNum = checkIsPrimeNum(n);
        int gcd = findGcd(n, n);
        List<Integer> primeFactors = findPrimeFactors(n);
        int powerOfExpo = findPowerOfExpo(n, x);
        List<Integer> primeNumbers = finPrimeNumberUpToNumber(n);
        List<Integer> primeFactorsSPF = findPrimeFactorsUsingSieveOfEroto(x);
        primeFactorsSPF.stream().forEach(System.out::println);
    }
    private static List<Integer> findPrimeFactorsUsingSieveOfEroto(int n) { // TC O(N log of log N) + O(log base 2 N)
        List<Integer> list = new ArrayList<>();

        int[] spf = new int[n+1];
        for(int i = 0; i <= n; i++){
            spf[i] = i;
        }
        for(int i=2; i*i <= n; i++){
            for(int j = i*i; j<=n; j+=i){
                if(spf[j] == j){
                    spf[j] = i;
                }
            }
        }

        while(n != 1){
            list.add(spf[n]);
            n= n/spf[n];
        }

        return list;
    }

    // sieve of eratosthenes algorithm
    private static List<Integer> finPrimeNumberUpToNumber(int n) {
        List<Integer> list = new ArrayList<>();

        // using sieve of eratosthenes  TC : O(log of log N)
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        for(int i = 2; i <= n; i++){ // for optimising we can i <=n to i * i <= n
            if(arr[i] == 1){
                list.add(i);
                for(int j = i * 2; j <= n; j = j+i){ // for optimising we can j = i * i
                    arr[j] = 0;
                }
            }
        }

        return list;
    }

    private static int findPowerOfExpo(int x, int y) {

        int ans = 1;
        // solution 1 TC O(X)
//        for(int i = 1; i <= y; i++){
//            ans = ans * x;
//        }

        // solution 2 TC O(log 2 y)
        while(y > 0){
            if(y % 10 == 1){
                ans = ans * x;
                y = y - 1;
            }else{
                y = y / 2;
                x = x * x;
            }
        }

        return ans;
    }

    private static List<Integer> findPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();
        // TC O(sqrt(N) * log(N))
        for(int i=2; i*i <= n; i++){
            if(n % i == 0){
                list.add(i);
                while(n % i == 0){
                    n = n / i;
                }
            }
        }
        if(n != 1) list.add(n);
        return list;
    }

    private static int findGcd(int n1, int n2) {
        // solution 1 TC O(min(n1,n2))
        int hcf = 1;
//        for(int i =2; i <= Math.min(n1,n2); i++){
//            if((n1 % i == 0) && (n2 % i == 0)){
//                hcf = i;
//            }
//        }
//        return hcf;

        // solution 2 TC: O(log pi (min(n1, n2)))
        while(n1 > 0 && n2 > 0){
            if(n1 > n2) n1 = n1 % n2;
            else n2 = n2 % n1;
        }
        if(n1 == 0) return n2;
        return n2;
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
