class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Adjust for 0-indexing
            sb.append((char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
