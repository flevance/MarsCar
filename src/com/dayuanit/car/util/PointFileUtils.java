package com.dayuanit.car.util;

import com.dayuanit.car.map.Point;
import java.io.*;

public class PointFileUtils implements Utils {

    private static final String pointFilePath = "/Users/liu/Java_Study/MarsCar/src/com/dayuanit/car/util/pointRecord.txt";

    public static void savePoint(int x, int y, String path) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "utf-8"))) {
            //坐标放在一行 通过逗号 或者$分割
            //2,5
            //4$7
            //换行符号 有的是\n 有的是\r\n 跟操作系统是有关系的
            bw.write(x + "," + y);
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void savePoint(int x, int y) {
        savePoint(x, y, pointFilePath);
    }

    public Point readLastPoint() {
        return readLastPoint(pointFilePath);
    }

    public static Point readLastPoint(String path) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"))) {
            String msg = null;
            String lastPoint = null;
            while (null != (msg = br.readLine())) {
                lastPoint = msg;
            }

            System.out.println("lastPoint=" + lastPoint);
            //2,3
            String[] pointInfo = lastPoint.split(",");
            return new Point(Integer.parseInt(pointInfo[0]), Integer.parseInt(pointInfo[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Point(0,0);//兜底
    }
}
