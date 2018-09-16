package ru.ttv.algorithms.lesson7;

import ru.ttv.algorithms.lesson3.Queue;
import ru.ttv.algorithms.lesson3.Stack;

public class Graph {
    private class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label) {
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

    public void addVertex(char label){
        vertices[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void showVertex(int vertex){
        System.out.println(vertices[vertex]);
    }

    private int getUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMatrix[ver][i] == 1 && !vertices[i].wasVisited) return i;
        }
        return -1;
    }

    public void depthTraverse(){
        Stack stack = new Stack(MAX_VERTICES);
        vertices[0].wasVisited = true;
        showVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v = getUnvisitedVertex(stack.peek());
            if(v == -1){
                stack.pop();
            }else {
                vertices[v].wasVisited = true;
                showVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }

    public void widthTreverse(){
        Queue queue = new Queue(MAX_VERTICES);
        vertices[0].wasVisited = true;
        showVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()){
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1){
                vertices[vNext].wasVisited = true;
                showVertex(vNext);
                queue.insert(vNext);
            }
        }
        resetFlags();
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }


}
