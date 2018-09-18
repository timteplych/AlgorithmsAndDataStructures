package ru.ttv.algorithms.lesson7;

import ru.ttv.algorithms.lesson3.Queue;
import ru.ttv.algorithms.lesson3.Stack;

import java.util.Arrays;

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
    private int[] dist;
    private int[] parent;

    public Graph(int maxSize) {
        this.MAX_VERTICES = maxSize;
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
    private int getUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMatrix[ver][i] == 1 && !vertices[i].wasVisited) return i;
        }
        return -1;
    }

    public void calcShortPath(){
        Queue queue = new Queue(MAX_VERTICES);
        dist = new int[MAX_VERTICES];
        parent = new int[MAX_VERTICES];
        int inf = Integer.MAX_VALUE/2;
        Arrays.fill(dist,inf);
        dist[0] = 0;
        parent[0] = 0;
        vertices[0].wasVisited = true;
        //showVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()){
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1){
                vertices[vNext].wasVisited = true;
                if(dist[vNext] > dist[vCurr] + 1){
                    //showVertex(vNext);
                    dist[vNext] = dist[vCurr]+1;
                    parent[vNext] = vCurr;
                    queue.insert(vNext);
                }
            }
        }
        resetFlags();
    }

    public void showShortPath(int vertex){
        if (parent[vertex] != vertex) {
            showShortPath(parent[vertex]);
        }
        System.out.printf("%d ",vertex);
    }


}
