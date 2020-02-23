package com.mark.tank;

import java.awt.*;

/**
 * Created by makang on 2020/2/20.
 */
public class Explode {
    private int x,y;

    public boolean liveing = true;
    private TankFrame tankFrame = null;

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int stop = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;

    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[stop++],x,y,null);
        if(stop >= ResourceMgr.explodes.length){
            tankFrame.explodeList.remove(this);
        }

    }

}
