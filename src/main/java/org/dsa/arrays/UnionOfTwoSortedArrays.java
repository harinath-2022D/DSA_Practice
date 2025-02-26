package org.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,5,6,7};

        unionOfTwoSortedArrays(arr1,arr2);
    }

    private static void unionOfTwoSortedArrays(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();
        while (i < n && j < m){
            if(arr1[i] == arr2[j]){
                list.add(arr1[i]);
                i++;
                j++;
            } else {
                while(i < n && arr1[i] != arr2[j]){
                    i++;
                }
            }
        }

        list.stream().forEach(System.out::println);
    }
}
