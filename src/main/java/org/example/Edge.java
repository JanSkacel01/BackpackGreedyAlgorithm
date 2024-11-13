package org.example;

class Edge {
    Node target;
    int weight;
    boolean traversed;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
        this.traversed = false;
    }

    @Override
    public String toString() {
        return "Edge{targetId=" + target.id + ", weight=" + weight + "}";
    }
}
