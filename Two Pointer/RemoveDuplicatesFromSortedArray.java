// Notes:
// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
// array is never empty


class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] arr) { 
        int i=0, j=1;
        int counter=0;                    //either set counter to 1 or return counter+1 because 1st element is always there
        
        while(j<arr.length){
            if(arr[i]==arr[j]){
                j++;
            }
            else if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
                j++;
                counter++;
            }
        }
        return counter+1;
    }
}