package org.example;

import java.util.*;

public class GraphTraversal {
    private Map<Integer, Node> nodes;
    private int nextId = 1;

    public GraphTraversal() {
        nodes = new HashMap<>();
    }

    public Node createNode(int value) {
        int id = nextId++;
        Node node = new Node(id, value);
        nodes.put(id, node);
        return node;
    }

    public void addEdge(Node source, Node target, int weight) {
        source.addEdge(target, weight);
        target.addEdge(source, weight);
    }

    public void traverseGreedy(Node startNode, int budget) {
        int step = 0;
        int r = budget;
        int z = 0;
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.traversed ? 0 : e.weight) // Prioritize edges with the lowest weight
        );
        Set<Node> visitedNodes = new HashSet<>();

        // Start with the initial node
        edgeQueue.addAll(startNode.edges);
        visitedNodes.add(startNode);
        z += startNode.value;
        startNode.value = 0;

        System.out.println("[t_" + step++ + "] h_i 0" +", u_i " + z + " -> r= " + r + ", z= " + z + " | Vrchol s hodnotou: " + z);

        while (!edgeQueue.isEmpty() && r > 0) {
            Edge cheapestEdge = edgeQueue.poll();
            Node targetNode = cheapestEdge.target;
            int cost = cheapestEdge.traversed ? 0 : cheapestEdge.weight;

            // Skip if the cost exceeds the remaining budget
            if (cost > r) continue;

            // Traverse this edge and visit the target node
            r -= cost;
            cheapestEdge.traversed = true;

            // Collect resources from the target node if not already visited
            if (!visitedNodes.contains(targetNode)) {
                z += targetNode.value;
                System.out.println("[t_" + step++ + "] h_i " + cost + ", u_i " + targetNode.value + " -> r= " + r + ", z= " + z + " | Vrchol s hodnotou: " + targetNode.value);

                targetNode.value = 0; // Mark resources as collected
                visitedNodes.add(targetNode);

                // Add the target node's edges to the priority queue for further exploration
                for (Edge edge : targetNode.edges) {
                    if (!visitedNodes.contains(edge.target)) {
                        edgeQueue.add(edge);
                    }
                }
            }
        }

        System.out.println("r= " + r + ", z= " + z + " jsou nyní výsledné hodnoty.");
    }
}