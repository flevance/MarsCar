package com.dayuanit.car.test;

import com.dayuanit.car.auto.Car;
import com.dayuanit.car.auto.MarsCar;

public class Test {
    public static void main(String[] args) {
//        Car marsCar = new MarsCar("火星车001号", 1, 1);
//        marsCar.move("w");//1 2
//        marsCar.move("w");//1 3
//        marsCar.move("r");//1 2
//        marsCar.move("r");//1 1
//        marsCar.move("r");//1 1
//        marsCar.move("d");//2 1
//        marsCar.move("w");//2 2
//        marsCar.move("r");//2 1
//        marsCar.move("rrr");//2 1

        // Car mooncar = new MoonCar("月球车001号", 2, 2);
        // mooncar.move("w");
        // mooncar.move("w");

        Car car2 = new MarsCar("火星车xxx","database");
//        car2.move("w");//2 2
//        car2.move("w");//2 3
//        car2.move("r");//2 2
//        car2.move("r");//2 2
//        car2.move("r");//2 2

//        car2.move("w", "w", "d");

        car2.move();


    }
}
