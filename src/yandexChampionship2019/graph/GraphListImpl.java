package yandexChampionship2019.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphListImpl implements Graph {
    List<Node> nodes = new LinkedList<>();

    static class Node {
        private boolean visited = false;
        private String name;
        private final List<GraphListImpl.Node> linkedNodes = new LinkedList<>();

        public Node(String name) {
            this.name = name;
        }
    }

    @Override
    public boolean thereIsWayBetweenNodes(Node a, Node b) {
        if (a == null || b == null)
            return false;

        if (a == b)
            return true;

        if (!nodes.contains(a) || !nodes.contains(b))
            return false;

        List<Node> currentNeighbors = a.linkedNodes;
        List<Node> nextNeighbors = new LinkedList<>();

        boolean finish, found = false;

        while (true) {
            finish = true;
            for (Node node : currentNeighbors) {
                if (node.visited)
                    continue;

                if (b == node) {
                    found = true;
                    break;
                }

                finish = false;
                nextNeighbors.addAll(node.linkedNodes);
            }

            if (finish || found)
                break;

            currentNeighbors.clear();
            currentNeighbors.addAll(nextNeighbors);
            nextNeighbors.clear();
        }

        resumeVisitedFlags();

        return found;
    }

    private void resumeVisitedFlags() {
        nodes.forEach(n -> n.visited = false);
    }
}
