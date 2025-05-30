import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;

            // a. Try to fit as many words as possible in this line
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int numWords = j - i;
            int totalSpaces = maxWidth - (lineLen - (numWords - 1));
            StringBuilder line = new StringBuilder();

            // b. If it's the last line or contains only one word
            if (j == words.length || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) line.append(" ");
                }
                // Fill the remaining spaces
                int remaining = maxWidth - line.length();
                while (remaining-- > 0) line.append(" ");
            } else {
                int spaces = totalSpaces / (numWords - 1);
                int extra = totalSpaces % (numWords - 1);

                for (int k = i; k < j - 1; k++) {
                    line.append(words[k]);
                    for (int s = 0; s < spaces; s++) line.append(" ");
                    if (extra-- > 0) line.append(" ");
                }
                line.append(words[j - 1]); // last word
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
