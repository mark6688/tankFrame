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

    int x =200, y = 200;

   public TankFrame(){
       setSize(800,600);
       setResizable(false);
       setTitle("tank war");
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
    public void print(Graphics g) {
        g.fillRect(x,y,60,60);
        x += 10;
        y += 10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
