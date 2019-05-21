package course2017.module_04;

import java.util.LinkedList;
import java.util.List;

/**
 * Source:      Task01.java
 * Created:     07.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task01} RESOLVING TIME: 1.5h
 *
 * @author dialekz
 */
public class Task01 {

    public static void main(String[] args) {
        Graph.Node start = new Graph.Node();
        Graph.Node node2 = new Graph.Node();
        Graph.Node node3 = new Graph.Node();
        Graph.Node node4 = new Graph.Node();
        Graph.Node node5 = new Graph.Node();
        Graph.Node out   = new Graph.Node();

        Graph graph = new Graph();
        graph.nodes.add(start);
        graph.nodes.add(node2);
        graph.nodes.add(node3);
        graph.nodes.add(node4);
        graph.nodes.add(node5);
        graph.nodes.add(out);

        start.neighbors.add(node2);
        start.neighbors.add(node3);
        start.neighbors.add(node4);
        node4.neighbors.add(node2);
        node4.neighbors.add(node5);

        System.out.println(foo(graph, start, node2));
        System.out.println(foo(graph, start, node3));
        System.out.println(foo(graph, start, node4));
        System.out.println(foo(graph, start, node5));
        System.out.println(foo(graph, node4, node2));
        System.out.println(foo(graph, node4, node5));

        System.out.println();

        System.out.println(!foo(graph, start, out));
        System.out.println(!foo(graph, node4, out));
        System.out.println(!foo(graph, node2, start));
        System.out.println(!foo(graph, node2, node4));
        System.out.println(!foo(graph, node2, node3));
    }

    private static class Graph {
        List<Node> nodes = new LinkedList<>();

         static class Node {
            private boolean visited = false;
            private final List<Graph.Node> neighbors = new LinkedList<>();
        }
    }

    private static boolean foo(Graph graph, Graph.Node a, Graph.Node b) {
        if (a == null || b == null)
            return false;

        if (a == b)
            return true;

        if (!graph.nodes.contains(a) || !graph.nodes.contains(b))
            return false;

        List<Graph.Node> currentNeighbors = a.neighbors;
        List<Graph.Node> nextNeighbors = new LinkedList<>();

        boolean finish, found = false;

        while (true) {
            finish = true;
            for (Graph.Node node : currentNeighbors) {
                if (node.visited)
                    continue;

                if (b == node) {
                    found = true;
                    break;
                }

                finish = false;
                nextNeighbors.addAll(node.neighbors);
            }

            if (finish || found)
                break;

            currentNeighbors.clear();
            currentNeighbors.addAll(nextNeighbors);
            nextNeighbors.clear();
        }

        for (Graph.Node node : graph.nodes) {
            node.visited = false;
        }

        return found;
    }
}
