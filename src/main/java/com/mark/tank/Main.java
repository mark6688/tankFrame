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
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
