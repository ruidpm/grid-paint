package org.academiadecodigo.bootcamp.keyboard;

import org.academiadecodigo.bootcamp.paint.Paint;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PaintKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Paint paint;



    public PaintKeyboardHandler(Paint paint){

        this.paint = paint;

        keyboard = new Keyboard(this);

        addKeysAndEvents();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_SPACE:

                paint.paintCell();

                break;

            case (KeyboardEvent.KEY_UP):

                paint.cursorUp();

                break;

            case KeyboardEvent.KEY_DOWN:

                paint.cursorDown();

                break;

            case (KeyboardEvent.KEY_LEFT):

                paint.cursorLeft();

                break;

                case KeyboardEvent.KEY_RIGHT:

                paint.cursorRigth();

                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
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

        setKeyAndEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
    }

}
