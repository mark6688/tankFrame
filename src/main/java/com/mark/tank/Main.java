package com.mark.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by makang on 2019/11/19.
 */
public class Main {

    public static void main(String[] args)throws Exception {
//        Frame f = new Frame();
//        f.setSize(800,600);
//        f.setResizable(false);
//        f.setTitle("tank war");
//        f.setVisible(true);
//
//        f.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
////                super.windowClosing(e);
//            }
//        });

        TankFrame tankFrame = new TankFrame();
        for(int i =0;i<5;i++){
            tankFrame.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tankFrame));
        }
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
