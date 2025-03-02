package org.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReArrangeArray {
    public static void main(String[] args) {
        int[] arr = {1,2,-1,-23,4,-6}; // variety 1 pos == neg
        int[] variety2 = {1,2,-3,-6,-3,4,7,0};  // pos > neg or neg > pos

        betterAppr(variety2);
    }
// this approach works for both variety 1 and variety 2 but optimal approach works only for variety 1 that uses two pointers
    public static void betterAppr(int[] arr){
        int n = arr.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(arr[i] > 0){
                pos.add(arr[i]);
            }else {
                neg.add(arr[i]);
            }
        }

        int i = 0;
        while(i < Math.min(pos.size(), neg.size())){
            arr[2*i] = pos.get(i);
            arr[2*i + 1] = neg.get(i);
            i++;
        }

        while(i < pos.size()){
            arr[i] = pos.get(i);
            i++;
        }
        while(i < neg.size()){
            arr[i] = neg.get(i);
            i++;
        }

        Arrays.stream(arr).forEach(System.out::println);

    }

}
