package com.mark.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by makang on 2019/11/19.
 * 继承Frame类，来实现创建一个客户端窗体
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    java.util.List<Bullet> bulletList = new ArrayList<Bullet>();
    java.util.List<Tank> tanks = new ArrayList<Tank>();
    java.util.List<Explode> explodeList = new ArrayList<Explode>();
    static final int GAME_WIGTH = 800,GAME_HEIGHT =600;


   public TankFrame(){
       setSize(GAME_WIGTH,GAME_HEIGHT);
       setResizable(false);
       setTitle("Mark Gamev1.0.4");
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

   //双向缓冲问题：当内存向显存进行绘画的时候，先进行拦截将要呈现的内容一起放到内存
    //然后一起吐给显存从而解决重画闪动的问题
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
        g.drawString("说明：发子弹(ctrl)、控制方向(键盘的上下左右)",10,40);
        g.drawString("子弹的数量："+bulletList.size(),10,60);
        g.drawString("敌人的数量："+tanks.size(),10,80);
        g.drawString("爆炸的数量："+explodeList.size(),10,100);
        g.setColor(c);
        myTank.paint(g);
        //通过普通循环放置对象，解决放置过程中移除集合中内容导致数组长度改变报错问题
        for (int i = 0;i<bulletList.size();i++){
            bulletList.get(i).paint(g);
        }
        for (int i = 0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }

        for(int i =0;i<explodeList.size();i++){
            explodeList.get(i).paint(g);
        }

        for(int i =0;i<bulletList.size();i++){
            for(int j=0;j<tanks.size();j++){
                bulletList.get(i).collideWith(tanks.get(j));
            }
        }

//也可以通过如下迭代器解决
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
