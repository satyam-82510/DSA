// //This code is for the distance of nearest one(1) for each cell and below one is code of distance of nearest 0 for each cell
// class Pair{
//     int first;
//     int second;
//     int third;
//     Pair(int first,int second,int third){
//         this.first= first;
//         this.second= second;
//         this.third= third; //this is step only 
//     }
// }
// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//      int n = mat.length;
//      int m = mat[0].length;
//      int vis[][] = new int[n][m];
//      int dist[][] = new int[n][m];// as we never alter the data or given array ( never modifiy a given array or data )
//      Queue<Pair> q= new LinkedList<Pair>();
//      for(int i=0;i<n;i++){
//         for(int j=0;j<m;j++){
//              if(mat[i][j]==1){ // only this line make the change for (==0) if distance of the nearest 0 or (==1) for distance of the nearest 1 for each cell
//                 q.add(new Pair(i,j,0));
//                 vis[i][j]=1;
//             } else{
//                 vis[i][j]=0;
//             }
//         }
//      }

//      int dRow[] = {-1,0,1,0};
//      int dCol[] = {0,1,0,-1};
    
//     while(!q.isEmpty()){
//        int row= q.peek().first;
//        int col= q.peek().second;
//        int steps= q.peek().third;
//        q.remove();
//        dist[row][col]=steps;
//        for(int i=0;i<4;i++){
//         int nrow= row+dRow[i];
//         int ncol= col+dCol[i];
//         if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
//             vis[nrow][ncol]=1;
//             q.add(new Pair(nrow,ncol,steps+1));
//         }
//        }
//     }
//     return dist;
//     }
// }

//This code of distance of nearest 0
class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        // Step 1: Push all 0s to queue and mark them visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        // Direction arrays for Up, Right, Down, Left
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        // Step 2: Multi-source BFS
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int steps = curr.dist;

            dist[r][c] = steps;

            for (int i = 0; i < 4; i++) {
                int nrow = r + dRow[i];
                int ncol = c + dCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }
}