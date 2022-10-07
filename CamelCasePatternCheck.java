/*Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.

A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.
Example 1:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".  

**/




class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List answer = new ArrayList<>();
        char[] pA=pattern.toCharArray();
        for(String query:queries){
        answer.add(match(query,pA));
        }
        return answer;
}
    
    private boolean match(String original,char pattern[]){
    char[] arr=original.toCharArray();
    int pC=0;
    for(int i=0;i<arr.length;i++){
        if(pC<pattern.length && arr[i]==pattern[pC]){pC++;}
        else{
            if(arr[i]<'a' || arr[i]>'z'){return false;}   //if the letter is capital after                                                                pattern is over
        }
    }
    if(pC!=pattern.length){    //if pattern length is not equal to the count 
        return false;
    }
    return true;
}

}