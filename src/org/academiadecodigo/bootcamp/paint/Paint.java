package org.academiadecodigo.bootcamp.paint;

public class Paint {

    private final int COLS = 20;
    private final int ROWS = 20;
    static final int CELL_SIZE = 20;
    static final int PADDING = 10;

    private Cell[][] cells;


    public Paint(){

        cells = new Cell[COLS][ROWS];
        init();
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
}
