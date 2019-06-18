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


    void paint(Color color){

        rectangle.setColor(color);
        rectangle.fill();
        isPainted = true;
    }

    void unPaint(){

        rectangle.setColor(Color.BLACK);
        rectangle.draw();
        isPainted = false;
    }

    Color getRectangleColor(){
        return rectangle.getColor();
    }


    // TODO: 18/06/2019 add toString according to color to write in saveFile 
}
