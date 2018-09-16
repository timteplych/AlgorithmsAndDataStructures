package ru.ttv.algorithms.lesson7;

public class Graph {
    private class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label, boolean wasVisited) {
            this.label = label;
            this.wasVisited = wasVisited;
        }

        @Override
        public String toString() {
            return "V: "+label;
        }
    }

    private final int MAX_VERTICES;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int size;

    public Graph(int maxSize) {
        this.MAX_VERTICES = size;
        vertices = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        size = 0;
    }


}
