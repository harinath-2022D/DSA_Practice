package org.dsa.arrays;

public class KadensAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        maxSubArraySum(arr);
    }

    private static void maxSubArraySum(int[] arr) {
        int n = arr.length;

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        int arrStart = -1;
        int arrEnd = -1;

        for(int i = 0; i < n; i++){
            if(sum == 0) arrStart = i;
            sum += arr[i];

            if(sum > maxSum){
                maxSum = sum;
                arrEnd = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        System.out.println(maxSum);
        System.out.println("Sub Array Start Index and End Index : " + arrStart +" , "+ arrEnd);
    }
}
