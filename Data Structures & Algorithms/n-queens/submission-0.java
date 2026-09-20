class Solution {
    public java.util.List<java.util.List<String>> solveNQueens(int n) {
        java.util.List<java.util.List<String>> result =
            new java.util.ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(board[i], '.');
        }

        backtrack(0, n, board, result);

        return result;
    }

    private void backtrack(
        int row,
        int n,
        char[][] board,
        java.util.List<java.util.List<String>> result
    ) {
        if (row == n) {
            java.util.List<String> solution =
                new java.util.ArrayList<>();

            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }

            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';

                backtrack(row + 1, n, board, result);

                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(
        char[][] board,
        int row,
        int col,
        int n
    ) {
        // Column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}