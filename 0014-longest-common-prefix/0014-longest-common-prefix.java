class Solution {
    public String longestCommonPrefix(String[] str) {
        int n = str.length;
        if(str == null || n == 0){
            return "";
        }
        Arrays.sort(str);
        String first = str[0];
        String last = str[n-1];
        int i = 0;
        while(i<first.length() && i< last.length() && first.charAt(i) == last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }
}