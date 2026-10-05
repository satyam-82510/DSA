class Solution {
    private void dfs(int sr, int sc,int [][] ans, int [][]image, int color,int[]dRow, int dCol[], int initialcolor){

    ans[sr][sc]=color;
    int n= image.length;
    int m= image[0].length;
    for(int i=0;i<4; i++){
      int nrow= sr+ dRow[i];
      int ncol=sc+ dCol[i];
      if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==initialcolor && image[nrow][ncol]!=color){
       dfs(nrow,ncol,ans,image,color,dRow,dCol,initialcolor);
      }
    }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int initialcolor= image[sr][sc];
    int[][] ans= image;
    int dRow[]= {-1,0,1,0};
    int dCol[]= {0,1,0,-1};
    dfs(sr,sc,ans,image,color,dRow,dCol,initialcolor);
    return ans;
    }
}