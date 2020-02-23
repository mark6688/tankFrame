package com.mark.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by makang on 2019/11/19.
 */
public class Main {

    public static void main(String[] args)throws Exception {

        int initTankCount = Integer.valueOf(String.valueOf(PropertyMgr.get("initTankCount")));
        TankFrame tankFrame = new TankFrame();
        for(int i =0;i<initTankCount;i++){
            tankFrame.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tankFrame));
        }
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
