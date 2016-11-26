package com.doughuang168.maze;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    //The vertices in maze graph will be connected by an edge whenever the corresponding junctures in the maze
    // are adjacent and there is no wall between them
    int i, j;
    List<Vertex> acencyVertices;
    boolean markAsVisited;
    //boolean markAsSeen;
    Vertex predecessor;

    public Vertex(int i, int j) {
        this.i = i;
        this.j = j;
        this.markAsVisited = false;
        this.acencyVertices = new ArrayList< Vertex >();
        this.predecessor = null;
    };
    public int i() { return i;}

    public int j() { return j;}

    public void print() {
        System.out.println("(" + i + "," + j + ")");
    }

    public void markAsVisited() {
        this.markAsVisited = true;
    }

    public void markAsNotVisited() {
        this.markAsVisited = false;
    }

    public void addAdjacency(Vertex v){
        acencyVertices.add(v);
    }

    public void setPredecessor(Vertex v) {
        predecessor = v;
    }
    public Vertex getPredecessor() {
        return predecessor;
    }
    public List<Vertex> getAdjacencies() {
        return acencyVertices;
    }
//
//    public void markAsSeen() {
//        this.markAsSeen = true;
//    }

    public boolean beenVisited() {
        return markAsVisited == true;
    }

    //public void setPredecessor(Vertex p)
}
