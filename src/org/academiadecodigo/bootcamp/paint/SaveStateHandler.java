package org.academiadecodigo.bootcamp.paint;

import java.io.*;

class SaveStateHandler {


    static void saveGridState(String[] linesState){

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("resources/saveState"));

            for (String s : linesState) {

                writer.write(s);
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeStream(writer);
        }
    }




    static String[] loadGridState(){

        BufferedReader reader = null;
        String[] linesState = new String[Paint.ROWS];
        String line;

        try {
            reader = new BufferedReader(new FileReader("resources/saveState"));

            int row = 0;

                try {

                    while ((line = reader.readLine()) != null) {

                        linesState[row++] = line;
                        if (row >= Paint.ROWS){
                            break;
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeStream(reader);
        }

        return linesState;
    }




    static private void closeStream(Closeable stream){

        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
