/*Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Example 1:

Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]

output =2

Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.


*/



public class NumberOfProvinces {
    private static void dfs(int node, 
    ArrayList<ArrayList<Integer>> adjLs , 
    int vis[]) {
     vis[node] = 1; 
     for(Integer it: adjLs.get(node)) {
         if(vis[it] == 0) {
             dfs(it, adjLs, vis); 
         }
     }
 }
 static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
     ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>(); 
     for(int i = 0;i<V;i++) {
         adjLs.add(new ArrayList<Integer>()); 
     }
     
     // to change adjacency matrix to list 
     for(int i = 0;i<V;i++) {
         for(int j = 0;j<V;j++) {
             // self nodes are not considered 
             if(adj.get(i).get(j) == 1 && i != j) {
                 adjLs.get(i).add(j); 
                 adjLs.get(j).add(i); 
             }
         }
     }
     int vis[] = new int[V]; 
     int cnt = 0; 
     for(int i = 0;i<V;i++) {
         if(vis[i] == 0) {
            cnt++;
            dfs(i, adjLs, vis); 
         }
     }
     return cnt; 
 }
}