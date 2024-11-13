package org.example;

import java.util.ArrayList;
import java.util.List;

class Node {
    int id;
    int value;
    List<Edge> edges;
    boolean visited;

    public Node(int id, int value) {
        this.id = id;
        this.value = value;
        this.edges = new ArrayList<>();
        this.visited = false;
    }

    public void addEdge(Node target, int weight) {
        this.edges.add(new Edge(target, weight));
    }

    @Override
    public String toString() {
        return "Node{id=" + id + ", value=" + value + "}";
    }
}