/*Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

**/



class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();         //maintaing a set to store occurrence of character for the window
        int left=0;
        int right=0;
        int max=0;
        while(left<s.length() && right<s.length()){
            if(!set.contains(s.charAt(right))){          // if character doesn't seen already then insert into set itereate to next char and store length of the substring
                set.add(s.charAt(right));
                right++;
                max=Math.max(max, right-left);
            }else{                                  // if letter is seen then increase the window from left
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}