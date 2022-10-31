// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.Iterator;
// import java.util.LinkedList;
// import java.util.StringTokenizer;

// public class boj24479_v2 {
//     public static void main(String[] args) throws IOException {
//         // 1. Check input validation & initialization
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());
//         int r = Integer.parseInt(st.nextToken());
        
//         Graph graph = new Graph(n);

//         for (int i = 0; i < m; i++) {
//             st = new StringTokenizer(br.readLine());

//             int x = Integer.parseInt(st.nextToken());
//             int y = Integer.parseInt(st.nextToken());

//             graph.addEdgeDouble(x, y);
//         }

//         // 2. Biz logic
//         graph.dfs(r);
        
//         // 3. End
//         graph.printAnswer();
//     }
// }

// class Graph {
//     private int vertexCnt;
//     private ArrayList<LinkedList<Integer>> vertexList;
//     private int visit[];

//     Graph(int vertexCnt) {
//         this.vertexCnt = vertexCnt;
//         vertexList = new ArrayList<>();
//         for (int i = 0; i <= this.vertexCnt; i++) {
//             vertexList.add(new LinkedList<>());
//         }
//     }

//     public ArrayList<LinkedList<Integer>> getVertexList() {
//         return vertexList;
//     }
//     public LinkedList<Integer> getEdgeList(int v) {
//         return vertexList.get(v);
//     }
//     public void addEdgeDouble(int x, int y) {
//         this.getEdgeList(x).add(y);
//         this.getEdgeList(y).add(x);
//     }
//     public void dfs(int v) {
//         int seq = 0;
//         visit = new int[this.vertexCnt + 1];

//         dfsUtil(v, seq);
//     }
//     public void dfsUtil(int v, int seq) {
//         if (visit[v] == 0)
//             visit[v] = ++seq;
        
//         this.getEdgeList(v).sort(Comparator.naturalOrder());
//         Iterator<Integer> edgeList = this.getEdgeList(v).iterator();
//         while (edgeList.hasNext()) {
//             int nextV = edgeList.next();
//             if (visit[nextV] == 0) {
//                 dfsUtil(nextV, seq);
//             }
//         }
//     }
//     public void printAnswer() {
//         StringBuilder sb = new StringBuilder();
//         for (int i = 1; i <= vertexCnt; i++) {
//             sb.append(visit[i]).append('\n');
//         }
//         sb.deleteCharAt(sb.length() - 1);
//         System.out.println(sb);
//     }
    
// }
