package com.mark.tank;

import java.awt.*;

/**
 * Created by makang on 2020/2/20.
 */
public class Bullet {
    private static final int SPEED = 10;

    private int x,y;
    private Dir dir;

    private Rectangle rectangle = new Rectangle();

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
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
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
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    //碰撞检测方法Rectangle，矩形重叠运用
    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()){return;}

        if(rectangle.intersects(tank.rectangle)){
            tank.dis();
            this.dis();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tankFrame.explodeList.add(new Explode(eX,eY,tankFrame));
        }
    }

    private void dis() {
        this.liveing = false;
    }
}
