class Solution {
       public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        
        String commonPrefix = strings[0];

        //if while condition fails that means our common prefix is answer with that string at specific index but we have to check further.
        
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(commonPrefix) != 0) {
                System.out.println(strings[i] + " - " + commonPrefix);
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);  //decrement the size of common prefix
            }
        }
        return commonPrefix;
    }
}
