class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);

        // MAX: Replace first non-9 digit with 9
        char replaceMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                replaceMax = c;
                break;
            }
        }
        String maxStr = (replaceMax == ' ') ? s : s.replace(replaceMax, '9');

        // MIN: Replace first digit that's not the same as s[0] with 0
        char replaceMin = s.charAt(0);
        String minStr = s.replace(replaceMin, '0');

        int maxNum = Integer.parseInt(maxStr);
        int minNum = Integer.parseInt(minStr);

        return maxNum - minNum;
    }
}
