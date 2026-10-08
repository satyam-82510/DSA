class Solution {
    static void dfs(int row,int col, int[][]vis, char[][]board, int dRow[], int dCol[]){
        vis[row][col]=1;
        int n = board.length;//phirse define karna padega as pehle globally nhi kiya so due to limited function scope
        int m= board[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+dRow[i];
            int ncol=col+dCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
            dfs(nrow,ncol,vis,board, dRow,dCol);
            }
        }
    }
    public void solve(char[][] board) { //as no return type so not return anything ishbaar hume given data main hi hume change karna hai (karna padega) driver have the input so it get the modified input board as return by itself
        int n = board.length;
        int m= board[0].length;
        int dRow[]= {-1,0,1,0};
        int dCol[]={0,1,0,-1};
        int vis[][]= new int[n][m];
        // Traverse first row and last row
        for(int j=0;j<m;j++){
            //first row 
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,vis,board,dRow,dCol);
            }
            // Last row
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,vis,board,dRow,dCol);
            }
        }
        for(int i=0;i<n;i++){
         //first Column
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,vis,board,dRow,dCol);
            }
            // Last Column
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,vis,board,dRow,dCol);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){//as ek bhi baar dfs k jariye boundary se visit na hua 
                board[i][j]='X';
                }
            }
        }
    }
}