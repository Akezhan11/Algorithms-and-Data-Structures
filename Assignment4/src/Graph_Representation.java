import java.util.*;

class Edge {
    char destination;
    int weight;

    public Edge (char destination, int weight){
        this.destination= destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return destination + "(bridge:" + weight + ")";
    }
}

public class Graph_Representation {
    private Map<Character, List<Edge>> adj = new HashMap<>();
    private final boolean undirected = true;

    public boolean hasVertex(char source){
        return adj.containsKey(source);
    }

    public boolean hasEdge(char source, char dest){
        if(!hasVertex(source)){
            return false;
        }
        List<Edge> edges = adj.get(source);
        for(Edge edge : edges){
            if(edge.destination == dest){
                return true;
            }
        }
        return false;
    }

    public void add_vertex(char v){
        adj.putIfAbsent(v, new ArrayList<>());
    }

    public void add_edge(char v, char w, int weight){
        if(!hasVertex(v)){
            add_vertex(v);
        }
        if(!hasVertex(w)){
            add_vertex(w);
        }
        if(hasEdge(v,w) || (v == w)){
            return;
        }
        adj.get(v).add(new Edge(w, weight));
        if (undirected){
            adj.get(w).add(new Edge(v, weight));
        }
    }

    public void printGraph(){
        for (Character vertex : adj.keySet()) {
            List<Edge> edges = adj.get(vertex);
            System.out.println("Vertex " + vertex + ": " + edges);
        }
    }
    public void DFS(char startVertex) {
        Set<Character> visited = new HashSet<>();
        if (!adj.containsKey(startVertex)) {
            return;
        }
        visitNode(startVertex, visited);
        for (Character vertex : adj.keySet()) {
            if (!visited.contains(vertex)) {
                visitNode(vertex, visited);
            }
        }
        System.out.println();
    }

    private void visitNode(char v, Set<Character> visited) {
        visited.add(v);
        System.out.print(v + " ");

        if (!adj.containsKey(v)) return;

        for (Edge edge : adj.get(v)) {
            if (!visited.contains(edge.destination)) {
                visitNode(edge.destination, visited);
            }
        }
    }
    public void BFS(char startVertex) {
        if (!adj.containsKey(startVertex)) {
            return;
        }
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        visited.add(startVertex);
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.print(current + " ");
            if (!adj.containsKey(current)) continue;
            for (Edge edge : adj.get(current)) {
                if (!visited.contains(edge.destination)) {
                    visited.add(edge.destination);
                    queue.add(edge.destination);
                }
            }
        }
        System.out.println();
    }
    class NodeRecord {
        char vertex;
        int distance;

        public NodeRecord(char vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
    public void dijkstra(char startVertex) {

        if (!adj.containsKey(startVertex)) {
            System.out.println("Error: there is no such starting vertex");
            return;
        }
        Map<Character, Integer> distances = new HashMap<>();
        Map<Character, Character> previousNodes = new HashMap<>();
        PriorityQueue<NodeRecord> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        for (Character vertex : adj.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);
        pq.add(new NodeRecord(startVertex, 0));

        while (!pq.isEmpty()) {
            NodeRecord current = pq.poll();
            char currentVertex = current.vertex;
            int currentDistance = current.distance;
            if (currentDistance > distances.get(currentVertex)) {
                continue;
            }
            if (adj.containsKey(currentVertex)) {
                for (Edge edge : adj.get(currentVertex)) {
                    char neighbor = edge.destination;
                    int newDistance = currentDistance + edge.weight;
                    if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        distances.put(neighbor, newDistance);
                        previousNodes.put(neighbor, currentVertex);
                        pq.add(new NodeRecord(neighbor, newDistance));
                    }
                }
            }
        }

        for (Character targetVertex : distances.keySet()) {
            int dist = distances.get(targetVertex);
            if (dist == Integer.MAX_VALUE) {
                System.out.println("To " + targetVertex + " -> No path");
            } else {
                String path = buildPath(startVertex, targetVertex, previousNodes);
                System.out.println("To " + targetVertex + " Distance: " + dist + ", path: " + path);
            }
        }
    }
    private String buildPath(char start, char end, Map<Character, Character> previousNodes) {
        if (start == end) return String.valueOf(start);
        List<Character> path = new ArrayList<>();
        char current = end;

        while (current != start) {
            path.add(current);
            current = previousNodes.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) sb.append("  ");
        }
        return sb.toString();
    }
}