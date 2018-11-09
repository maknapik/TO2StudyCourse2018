package com.kucyki.model;

import com.kucyki.model.cell.Cell;

public class World {

    private int width;
    private int height;
    private Cell[][] cells;

    public World(int width, int height) {
        this.width = width;
        this.height = height;

        cells = new Cell[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setCell(int x, int y, Cell cell) {
        cells[x][y] = cell;
    }
}
