import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * 给点x,y找出从x到y的路径
 */
public class SinglePath {
    Graph g;
    int orgin;
    boolean[] visited;
    int[] pre;

    public SinglePath(Graph g,int orgin) {
        this.g = g;
        this.orgin = orgin;
        this.pre = new int[g.V()];
        visited = new boolean[g.V()];
        bfs(orgin,orgin);
    }

    public void bfs(int v,int parent){
        visited[v] = true;
        pre[v] = parent;
        for (int w:g.adj(v)){
            if ( !visited[w] ){
                bfs(w,v);
            }
        }
    }

    public List<Integer> findPath(int end){
        List<Integer> list = new ArrayList<>();
        if (!isConnected(end)) return list;
        while(end != orgin){
            list.add(end);
            end = pre[end];
        }
        list.add(orgin);
        Collections.reverse(list);
        return list;
    }

    private boolean isConnected(int d){
        return visited[d];
    }

    public static void main(String[] args) {
        SinglePath sp = new SinglePath(new Graph("g.txt"),6);
        System.out.println(sp.findPath(4));
    }
}
