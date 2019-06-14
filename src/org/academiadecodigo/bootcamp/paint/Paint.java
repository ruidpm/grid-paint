package org.academiadecodigo.bootcamp.paint;

import org.academiadecodigo.bootcamp.keyboard.PaintKeyboardHandler;

public class Paint {

    private final int COLS = 20;
    private final int ROWS = 20;
    static final int CELL_SIZE = 20;
    static final int PADDING = 10;

    private Cell[][] cells;
    private int cursorCol;
    private int cursorRow;


    public Paint(){

        cells = new Cell[COLS][ROWS];
        cursorCol = 0;
        cursorRow = 0;

        new PaintKeyboardHandler(this);

        init();

        start();
    }


    private void init(){

        for (int i = 0; i < COLS; i++){

            for (int k = 0; k < ROWS; k ++){

                cells [i][k] = new Cell(i, k);
            }
        }
    }


    static int rowToY(int row){
        return row * CELL_SIZE + PADDING;
    }


    static int colToX(int col){
        return col * CELL_SIZE + PADDING;
    }


    private void start(){
        cells[cursorCol][cursorRow].highlightOn();
    }


    public void cursorUp(){

        if (cursorRow - 1 >= 0){

            cells[cursorCol][cursorRow].highLigthOff();

            cells[cursorCol][--cursorRow].highlightOn();
        }
    }


    public void cursorDown(){

        if (cursorRow + 1 < ROWS){

            cells[cursorCol][cursorRow].highLigthOff();

            cells[cursorCol][++cursorRow].highlightOn();
        }
    }


    public void cursorLeft(){

        if (cursorCol - 1 >= 0){

            cells[cursorCol][cursorRow].highLigthOff();

            cells[--cursorCol][cursorRow].highlightOn();
        }
    }


    public void cursorRigth(){

        if (cursorCol + 1 < COLS){

            cells[cursorCol][cursorRow].highLigthOff();

            cells[++cursorCol][cursorRow].highlightOn();
        }
    }

    public void paintCell(){

        if (cells[cursorCol][cursorRow].isPainted){

            cells[cursorCol][cursorRow].paint();
            return;
        }

        cells[cursorCol][cursorRow].unPaint();
    }
}
