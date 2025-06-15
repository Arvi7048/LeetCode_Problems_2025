class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        char[] maxChars = s.toCharArray();
        char[] minChars = s.toCharArray();

        // For max value: replace first non-9 digit with 9
        char toReplaceMax = 0;
        for (char c : maxChars) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        if (toReplaceMax != 0) {
            for (int i = 0; i < maxChars.length; i++) {
                if (maxChars[i] == toReplaceMax) {
                    maxChars[i] = '9';
                }
            }
        }

        // For min value: replace first digit that's not 1 with 1 (if at start)
        char toReplaceMin = 0;
        if (minChars[0] != '1') {
            toReplaceMin = minChars[0];
            for (int i = 0; i < minChars.length; i++) {
                if (minChars[i] == toReplaceMin) {
                    minChars[i] = '1';
                }
            }
        } else {
            for (int i = 1; i < minChars.length; i++) {
                if (minChars[i] != '0' && minChars[i] != '1') {
                    toReplaceMin = minChars[i];
                    break;
                }
            }
            if (toReplaceMin != 0) {
                for (int i = 0; i < minChars.length; i++) {
                    if (minChars[i] == toReplaceMin) {
                        minChars[i] = '0';
                    }
                }
            }
        }

        int maxNum = Integer.parseInt(new String(maxChars));
        int minNum = Integer.parseInt(new String(minChars));
        return maxNum - minNum;
    }
}
