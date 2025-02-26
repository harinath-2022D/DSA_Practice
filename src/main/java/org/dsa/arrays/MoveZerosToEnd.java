package org.dsa.arrays;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 3};
        moveZeros(arr, arr.length);
    }

    private static void moveZeros(int[] arr, int length) {
        int i = 0;
        int j = length - 1;

        while (i < j){
            while(arr[i] != 0 && i < j){
                i++;
            }
            while(arr[j] == 0 && j > i){
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}
