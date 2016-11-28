package com.doughuang168.maze;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MazeData {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Row {
        List<String> mazeRow;
        public List<String> getMazeRow() {return mazeRow;}
    }

    List<Row> maze;

    public List<Row> getMaze() {return maze;}
    public Integer size() { return maze.size();}
    public char[][] getMazeArray() {
        char[][] mazeArray=new char[size()][size()];

        int i=0;
        for (Row row: maze) {
            int j=0;
            List<String> strList = row.getMazeRow();
            for (String str: strList) {// iter size() times
                char[] charArray = str.toCharArray();
                mazeArray[i][j] = charArray[0]; //alway use charArray[0]
                j++;
            }
            i++;
        }

        return mazeArray;
    }
}

