package com.example.finalproj;

import java.util.Map;
import java.util.PriorityQueue;

public class Problem {

    public static double DistancePath =0;

    public static double dijkstra_algorithm (Map<String,Vertex> map , String source , String destination){
        if (source.equals(destination)){
            return DistancePath =-1;
        }
        map.get(source).setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        Vertex V,W;
        V = map.get(source);
        queue.add(V);
        while (!queue.isEmpty()){
            V = queue.poll();
            V.setVisited(true);

            if (V.getName().equals(destination)){
                break;
            }

            for (int i = 0; i < V.list.size(); i++) {
                W = (Vertex) V.list.get(i);
                    if (!W.isVisited() && ( W.getDistance() > (getDistance(V,W)+V.getDistance()))){
                        W.setDistance(getDistance(V,W)+V.getDistance());
                        W.setVertexPath(V);
                        queue.add(W);
                    }
                }
           }
        DistancePath = map.get(destination).getDistance();
        return DistancePath;
    }

    public static String s ="";
    public static void printPath(Vertex vertex){
        if (vertex.getVertexPath() != null){
            printPath(vertex.getVertexPath());
             s+=(" -> ");
        }
        s+=(vertex.getName());
    }

    private static double getDistance(Vertex c1, Vertex c2) {
        double R = 6371;
        double dLat = deg2rad(c2.getY() - c1.getY());
        double dLon = deg2rad(c2.getX() - c1.getX());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(deg2rad(c1.getY())) * Math.cos(deg2rad(c2.getY())) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (R*c);
    }

    static double deg2rad(double deg) {
        return deg * (Math.PI / 180);
    }
}
