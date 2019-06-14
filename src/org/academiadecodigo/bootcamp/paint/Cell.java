package org.academiadecodigo.bootcamp.paint;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private int row;
    private int col;
    private Rectangle rectangle;
    private boolean isPainted;


    public Cell(int col, int row){

        this.col = col;
        this.row = row;
        rectangle = new Rectangle(Paint.colToX(col), Paint.rowToY(row), Paint.CELL_SIZE, Paint.CELL_SIZE);
        rectangle.draw();
    }

}
