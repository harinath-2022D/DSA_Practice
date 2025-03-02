package org.dsa.arrays;

public class MooresVotingAlgo {
    public static void main(String[] args) {
        int[] arr = {2,2,1,3,1,1,3,1,1};
        findMajorityElement(arr);
    }

    // this is optimal approach but always go with better approach using map
    private static void findMajorityElement(int[] arr) {
        int cnt = 0;
        int ele = -1;
        for(int i = 0; i< arr.length; i++){
            if(cnt == 0){
                ele = arr[i];
            } else if (arr[i] == ele) {
                cnt++;
            }else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ele) cnt1++;
        }

        if(cnt1 > arr.length / 2){
            System.out.println("Majority Element is : " + ele);
        }
    }
}
