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

    int x =20, y = 20;

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
    public void paint(Graphics g) {
        g.fillRect(x,y,60,60);
        x += 10;
        y += 10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key Released");
        }
    }
}
