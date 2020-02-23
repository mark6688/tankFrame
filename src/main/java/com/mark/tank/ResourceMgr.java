package com.mark.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceMgr {

    public static BufferedImage tankL,tankR,tankU,tankD;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
//            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
//            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
//            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
//            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

            tankL = ImageIO.read(new File("C:/idea/images/tankL.gif"));
            tankR = ImageIO.read(new File("C:/idea/images/tankR.gif"));
            tankU = ImageIO.read(new File("C:/idea/images/tankU.gif"));
            tankD = ImageIO.read(new File("C:/idea/images/tankD.gif"));

            bulletL = ImageIO.read(new File("C:/idea/images/bulletL.gif"));
            bulletR = ImageIO.read(new File("C:/idea/images/bulletR.gif"));
            bulletU = ImageIO.read(new File("C:/idea/images/bulletU.gif"));
            bulletD = ImageIO.read(new File("C:/idea/images/bulletD.gif"));

            for(int i = 0 ;i<16;i++){
                explodes[i] = ImageIO.read(new File("C:/idea/images/e"+(i+1)+".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
