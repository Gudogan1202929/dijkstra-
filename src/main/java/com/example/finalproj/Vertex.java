package com.example.finalproj;

import java.util.LinkedList;

public class Vertex <T> implements Comparable<Vertex<T>> {

    private String name;
    private double x;
    private double y;

    public LinkedList<Vertex> list = new LinkedList<Vertex>();

    private Vertex vertexPath =null;

    private double distance = Double.MAX_VALUE;

    private boolean visited = false;
    public Vertex(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Vertex getVertexPath() {
        return vertexPath;
    }

    public void setVertexPath(Vertex vertexPath) {
        this.vertexPath = vertexPath;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", list=" + list +
                ", vertexPath=" + vertexPath +
                ", distance=" + distance +
                ", visited=" + visited +
                '}';
    }

    @Override
    public int compareTo(Vertex<T> o) {
        return Double.compare(this.getDistance(), o.getDistance());
    }
}
