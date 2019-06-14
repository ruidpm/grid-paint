package org.academiadecodigo.bootcamp.paint;

public class Cursor {

    int col;
    int row;
    private Paint paint;

    public Cursor(Paint paint){

        this.paint = paint;
        col = 0;
        row = 0;
    }


    public void cursorUp(){

        if (row - 1 >= 0){

            paint.cells[col][row].highLightOff();

            paint.cells[col][--row].highlightOn();
        }
    }


    public void cursorDown(){

        if (row + 1 < Paint.ROWS){

            paint.cells[col][row].highLightOff();

            paint.cells[col][++row].highlightOn();
        }
    }


    public void cursorLeft(){

        if (col - 1 >= 0){

            paint.cells[col][row].highLightOff();

            paint.cells[--col][row].highlightOn();
        }
    }


    public void cursorRight(){

        if (col + 1 < Paint.COLS){

            paint.cells[col][row].highLightOff();

            paint.cells[++col][row].highlightOn();
        }
    }

}
