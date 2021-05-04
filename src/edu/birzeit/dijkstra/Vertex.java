package edu.birzeit.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vertex implements Comparable{
    private Country country;
    private List<Vertex> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    private boolean known;
    private Map<Vertex, Integer> adjacentVertices = new HashMap<>();

    public Vertex() {
    }

    public Vertex(Country country) {
        this.country = country;
    }

    public Vertex(Country country, List<Vertex> shortestPath, Integer distance, boolean known, Map<Vertex, Integer> adjacentVertices) {
        this.country = country;
        this.shortestPath = shortestPath;
        this.distance = distance;
        this.known = known;
        this.adjacentVertices = adjacentVertices;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Vertex> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Map<Vertex, Integer> getAdjacentVertices() {
        return adjacentVertices;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }

    public void setAdjacentVertices(Map<Vertex, Integer> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public void addAdjacent(Vertex vertex, int distance) {
        adjacentVertices.put(vertex, distance);
    }

    @Override
    public int compareTo(Object o) {
        return distance.compareTo(((Vertex)o).getDistance());
    }
}
