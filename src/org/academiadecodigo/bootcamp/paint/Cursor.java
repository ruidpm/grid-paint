package org.academiadecodigo.bootcamp.paint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    int col;
    int row;
    private Paint paint;
    private Rectangle rectangle;

    public Cursor(Paint paint){

        this.paint = paint;
        col = 0;
        row = 0;
        rectangle = new Rectangle(Paint.colToX(col), Paint.rowToY(row), Paint.CELL_SIZE, Paint.CELL_SIZE);
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }


    public void changeRectangleColor(){

        rectangle.setColor(Color.PINK);
    }

    public void cursorUp(){

        if (row - 1 >= 0){

            rectangle.translate(0, Paint.rowToY(--row) - Paint.rowToY(row + 1));
        }
    }


    public void cursorDown(){

        if (row + 1 < Paint.ROWS){

            rectangle.translate(0, Paint.rowToY(++row) - Paint.rowToY(row - 1));
        }
    }


    public void cursorLeft(){

        if (col - 1 >= 0){

            rectangle.translate(Paint.colToX(--col) - Paint.colToX(col + 1), 0);
        }
    }


    public void cursorRight(){

        if (col + 1 < Paint.COLS){

            rectangle.translate(Paint.colToX(++col) - Paint.colToX(col - 1), 0);
        }
    }

}
