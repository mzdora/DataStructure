import java.util.ArrayList;
import java.util.List;

public class CC {
    private Graph g;
    private int countCC;
    private boolean[] visited;
    private List<List<Integer>> list = new ArrayList<List<Integer>>();

    public CC(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        countCC = 0;
        for (int v = 0; v < g.V(); v++) {
            if( !visited[v] ) {
                list.add(new ArrayList<>());
                bfs(v);
                countCC++;
            }
        }
    }

    public void bfs(int v){
        visited[v] = true;
        list.get(countCC).add(v);
        for (int w : g.adj(v)){
            if (!visited[w]){
                bfs(w);
            }
        }
    }

    public static void main(String[] args) {
        CC c = new CC(new Graph("g.txt"));
        System.out.println(c.list);

    }

}
