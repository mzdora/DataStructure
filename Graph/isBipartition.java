public class isBipartition {
    Graph g;
    boolean[] visited;
    int[] color;
    boolean isBipartition = true;

    public isBipartition(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        color = new int[g.V()];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int v = 0; v < g.V(); v++) {
            if (!visited[v]){
                color[v] = 0;
                dfs(v);
            }
        }
    }

    private void dfs(int v){
        visited[v] = true;
        for (int w:g.adj(v)){
            if (!visited[w]){
                color[w] = 1-color[v];
                dfs(w);
            }else{
                if(color[v] == color[w]) isBipartition = false;
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph("g2.txt");
        isBipartition ib = new isBipartition(g);
        System.out.println(ib.isBipartition);
    }
}
