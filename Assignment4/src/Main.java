public class Main {
    public static void main(String[] args) {
        Graph_Representation graph = new Graph_Representation();
        graph.add_edge('B', 'A', 3);
        graph.add_edge('C', 'A', 14);
        graph.add_edge('D', 'C', 15);
        graph.add_edge('E', 'A', 14);
        graph.add_edge('F', 'D', 13);
        graph.add_edge('G', 'F', 8);
        graph.add_edge('A', 'D', 15);
        graph.add_edge('G', 'B', 7);
        graph.add_edge('F', 'C', 12);
        graph.add_edge('F', 'E', 14);
        graph.add_edge('C', 'B', 13);
        graph.printGraph();

        graph.DFS('F');
        graph.BFS('F');
        graph.dijkstra('B');
    }
}