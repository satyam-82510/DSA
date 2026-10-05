// TC= (V+E)
// SC = (V)
class Solution {
    private boolean checkbipBFS(int start, int[] color, int[][]graph){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        color[start]=0;

        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int it : graph[node]){
                if (color[it]==-1){
                    color[it]= 1- color[node];// opposite color(learn concept of compliment like this only)
                    q.add(it);
                }else if (color[it]== color[node]){
                    return false;
                }
            }
           
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
       int n = graph.length;
       int color[]= new int[n];
       Arrays.fill(color, -1);

       for(int i=0;i<n;i++){
        if (color[i]==-1){
            if(checkbipBFS(i,color,graph)== false){
                return false;
            }
        }
       }
       return true;
    }
}