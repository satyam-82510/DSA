    class Pair{
        int first; 
        int second;
        public Pair(int first, int second){
            this.first= first;
            this.second= second;
        }
    }
    
class Solution {
    private void bfs(int row, int col, int [][]vis, char [][]grid){
        vis[row][col]=1;
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(row,col));
        int n= grid.length;
        int m = grid[0].length;

        //4 directions : Up , Right,  Down, Left'
            int [] dRow= {-1,0,1,0};
            int [] dCol= {0,1,0,-1};

        while(!q.isEmpty()){
           int  r= q.peek().first;
           int  c= q.peek().second;
            q.remove();

            for(int i=0; i<4; i++){
              int nrow= r + dRow[i];
              int ncol= c+ dCol[i];   
            
            // for(int delrow=-1;delrow<=1; delrow++){// it is a 8 direction concept geekforgeek prblem , in leet platform problem allowed only 4 direction so not use this otherwise testcase fail or give error
            //     for(int delcol=-1;delcol<=1; delcol++){
            //         int nrow= r + delrow;
            //         int ncol= c+ delcol; 


                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }

                
            }
        }

    }

    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int[][] vis = new int[n][m];
        int cnt= 0;
        for (int row=0; row<n; row++){
            for (int col=0; col<m; col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return cnt;
    }
}