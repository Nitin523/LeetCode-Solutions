/*

logic here is to visit every adjacent node and keep track of parent for each node.
If there exists some condition such that parent of visiting node != current adjacent node this means someone already
has visited it 

*/




class Pair{
    int adjacent;
    int parent;
    public Pair(int adj, int par){
        this.parent = par;
        this.adjacent = adj;
    }
}

class Solution {
    
    public static boolean detectCycle(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while(!q.isEmpty()){
            int node = q.peek().adjacent;
            int parent = q.peek().parent;
            q.remove();
            for(int i:adj.get(node)){
                if(!vis[i]){
                    vis[i]=true;
                    q.add(new Pair(i, node));
                }
                else if(parent != i){                      // i is current adjacent node
                    return true;
                }
            }
        }
            return false;
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]= new boolean[V];
        for(int i=0;i<V;i++) vis[i]=false;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(detectCycle(i, vis, adj)) return true;
            }
        }
        return false;
    }
}