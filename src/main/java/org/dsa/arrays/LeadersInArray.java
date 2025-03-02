package org.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        findLeadersInArray(arr);
    }

    private static void findLeadersInArray(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for(int i = arr.length - 1; i >= 0;  i--){
            if(arr[i] > max){
                list.add(arr[i]);
                max = arr[i];
            }
        }

        list.stream().forEach(System.out::println);
    }
}
