package org.academiadecodigo.bootcamp.paint;

public class Paint {

    static final int COLS = 20;
    static final int ROWS = 20;
    static final int CELL_SIZE = 20;
    static final int PADDING = 10;

    Cell[][] cells;
    private Cursor cursor;


    public Paint(){

        cells = new Cell[COLS][ROWS];
        cursor = new Cursor(this);

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
        cells[cursor.col][cursor.row].highlightOn();
    }



    void paintCell(){

        if (!cells[cursor.col][cursor.row].isPainted){

            cells[cursor.col][cursor.row].paint();
            return;
        }

        cells[cursor.col][cursor.row].unPaint();
    }


    public Cursor getCursor() {
        return cursor;
    }
}
