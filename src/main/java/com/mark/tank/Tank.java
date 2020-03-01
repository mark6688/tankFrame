package com.mark.tank;

import java.awt.*;
import java.util.Random;

/**
 * Created by makang on 2020/2/20.
 */
public class Tank {
    public Rectangle rectangle = new Rectangle();
    int x,y;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 5;

    private boolean moving = true;

    TankFrame tankFrame = null;

    public static int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankD.getHeight();
    private boolean liveing = true;

    private Random random = new Random();

    Group group = Group.BAD;

    FireComparable<Tank> firComparable = new DefaultFireStrategy();

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir,Group group,TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
        if(this.group == Group.GOOD){
            String goodFS = String.valueOf(PropertyMgr.get("goodFS"));
            try {
                //这里jdk1.8之后Class.forName(goodFS).newInstance()这种方式被废弃了，用了以下方式来进行反射如果存在有参构造的话就不会有问题了
                firComparable = (FireComparable<Tank>) Class.forName(goodFS).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            String badFS = String.valueOf(PropertyMgr.get("badFS"));
            try {
                firComparable = (FireComparable<Tank>) Class.forName(badFS).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public void paint(Graphics g) {
        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankL:ResourceMgr.goodTankL,x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankU:ResourceMgr.goodTankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankR:ResourceMgr.goodTankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankD:ResourceMgr.goodTankD,x,y,null);
                break;
        }

       move();
    }

    private void move(){
        if(!liveing){
            tankFrame.tanks.remove(this);
        }
        if(!moving){ return;}
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }
        if(this.group == Group.BAD && random.nextInt(100) > 90){
            this.fire();
        }
        if(this.group == Group.BAD && random.nextInt(100)>95){
            randomDir();
        }
        boundCheck();
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundCheck() {
        if(this.x <2) x=2;
        if(this.y < 32) y = 32;
        if(this.x > TankFrame.GAME_WIGTH - Tank.WIDTH) x = TankFrame.GAME_WIGTH - Tank.WIDTH -2;
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT -2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void fire() {
        firComparable.fir(this);
    }

    public void dis() {
        this.liveing = false;
    }
}
