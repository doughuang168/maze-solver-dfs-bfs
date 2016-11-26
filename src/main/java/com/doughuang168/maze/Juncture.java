package com.doughuang168.maze;

import java.util.List;


public class Juncture {
    int x, y;

    public Juncture(int i, int j) {
        this.x = i;
        this.y = j;
    };

    public int i() { return x;}

    public int j() { return y;}

    public void print() {
        System.out.println("(" + x + "," + y + ")");
    }
    public Juncture up() {
        return new Juncture(x-1, y);
    }
    public Juncture down() {
        return new Juncture(x+1, y);
    }
    public Juncture right() {
        return new Juncture(x, y+1);
    }
    public Juncture left() {
        return new Juncture(x, y-1);
    }
}
