package org.dsa.arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,0};
//        int[] arr = {3,2,1};
        nextPermutation(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        int idx = -1;  // find out the element next small to the left
        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i; break;
            }
        }

        if(idx == -1) { // if there is no next small means there is no next permutation
            swap(0, n-1, nums);
            return;
        }

        for(int i = n-1; i > idx; i--){ // find out the next greater to the idx and swap
            if(nums[i] > nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp; break;
            }
        }

        swap(idx + 1, n-1, nums); // sort the array from idx + 1 to end of the array
    }

    public static void swap(int i, int j, int[] arr){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
