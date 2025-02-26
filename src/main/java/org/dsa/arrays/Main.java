package org.dsa.arrays;

public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[5];
        int[] arr = { 1, 2, 2, 3, 4};
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = i;
//        }

        RemoveDuplicates obj = new RemoveDuplicates(arr); // array should be in sorted order
        obj.removeDuplicates();
    }
}
