package org.academiadecodigo.bootcamp.mouse;

import org.academiadecodigo.bootcamp.paint.Paint;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class PaintMouseKeyboardHandler implements MouseHandler {

   private Paint paint;
   private Mouse mouse;

   public PaintMouseKeyboardHandler(Paint paint){

       mouse = new Mouse(this);
       this.paint = paint;
       init();
   }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        paint.getCursor().changeRectangleColor();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }



    private void init(){

       MouseEvent event = new MouseEvent(1,1,MouseEventType.MOUSE_CLICKED);
    }
}
