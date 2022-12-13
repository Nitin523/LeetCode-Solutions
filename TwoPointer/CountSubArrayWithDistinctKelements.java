/*A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
**/




class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k)- atmost(nums, k-1);      //exact k = atmost(k)- atmost(k-1)
    }
    
    public int atmost(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        int r=0;
        int count=0;
        while(r<nums.length){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);    // insert element at right pointer to the map or increase the element count
            while(map.size()>k){                             // If map size is within the sliding window size then do the calculations else increase the window size
                if(map.get(nums[i])>1){                      // If count of next element to insert into window and in map is greater than 1 means duplicate ele then                                                                   reduce the count and increase window size
                    map.put(nums[i], map.get(nums[i])-1);
                }else{
                    map.remove(nums[i]);                        // if ele is only 1st time then remove that element from map while increasing the window
                }
                i++;                                            // increase the left pointer
            }
            count=count+r-i+1;                              // count is window max-start+1 as window size gives us the distinct element count in that window
            r++;                                                // increase the window size
        }
        return count;
    }
}
