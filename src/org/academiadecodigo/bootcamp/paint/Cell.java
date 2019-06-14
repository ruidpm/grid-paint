package org.academiadecodigo.bootcamp.paint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private Rectangle rectangle;
    boolean isPainted;


    Cell(int col, int row){

        rectangle = new Rectangle(Paint.colToX(col), Paint.rowToY(row), Paint.CELL_SIZE, Paint.CELL_SIZE);
        rectangle.draw();
    }


    void paint(){

        rectangle.setColor(Color.BLACK);
        rectangle.fill();
        isPainted = true;
    }

    void unPaint(){

        rectangle.draw();
        isPainted = false;
    }

}
