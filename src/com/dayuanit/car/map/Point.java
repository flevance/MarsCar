package com.dayuanit.car.map;

public class Point {

    private int x;
    private int y;
    private Point prePoint;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Point(int x, int y, Point prePoint) {
        this.x = x;
        this.y = y;
        this.prePoint = prePoint;
    }

    public void changeY(int step) {
        //将当前坐标对象copy到新创建的对象中
        Point copyPoint = new Point(this.x, this.y, this.prePoint);
        //将当前对象的prePoint赋值为新创建的对象copyPoint
        this.prePoint = copyPoint;
        //执行命令
        this.y += step;
    }

    public void changeX(int step) {
        Point copyPoint = new Point(this.x, this.y, this.prePoint);
        this.prePoint = copyPoint;
        this.x += step;
    }

    public Point getPrePoint() {
        return this.prePoint == null ? this : this.prePoint;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return this.y;
    }

}
