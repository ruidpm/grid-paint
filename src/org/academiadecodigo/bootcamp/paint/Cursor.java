package org.academiadecodigo.bootcamp.paint;

import org.academiadecodigo.bootcamp.Randomizer;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    int col;
    int row;
    Rectangle rectangle;


    static final Color[] colors = {
            Color.BLACK,
            Color.GREEN,
            Color.PINK,
            Color.YELLOW,
            Color.RED,
    };

    public Cursor(){

        col = 0;
        row = 0;
        rectangle = new Rectangle(Paint.colToX(col), Paint.rowToY(row), Paint.CELL_SIZE, Paint.CELL_SIZE);
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }

// TODO: 18/06/2019 composition with cell 

    public void changeRectangleColor(){

        rectangle.setColor(colors[Randomizer.randomizeBetween(0 , colors.length -1)]);
    }

    public void cursorUp(){

        if (row - 1 >= 0){

            rectangle.translate(0, Paint.rowToY(--row) - Paint.rowToY(row + 1));
            rectangle.delete();
            rectangle.fill();
        }
    }


    public void cursorDown(){

        if (row + 1 < Paint.ROWS){

            rectangle.translate(0, Paint.rowToY(++row) - Paint.rowToY(row - 1));
            rectangle.delete();
            rectangle.fill();
        }
    }


    public void cursorLeft(){

        if (col - 1 >= 0){

            rectangle.translate(Paint.colToX(--col) - Paint.colToX(col + 1), 0);
            rectangle.delete();
            rectangle.fill();
        }
    }


    public void cursorRight(){

        if (col + 1 < Paint.COLS){

            rectangle.translate(Paint.colToX(++col) - Paint.colToX(col - 1), 0);
            rectangle.delete();
            rectangle.fill();
        }
    }

}
