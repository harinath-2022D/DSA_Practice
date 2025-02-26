package org.dsa.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
//        rotateArrayBruteForce(arr,k);
        rotateArrayOptimal(arr,k);
    }
    public static void rotateArrayBruteForce(int[] arr, int k){ // {1,2,3,4,5} => {3,4,5,1,2}
        int[] temp = new int[arr.length];
        int n = arr.length;
        k = k % n;
        if(k > n) return;
        int i = 0;
        int j = k;
        while(j < n){
            temp[i] = arr[j];
            i++;
            j++;
        }
        j = 0;
        while (j < k){
            temp[i++] = arr[j++];
        }
        Arrays.stream(temp).forEach(System.out::println);
    }

    public static void rotateArrayOptimal(int[] arr, int k){ // {1,2,3,4,5}
        int n = arr.length;
        k = k % n;
        swap(0, k-1, arr); // {2,1,3,4,5}
        swap(k, n-1, arr); // {2,1,5,4,3}
        swap(0, n-1, arr); // {3,4,5,1,2}
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void swap(int i, int j, int[] arr){
        while( i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
