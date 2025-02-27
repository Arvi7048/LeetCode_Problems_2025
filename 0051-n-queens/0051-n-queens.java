import java.util.*;

class Solution {
    void solve(int row, int n, char[][] board, List<List<String>> ans, 
               boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            // Convert board to result format
            List<String> temp = new ArrayList<>();
            for (char[] line : board) {
                temp.add(new String(line));
            }
            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols[col] || diag1[row - col + n - 1] || diag2[row + col]) {
                continue; // Skip invalid positions
            }

            // Place the queen
            board[row][col] = 'Q';
            cols[col] = diag1[row - col + n - 1] = diag2[row + col] = true;

            // Recur to the next row
            solve(row + 1, n, board, ans, cols, diag1, diag2);

            // Backtrack
            board[row][col] = '.';
            cols[col] = diag1[row - col + n - 1] = diag2[row + col] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Hash sets to track occupied columns and diagonals
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // Left diagonal (row - col)
        boolean[] diag2 = new boolean[2 * n - 1]; // Right diagonal (row + col)

        solve(0, n, board, ans, cols, diag1, diag2);
        return ans;
    }
}
