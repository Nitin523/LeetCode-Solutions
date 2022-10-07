/*Given an array of integers nums and an integer k,
return the number of contiguous subarrays 
where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0

**/


class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int left=0;
        int product=1;
        int count = 0; 
        for(int right=0; right<arr.length; right++){                //right pointer to include every element in the array
            product=product*arr[right];
            while(product>=k && left<arr.length){               // if product>=k divide the number from left means decrease the sliding window
                product=product/arr[left];
                left++;                                        // Decreasing the window size
            }
            if(product<k){                                 // increase the count whenever the product is less than k for the subarray
                count+=right-left+1;
            }
        }
        return count;
    }
}