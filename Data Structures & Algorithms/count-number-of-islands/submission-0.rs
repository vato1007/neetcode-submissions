impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        let mut grid = grid;
        let rows = grid.len();
        let cols = grid[0].len();
        let directions = [(1i32, 0i32), (-1, 0), (0, 1), (0, -1)];
        let mut islands = 0;

        fn dfs(grid: &mut Vec<Vec<char>>, r: i32, c: i32,
               rows: usize, cols: usize, directions: &[(i32, i32)]) {
            if r < 0 || c < 0 || r >= rows as i32 ||
               c >= cols as i32 || grid[r as usize][c as usize] == '0' {
                return;
            }
            grid[r as usize][c as usize] = '0';
            for &(dr, dc) in directions {
                dfs(grid, r + dr, c + dc, rows, cols, directions);
            }
        }

        for r in 0..rows {
            for c in 0..cols {
                if grid[r][c] == '1' {
                    dfs(&mut grid, r as i32, c as i32, rows, cols, &directions);
                    islands += 1;
                }
            }
        }
        islands
    }
}