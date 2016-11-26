package com.doughuang168.maze;

import com.doughuang168.maze.Maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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

        int startI=0, startJ=2;
        int endI=15, endJ=12;

        //MazeGraph initialization
        MazeGraph mazeGraph = new MazeGraph( maze, startI, startJ, endI, endJ);

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
