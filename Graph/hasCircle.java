public class hasCircle {
    Graph g;
    boolean visited[];
    boolean hasCircle = false;

    public hasCircle(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            if(!visited[v]){
                dfs(v,v);
            }
        }
    }

    private void dfs(int v,int father){
        visited[v] = true;
        for(int w:g.adj(v)){
            if (!visited[w]){
                dfs(w,v);
            }else{
                if(father != w) hasCircle = true;
            }
        }
    }

    public static void main(String[] args) {
        hasCircle hc = new hasCircle(new Graph("g2.txt"));
        System.out.println(hc.hasCircle);
    }
}
