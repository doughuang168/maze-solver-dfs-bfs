package com.doughuang168.maze;

import com.doughuang168.maze.Maze;

import com.doughuang168.maze.MazeData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MazeApplication {


    public static void main(String[] args) {

        //Maze representation: s: entrance point/Juncture e:  exit point Juncture, x: Wall, ' ': Open
        //simply connected perfect maze:  A maze is classified as ‘perfect’ if it does not contain loops
                char[][] maze = {
                {'x', 'x', 's', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', ' ', ' ', 'x', ' ', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
                {'x', ' ', ' ', 'x', ' ', 'x', ' ', ' ', ' ', 'x', ' ', ' ', ' ', 'x', ' ', 'x'},
                {'x', ' ', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x'},
                {'x', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', 'x', ' ', 'x', ' ', 'x', ' ', 'x'},
                {'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'},
                {'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', 'x', ' ', ' ', ' ', 'x'},
                {'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', ' ', 'x'},
                {'x', ' ', 'x', 'x', 'x', 'x', ' ', 'x', ' ', ' ', 'x', ' ', ' ', ' ', ' ', 'x'},
                {'x', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', 'x', 'x', ' ', 'x', 'x', 'x', 'x'},
                {'x', ' ', 'x', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
                {'x', ' ', 'x', 'x', 'x', 'x', ' ', 'x', ' ', ' ', 'x', 'x', 'x', 'x', ' ', 'x'},
                {'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', ' ', ' ', 'x', ' ', 'x'},
                {'x', ' ', 'x', ' ', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'e', 'x', 'x', 'x'}
        };


        String mazePath = "";
        ObjectMapper mapper = new ObjectMapper();
        MazeData mazeData = null;
        char[][] mazeAryData = null;
        int startI=0, startJ=2;
        int endI=15, endJ=12;

        //mapper = new ObjectMapper();
        //java -jar Maze-1.0-SNAPSHOT.jar -classpath "." com.doughuang168.maze.MazeApplication.class
        //java -jar Maze-1.0-SNAPSHOT.jar -classpath "." com.doughuang168.maze.MazeApplication.class maze.json => args.length == 4
        if (args.length == 4) {
            mazePath = args[3];//"C:\\src\\Github\\maze-solver-dfs-bfs\\maze3.json"; //args[3];
            try {
                mazeData = mapper.readValue(new File(mazePath), MazeData.class);
                mazeAryData = mazeData.getMazeArray();
                for (int i=0; i<mazeData.size(); i++) {
                    for (int j=0; j<mazeData.size(); j++) {
                        if (mazeAryData[i][j] == 's') {
                            startI = i;
                            startJ = j;
                        } else  if (mazeAryData[i][j] == 'e') {
                            endI = i;
                            endJ = j;
                        }
                    }
                }
                System.out.println();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println();
            }
        }

        MazeGraph mazeGraph;

        //MazeGraph initialization
        if (mazePath == "") {//use built in default maze
            System.out.println("Use build-in maze");
            mazeGraph = new MazeGraph( maze, startI, startJ, endI, endJ);
        } else {
            System.out.println("Use user supply maze: "+mazePath);
            mazeGraph = new MazeGraph(  mazeAryData , startI, startJ, endI, endJ);
        }


        //MazeGraph initialization
        //MazeGraph mazeGraph = new MazeGraph( maze, startI, startJ, endI, endJ);

        mazeGraph.print();
        System.out.println();

        char[][] savedMaze = mazeGraph.clone();

        //Use Depth first-search algorithm
        mazeGraph.dfs();
        mazeGraph.dfsHappyPath();
        mazeGraph.restore(savedMaze);
        System.out.println();

        //Use Breadth first-search algorithm
        mazeGraph.clearVerticesMap();
        mazeGraph.bfs();
        mazeGraph.bfsHappyPath();
        mazeGraph.restore(savedMaze);


    }
}
