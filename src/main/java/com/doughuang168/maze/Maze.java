package com.doughuang168.maze;

import com.doughuang168.maze.Juncture;

import java.util.*;


public class Maze {


    final static char C = ' ', X = 'x', S = 's', E = 'e', V = '.';
    //General perfect maze properties
    private int START_I, START_J;
    private int END_I, END_J;
    private char[][] maze;

    public void setStartJuncture(int i, int j){
        START_I = i;
        START_J = j;
    }
    public void setEndJuncture(int i, int j) {
        END_I = i;
        END_J = j;
    }
    public char content(int x, int y) {
        return this.maze[x][y];
    }
    public void buildMaze(char[][] searchMaze){
        this.maze=new char[searchMaze.length][searchMaze.length];
        for (int i=0; i< searchMaze.length; i++)
            for (int j=0; j<searchMaze.length; j++)
                this.maze[i][j] = searchMaze[i][j];
    }
    public int getSTART_I() {
        return START_I;
    }
    public int getSTART_J() {
        return START_J;
    }
    public int getEND_I() {
        return END_I;
    }
    public int getEND_J() {
        return END_J;
    }
    public int size() {
        return this.maze.length;
    }
    public void print() {
        for (int i=0; i<size(); i++) {
            for (int j=0; j<size(); j++) {
                System.out.print(this.maze[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    public boolean isClear(int i, int j) {
        assert(isInMaze(i,j));
        return (maze[i][j] != X && maze[i][j] != V);
    }
    public boolean isClear(Juncture pos) {
        return isClear(pos.i(), pos.j());
    }
    //true if cell is within maze
    public boolean isInMaze(int i, int j) {
        if (i >= 0 && i<size() && j>= 0 && j<size()) return true;
        else return false;
    }
    //true if cell is within maze
    public boolean isInMaze(Juncture pos) {
        return isInMaze(pos.i(), pos.j());
    }
    public boolean isFinal( int i, int j) {
        return (i== END_I && j == END_J);
    }
    public boolean isFinal(Juncture pos) {
        return isFinal(pos.i(), pos.j());
    }
    public char[][] clone() {

        char[][] mazeCopy = new char[size()][size()];
        for (int i=0; i< size(); i++)
            for (int j=0; j<size(); j++)
                mazeCopy[i][j] = maze[i][j];
        return mazeCopy;
    }
    public void restore(char[][] savedMaze) {
        for (int i=0; i< size(); i++)
            for (int j=0; j<size(); j++)
                maze[i][j] = savedMaze[i][j];
    }


}
