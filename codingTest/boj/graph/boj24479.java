// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.Iterator;
// import java.util.LinkedList;
// import java.util.StringTokenizer;

// public class boj24479 {
//     private static boolean[] visit;
//     private static ArrayList<Graph> vertex;
//     private static StringBuilder sb;
//     private static int initV;
//     public static void main(String[] args) throws NumberFormatException, IOException {
//         // 1. Check input validation & initialization
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         sb = new StringBuilder();
//         StringTokenizer st = new StringTokenizer(br.readLine());
        
//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());
//         initV = Integer.parseInt(st.nextToken());
        
//         visit = new boolean[n + 1];
//         for (int i = 0; i <= n; i++) {
//             visit[i] = false;
//         }

//         vertex = new ArrayList<>();
//         for (int i = 1; i <= n; i++) {
//             vertex.add(new Graph(i));
//         }

//         for (int i = 1; i <= m; i++) {
//             st = new StringTokenizer(br.readLine());
            
//             int fromV = Integer.parseInt(st.nextToken());
//             int toV = Integer.parseInt(st.nextToken());

//             vertex.get(fromV).addEdge(toV);
//         }
        
//         // 2. Biz logic
//         dfs(initV);
//         sb.append(0);

//         // 3. End
//         System.out.println(sb);    
//     }

//     private static void dfs(int v) {
//         visit[v] = true;

//         sb.append(v).append('\n');

//         vertex.get(v).getEdgeList().sort(Comparator.naturalOrder());
//         Iterator<Integer> toVList =  vertex.get(v).getEdgeList().iterator();

//         while (toVList.hasNext()) {
//             int toV = toVList.next();
//             if (visit[toV] == false) {
//                 dfs(toV);
//             }
//         }
//     }

// }

// class Graph {
//     private int v;
//     private LinkedList<Integer> edge;

//     Graph(int v) {
//        this.v = v;
//        this.edge = new LinkedList<>();
//     }
    
//     public void addEdge(int targetEdge) {
//         edge.add(targetEdge);
//     }
//     public LinkedList<Integer> getEdgeList() {
//         return this.edge;
//     }
// }
