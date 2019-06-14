package org.academiadecodigo.bootcamp.paint;

public class Paint {

    static final int COLS = 21;
    static final int ROWS = 21;
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



    public void paintCell(){

        if (!cells[cursor.col][cursor.row].isPainted){

            cells[cursor.col][cursor.row].paint();
            return;
        }

        cells[cursor.col][cursor.row].unPaint();
    }


    public Cursor getCursor() {
        return cursor;
    }


    public void saveGridState(){

        String[] linesState = new String[ROWS];

        for (int i = 0; i < Paint.ROWS; i++){

            linesState[i] = "";

            for (int k = 0; k < Paint.COLS; k++){

                if (cells[k][i].isPainted){

                    linesState[i] += 1;
                    continue;
                }

                linesState[i] += 0;
            }

            linesState[i] += "\n";
        }


        SaveStateHandler.saveGridState(linesState);
    }


    public void clearScreen(){

        for (int i = 0; i < COLS; i++){

            for (int k = 0; k < ROWS; k++){

                cells[i][k].unPaint();
            }
        }
    }


    public void loadGridState(){

        String[] states = SaveStateHandler.loadGridState();
        int col;

        for (int i = 0; i < ROWS; i++){
            col = 0;
            if (i > states[i].length()){
                break;
            }

            if (states[i].toCharArray().length >= COLS){
                states[i] = states[i].substring(0,COLS);
            }

            for (char c : states[i].toCharArray()) {

                if (c == '0'){

                    cells[col++][i].unPaint();
                    continue;
                }

                cells[col++][i].paint();
            }
        }
    }
}
