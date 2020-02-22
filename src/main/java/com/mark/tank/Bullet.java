package com.mark.tank;

import java.awt.*;

/**
 * Created by makang on 2020/2/20.
 */
public class Bullet {
    private static final int SPEED = 10;

    private int x,y;
    private Dir dir;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean liveing = true;
    private TankFrame tankFrame = null;

    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    private Group group = Group.BAD;


    public Bullet(int x, int y, Dir dir,Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if(!liveing){
            tankFrame.bulletList.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }
        move();
    }

    private void move(){
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
        if(x<0 || y<0 || x>TankFrame.GAME_WIGTH || y>TankFrame.GAME_HEIGHT){
            liveing = false;
        }
    }

    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()){return;}

        //TODO ：用一个Rectangle来记录子弹的位置
        Rectangle rectangle = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectangle1 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rectangle.intersects(rectangle1)){
            tank.dis();
            this.dis();
        }
    }

    private void dis() {
        this.liveing = false;
    }
}
