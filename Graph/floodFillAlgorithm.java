//Flood Fill Algorithm

// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

// You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
// plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

// Return the modified image after performing the flood fill.



/*
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

 */

public class floodFillAlgorithm {
    public static void dfs(int row, int col, int[][] image, int[][] ans, int newColor, int[] deltaRow,   int[] deltaCol, int initialColor){
        ans[row][col]= newColor;
        int n = image.length;
        int m = image[0].length;

         for(int i=0;i<4;i++){
             int nRow = row + deltaRow[i];
             int nCol = col + deltaCol[i];
             if(nRow>=0 && nRow<n && nCol>=0 && nCol>=0 && nCol<m && image[nRow][nCol]==initialColor &&   ans[nRow][nCol]!= newColor){
                 dfs(nRow, nCol, image, ans, newColor, deltaRow, deltaCol, initialColor);
             }
         }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans = image;
        int initialColor = image[sr][sc];
        int[] deltaRow = {-1, 0, +1, 0};
        int[] deltaCol = {0, +1, 0, -1};
        dfs(sr, sc, image, ans, newColor, deltaRow, deltaCol, initialColor);
        return ans;
    }
}