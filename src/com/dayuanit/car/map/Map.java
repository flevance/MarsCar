package com.dayuanit.car.map;

public class Map {
    private Point point;

    private static final int maxY = 100;
    private static final int minY = 100;
    private static final int maxX = 100;
    private static final int minX = 100;

    private static final int step = 1;

    public Map() {
        this.point = new Point();
    }

    public Map(int x, int y) {
        this.point = new Point(x, y);
    }

    public Map(Point point){
        this.point = point;
    }

    public void forward() {
        if (point.getY() + step > maxY) {

            return;
        }

        point.changeY(step);
    }

    public void back() {
        if (point.getY() - step < minY) {
            return;
        }

        point.changeY(-step);
    }

    public void left() {
        if (point.getX() - step < minX) {
            return;
        }

        point.changeX(-step);
    }

    public void right() {
        if (point.getX() + step > maxX) {
            return;
        }
        point.changeX(step);
    }

    public void rollback() {
        this.point = point.getPrePoint();
    }

    public int getPointX() {
        return point.getX();
    }

    public int getPointY() {
        return point.getY();
    }
}
