package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();

        Node node5 = graph.createNode(5);
        Node node1 = graph.createNode(1);
        Node node5b = graph.createNode(5);
        Node node12 = graph.createNode(12);
        Node node43 = graph.createNode(43);
        Node node36 = graph.createNode(36);
        Node node14 = graph.createNode(14);
        Node node10 = graph.createNode(10);
        Node node15 = graph.createNode(15);
        Node node40 = graph.createNode(40);
        Node node1b = graph.createNode(1);
        Node node3 = graph.createNode(3);
        Node node4 = graph.createNode(4);
        Node node19 = graph.createNode(19);
        Node node20 = graph.createNode(20);

        graph.addEdge(node5, node1, 193);
        graph.addEdge(node1, node5b, 12);
        graph.addEdge(node1, node12, 150);
        graph.addEdge(node12, node43, 23);
        graph.addEdge(node12, node36, 27);
        graph.addEdge(node5, node14, 132);
        graph.addEdge(node14, node10, 48);
        graph.addEdge(node14, node15, 21);
        graph.addEdge(node5, node40, 145);
        graph.addEdge(node40, node1b, 4);
        graph.addEdge(node40, node3, 30);
        graph.addEdge(node40, node4, 78);
        graph.addEdge(node4, node19, 57);
        graph.addEdge(node4, node20, 30);

        graph.traverseGreedy(node5, 485);

    }
}