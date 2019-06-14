package org.academiadecodigo.bootcamp.paint;

import java.io.*;

class SaveStateHandler {


    void saveGridState(Cell[][] cells){

        String lineState = "";
        BufferedWriter writer = null;

        try {
             writer = new BufferedWriter(new FileWriter("resources/saveState"));

            for (int i = 0; i < Paint.ROWS; i++){

                for (int k = 0; k < Paint.COLS; k++){

                    if (cells[k][i].isPainted){

                        lineState += 1;
                        continue;
                    }

                    lineState += 0;
                }

                lineState += "\n";
                writer.write(lineState);

                lineState = "";
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeStream(writer);
        }
    }




    void loadGridState(Cell[][] cells){

        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader("resources/saveState"));
            int col = 0;

            for (int i = 0; i < Paint.ROWS; i++){
                col = 0;

                try {
                    line = reader.readLine();

                    for (char c : line.toCharArray()) {

                        if (c == '0'){
                            cells[col++][i].unPaint();
                            continue;
                        }

                        cells[col++][i].paint();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeStream(reader);
        }
    }




    private void closeStream(Closeable stream){

        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
