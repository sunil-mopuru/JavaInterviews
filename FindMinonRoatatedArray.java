package com.javastack.datastructures.search;

public class FindMinonRoatatedArray
{
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }
    private static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        int answer = arr[0];
        while(left <= right)
        {
            int mid = (left+right)/2;
            if(arr[mid]>=arr[0])
            {
                left = mid+1;
            }
            else{
                answer = arr[mid];
                right = mid-1;
            }
        }
        return answer;
    }
}
