package com.dayuanit.car.auto;

import com.dayuanit.car.map.Map;
import com.dayuanit.car.map.Point;
import com.dayuanit.car.util.PointFileUtils;
import com.dayuanit.car.util.UtilsFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MarsCar extends Car {

    public MarsCar() {
        this.name = "火星车xxx";
        this.map = new Map();
    }
    public MarsCar(String name ,String way){
            if ("file" == way || "database" == way) {
                this.name = name;


                this.utilsFactory = new UtilsFactory();
                Point point = utilsFactory.getUtiles(way).readLastPoint();
                this.map = new Map(point);
                super.way = way;
            } else {
                System.out.println("坐标读取位置错误");
                this.name = name;
                Point point = new Point();
            }
        }


    public MarsCar(String name, int x, int y) {
        this.name = name;
        this.map = new Map(x, y);
    }

    public MarsCar(String name, Map map) {
        this.name = name;
        this.map = map;
    }

    public MarsCar(String name) {
        this.name = name;
        this.map = new Map();
    }

    public void move(String... orders) {
        for (String order : orders) {
           super.move(order);
        }
    }

    public void move() {
        System.out.println("请输入指令：");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String order = null;
            while (null != (order = br.readLine())) {
                System.out.println(order);
                if ("q".equalsIgnoreCase(order)) {
                    break;
                }
                super.move(order);
            }

            System.out.println("bye");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
