import java.util.*;

class Solution {
    boolean isSafe(List<String> board, int row, int col, int n) {
        // Horizontal check
        for (int j = 0; j < n; j++) {
            if (board.get(row).charAt(j) == 'Q') 
                return false;
        }
        // Vertical check
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') 
                return false;
        }
        // Left diagonal check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') 
                return false;
        }
        // Right diagonal check
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') 
                return false;
        }
        return true;
    }

    void nQueen(List<String> board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                // Convert string to StringBuilder for modification
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(j, 'Q'); // Place Queen
                
                board.set(row, newRow.toString()); // Update board row
                
                nQueen(board, row + 1, n, ans);
                
                // Backtrack: Reset to '.'
                newRow.setCharAt(j, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();

        // Initialize board with "....." (n dots per row)
        String row = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(row);
        }

        List<List<String>> ans = new ArrayList<>();
        nQueen(board, 0, n, ans);
        return ans;
    }
}
