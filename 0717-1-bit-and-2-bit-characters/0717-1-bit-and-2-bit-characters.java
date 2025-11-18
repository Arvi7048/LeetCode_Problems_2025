class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        while (i < n - 1) {
            if (bits[i] == 1) {
                // 2-bit character: skip next index
                i += 2;
            } else {
                // 1-bit character
                i += 1;
            }
        }

        // If pointer stops at last index, it's a 1-bit character
        return i == n - 1;
    }
}
