package com.mark.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by makang on 2019/11/19.
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,200,Dir.DOWN,this);
    java.util.List<Bullet> bulletList = new ArrayList<>();
    static final int GAME_WIGTH = 800,GAME_HEIGHT =600;


   public TankFrame(){
       setSize(GAME_WIGTH,GAME_HEIGHT);
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

   Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIGTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIGTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量："+bulletList.size(),10,60);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0;i<bulletList.size();i++){
            bulletList.get(i).paint(g);
        }

//        for(Iterator<Bullet> it = bulletList.iterator();it.hasNext();){
//            Bullet b = it.next();
//            if(!b.live){
//                it.remove();
//            }
//        }
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
                case KeyEvent.VK_CONTROL :
                    myTank.fire();
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
