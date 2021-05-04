package edu.birzeit.dijkstra;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Driver {
    public static void main(String[] args) {
        Vertex vertexA = new Vertex(new Country("A"));
        Vertex vertexB = new Vertex(new Country("B"));
        Vertex vertexC = new Vertex(new Country("C"));
        Vertex vertexD = new Vertex(new Country("D"));
        Vertex vertexE = new Vertex(new Country("E"));
        Vertex vertexF = new Vertex(new Country("F"));

        vertexA.addAdjacent(vertexB, 10);
        vertexA.addAdjacent(vertexC, 15);

        vertexB.addAdjacent(vertexD, 12);
        vertexB.addAdjacent(vertexF, 15);

        vertexD.addAdjacent(vertexE, 2);
        vertexD.addAdjacent(vertexF, 1);

        vertexF.addAdjacent(vertexE, 5);

        Graph graph = new Graph();
        graph.addNode(vertexA);
        graph.addNode(vertexB);
        graph.addNode(vertexC);
        graph.addNode(vertexD);
        graph.addNode(vertexE);
        graph.addNode(vertexF);

        calculateShortestPathFromSource(vertexA);
        System.out.println(vertexE.getDistance());
        vertexE.getShortestPath().forEach(vertex -> {
            System.out.print(vertex.getCountry().getCountryName() + " -> ");
        });
    }

    public static void calculateShortestPathFromSource(Vertex source) {
        source.setDistance(0);

        PriorityQueue<Vertex> verticesHeap = new PriorityQueue<>();

        verticesHeap.add(source);

        while (verticesHeap.size() != 0) {
            Vertex currentVertex = verticesHeap.poll();
            //iterate for each adjacent vertex of the current vertex
            currentVertex.getAdjacentVertices().forEach((vertex, distance) -> {
                if (!vertex.isKnown()) {
                    // set new value for the vertex if the distance from the current vertex
                    // less then the already calculated distance
                    // and set the shortest path
                    if (currentVertex.getDistance() + distance < vertex.getDistance()) {
                        vertex.setDistance(currentVertex.getDistance() + distance);
                        // get the shortest path from the source to the current
                        // add the the current
                        // set it as the shortest path to the vertex
                        List<Vertex> shortestPath = new LinkedList<>(currentVertex.getShortestPath());
                        shortestPath.add(currentVertex);
                        vertex.setShortestPath(shortestPath);
                    }
                    verticesHeap.add(vertex);
                }
            });
            currentVertex.setKnown(true);
        }
    }
}
