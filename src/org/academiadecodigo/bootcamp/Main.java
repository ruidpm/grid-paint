package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.keyboard.PaintKeyboardHandler;
import org.academiadecodigo.bootcamp.mouse.PaintMouseHandler;
import org.academiadecodigo.bootcamp.paint.Paint;

public class Main {

    public static void main(String[] args) {

        Paint paint = new Paint();
        new PaintKeyboardHandler(paint);
        new PaintMouseHandler(paint);

    }
}
