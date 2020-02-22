package com.mark.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceMgr {

    public static BufferedImage tankU,tankL,tankR,tankD;

    static {
        try {
//            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
//            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
//            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
//            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

            tankL = ImageIO.read(new File("C:/idea/images/tankL.gif"));
            tankU = ImageIO.read(new File("C:/idea/images/tankU.gif"));
            tankR = ImageIO.read(new File("C:/idea/images/tankR.gif"));
            tankD = ImageIO.read(new File("C:/idea/images/tankD.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
