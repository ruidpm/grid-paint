package org.academiadecodigo.bootcamp.keyboard;

import org.academiadecodigo.bootcamp.paint.Cursor;
import org.academiadecodigo.bootcamp.paint.Paint;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PaintKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Cursor cursor;



    public PaintKeyboardHandler(Cursor cursor){

        this.cursor = cursor;

        keyboard = new Keyboard(this);

        addKeysAndEvents();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){



            case (KeyboardEvent.KEY_UP):

                cursor.cursorUp();

                break;

            case KeyboardEvent.KEY_DOWN:

                cursor.cursorDown();

                break;

            case (KeyboardEvent.KEY_LEFT):

                cursor.cursorLeft();

                break;

                case KeyboardEvent.KEY_RIGHT:

                cursor.cursorRight();

                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:

                cursor.paintCell();

                break;
        }
    }



    private void setKeyAndEvent(int key, KeyboardEventType type){
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }


    private void addKeysAndEvents(){
        setKeyAndEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED);
    }

}
