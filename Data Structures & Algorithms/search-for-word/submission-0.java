class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                         int r, int c, int index) {

        // Found the entire word
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return false;
        }

        // Wrong character
        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark this cell as visited
        char original = board[r][c];
        board[r][c] = '#';

        // Explore 4 directions
        boolean found =
            dfs(board, word, r + 1, c, index + 1) ||
            dfs(board, word, r - 1, c, index + 1) ||
            dfs(board, word, r, c + 1, index + 1) ||
            dfs(board, word, r, c - 1, index + 1);

        // Backtrack: restore the cell
        board[r][c] = original;

        return found;
    }
}