package com.doughuang168.maze;

import java.util.*;

public class MazeGraph extends Maze  {

    HashMap<String, Vertex> verticesMap;
    private Vertex start;
    private Vertex finish;
    LinkedList<Vertex> dfsVertices;
    LinkedList<Vertex> bfsVertices;
    LinkedList<Vertex> dfsAllPath;
    LinkedList<Vertex> bfsAllPath;

    public MazeGraph(char[][] maze, int startI, int startJ, int endI, int endJ) {
        this.start = new Vertex(startI, startJ);
        this.finish = new Vertex(endI, endJ);
        this.verticesMap = new HashMap<String, Vertex>();
        setStartJuncture(startI,startJ);
        setEndJuncture(endI,endJ);
        buildMaze(maze);
        buildGraph();
    }

    private void buildGraph() {
        for (int i=0; i<size(); i++) {
            for (int j=0; j<size(); j++) {
                addVertex(new Vertex(i,j));
            }
        }
        System.out.println();
    }

    public void clearVerticesMap() {
        for (String key : verticesMap.keySet()) {
            Vertex v = verticesMap.get(key);
            v.markAsNotVisited();
        }
    }

    public void addVertex(Vertex v) {
        //populate the set of adjacencies for each Vertex.
        // Again,  two vertices are "adjacent" if their underlying junctures in the maze are adjacent
        // (one is situated directly above, below, left, or right of the other)
        // and there is no wall between them.
        Juncture crt, next;
        crt = new Juncture(v.i(), v.j());

        //If this Vertex is clear then put its neighbors in the adjustent list
        if (isInMaze(crt) && isClear(crt)) {
            next = crt.up();
            if (isInMaze(next) && isClear(next)) {
                v.addAdjacency(new Vertex(next.i(), next.j()));
            }

            next = crt.right();
            if (isInMaze(next) && isClear(next)) {
                v.addAdjacency(new Vertex(next.i(), next.j()));
            }

            next = crt.left();
            if (isInMaze(next) && isClear(next)) {
                v.addAdjacency(new Vertex(next.i(), next.j()));
            }

            next = crt.down();
            if (isInMaze(next) && isClear(next)) {
                v.addAdjacency(new Vertex(next.i(), next.j()));
            }
        }
        verticesMap.put(vertexKey(v.i(), v.j()), v);
    }

    public String vertexKey(Integer i, Integer j) {
        return i.toString() + "X" + j.toString();
    }

    public HashMap<String, Vertex> getVerticesMap() {
        return verticesMap;
    }

    public Vertex getStartVertex(){
        return start;
    }

    public Vertex getFinishVertex(){
        return finish;
    }

    public void dfs() {//Use stack

        Vertex v = verticesMap.get(vertexKey(start.i(), start.j()));

        Stack<Vertex> candidates = new Stack<Vertex>();
        //insert the start Vertex
        candidates.push(v);

        Vertex current, next;
        while (!candidates.empty()) {

            //get current position
            next = candidates.pop();
            current = verticesMap.get(vertexKey(next.i(), next.j()));


            //check if the vertex has already been visited
            //if it has then just skip over it and process the next one.
            if (!current.beenVisited()) {

                //Mark the current position have been Visited
                Vertex vdfs = verticesMap.get(vertexKey(current.i(), current.j()));
                vdfs.markAsVisited();
                verticesMap.put(vertexKey(vdfs.i(), vdfs.j()), vdfs);

                //check if the vertex is equal to the vertex "finish".  If it is, then the search is over,
                if (current.i() == finish.i() && current.j() == finish.j()) {
                    break;// reach finish line
                }

                //proceed by cycling through the adjacencies of this vertex
                //looking for ones that have not yet been visited.
                List<Vertex> vertexList = current.getAdjacencies();
                for (Vertex ventry: vertexList) {
                    //For any adjacency we discover that has not been visited before,
                    Vertex vitem = verticesMap.get(vertexKey(ventry.i(), ventry.j()));
                    if (!vitem.beenVisited()) {
                        //set it's predecessor to be equal to the vertex we are currently visiting
                        vitem.setPredecessor(current);
                        candidates.push(ventry);
                    }
                }
            }

        }

    }

    public void dfsHappyPath() {

        Vertex v = getFinishVertex();
        Vertex v2 = verticesMap.get(vertexKey(v.i(), v.j()));

        Stack<Vertex> happyPathStack = new Stack<Vertex>();
        happyPathStack.push(v2);
        Vertex node =  v2.getPredecessor();
        happyPathStack.push(node);
        while (node.getPredecessor() != null) {
            Vertex vnode = verticesMap.get(vertexKey(node.i(), node.j()));
            //vnode.print();
            node = vnode.getPredecessor();
            happyPathStack.push(node);
        }

        dfsVertices = new LinkedList<Vertex>();
        node = happyPathStack.pop();
        dfsVertices.add(node);
        System.out.println("Depth first-search path:");
        while (!happyPathStack.empty()) {
            node = happyPathStack.pop();
            dfsVertices.add(node);
        }

        for(Vertex v1: dfsVertices) {
            v1.print();
        }
    }

    public void bfs() {//Use queue

        Vertex v = verticesMap.get(vertexKey(start.i(), start.j()));
        LinkedList<Vertex> candidates = new LinkedList<Vertex>();
        //insert the start
        candidates.add(v);

        Vertex current, next;
        while (!candidates.isEmpty()) {

            //get current position
            next = candidates.removeFirst();
            current = verticesMap.get(vertexKey(next.i(), next.j()));

            //check if the vertex has already been visited
            //if it has then just skip over it and process the next one.
            if (!current.beenVisited()) {

                //Mark the current position have been Visited
                Vertex vdfs = verticesMap.get(vertexKey(current.i(), current.j()));
                vdfs.markAsVisited();
                verticesMap.put(vertexKey(vdfs.i(), vdfs.j()), vdfs);

                //check if the vertex is equal to the vertex "finish".  If it is, then the search is over,
                if (current.i() == finish.i() && current.j() == finish.j()) {
                    //System.out.println("reach finish line");
                    //Vertex p = crt.getPredecessor();
                    //p.print();
                    break;// reach finish line
                }

                //proceed by cycling through the adjacencies of this vertex
                //looking for ones that have not yet been visited.
                List<Vertex> vertexList = current.getAdjacencies();
                for (Vertex ventry: vertexList) {
                    //For any adjacency we discover that has not been visited before,
                    Vertex vitem = verticesMap.get(vertexKey(ventry.i(), ventry.j()));
                    if (!vitem.beenVisited()) {
                        //set it's predecessor to be equal to the vertex we are currently visiting
                        vitem.setPredecessor(current);
                        candidates.add(ventry);
                    }
                }
            }

        }

    }

    public void bfsHappyPath() {

        Vertex v = getFinishVertex();
        Vertex v2 = verticesMap.get(vertexKey(v.i(), v.j()));

        Stack<Vertex> happyPathStack = new Stack<Vertex>();
        happyPathStack.push(v2);
        Vertex node =  v2.getPredecessor();
        happyPathStack.push(node);
        while (node.getPredecessor() != null) {
            Vertex vnode = verticesMap.get(vertexKey(node.i(), node.j()));
            //vnode.print();
            node = vnode.getPredecessor();
            happyPathStack.push(node);
        }

        bfsVertices = new LinkedList<Vertex>();
        node = happyPathStack.pop();
        bfsVertices.add(node);
        System.out.println("Breadth first-search path:");
        while (!happyPathStack.empty()) {
            node = happyPathStack.pop();
            //node.print();
            bfsVertices.add(node);
        }

        for(Vertex v1: bfsVertices) {
            v1.print();
        }
    }
}
