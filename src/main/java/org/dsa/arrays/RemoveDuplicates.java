package org.dsa.arrays;

public class RemoveDuplicates {

    private  int[] arr;
    public RemoveDuplicates(int[] arr){
        this.arr = arr;
    }
    public int removeDuplicates(){
        int i = 0;
        for(int j = 1; j < arr.length; j++){
            if(arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }

        for(int k = 0; k < arr.length; k++){
            System.out.println(arr[k]);
        }
        return  i + 1;
    }
}
