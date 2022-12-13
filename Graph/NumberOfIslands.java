/*
Input:
grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
Output:
2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0 
There are two islands :- one is colored in blue 
and other in orange.

*/




class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIslands {
    public static void bfs(int row, int col, int[][] vis, char[][] grid){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        
        int n= grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            int nRow = q.peek().first;
            int nCol = q.peek().second;
            q.remove();
            
            for(int delRow = -1; delRow<=1 ; delRow++){
                for(int delCol = -1; delCol <= 1 ; delCol++){
                    int neRow = nRow + delRow;
                    int neCol = nCol + delCol;
                    if(neRow>=0 && neRow<n && neCol>=0 && neCol<m 
                        && grid[neRow][neCol]=='1' && vis[neRow][neCol]==0){
                            vis[neRow][neCol]=1;
                            q.add(new Pair(neRow, neCol));
                        }
                }
            }
        }
    }
    
}