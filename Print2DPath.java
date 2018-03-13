import java.util.ArrayList;
import java.util.List;

public class PrintAllPath2D {
    public List<String> PrintAllPath(char[][] grid) {
        List<String> result = new ArrayList<>();
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(grid, 0, 0, sb, result);
        return result;
    }
    private void dfs(char[][] grid, int r, int c, StringBuilder sb, List<String> result) {
        int len = sb.length();
        sb.append(grid[r][c]+"->");
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            result.add(new String(sb));
            sb.setLength(len);
            return;
        }
        if (r + 1 < grid.length) {
            dfs(grid, r + 1, c, sb, result);
        }
        if (c + 1 < grid[0].length) {
            dfs(grid, r, c + 1, sb, result);
        }
        sb.setLength(len);
    }
}
