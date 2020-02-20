package com.mark.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by makang on 2019/11/19.
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,200,Dir.DOWN);

   public TankFrame(){
       setSize(800,600);
       setResizable(false);
       setTitle("Mark Game");
       setVisible(true);

       this.addKeyListener(new MyKeyListener());

       addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
//               super.windowClosing(e);
           }
       });
   }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
       boolean bL = false;
       boolean bU = false;
       boolean bR = false;
       boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT :
                    bL = true;
                    break;
                case KeyEvent.VK_UP :
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT :
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN :
                    bD = true;
                    break;
                default :
                    break;
            }
            setMainTainkDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT :
                    bL = false;
                    break;
                case KeyEvent.VK_UP :
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT :
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN :
                    bD = false;
                    break;
                default :
                    break;
            }
            setMainTainkDir();
        }
        private void setMainTainkDir() {
            if(!bL && !bU && !bR && !bD){myTank.setMoving(false);}
            else {
                myTank.setMoving(true);
                if(bL){myTank.setDir(Dir.LEFT);};
                if(bU){myTank.setDir(Dir.UP);};
                if(bR){myTank.setDir(Dir.RIGHT);};
                if(bD){myTank.setDir(Dir.DOWN);};
            }
        }
    }


}
