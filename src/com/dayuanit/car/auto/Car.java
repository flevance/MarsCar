package com.dayuanit.car.auto;

import com.dayuanit.car.engine.Engine;
import com.dayuanit.car.engine.EngineFactory;
import com.dayuanit.car.exception.OrderException;
import com.dayuanit.car.map.Map;
import com.dayuanit.car.util.PointFileUtils;
import com.dayuanit.car.util.UtilsFactory;

public abstract class Car {
    protected String name;
    protected Map map;
    protected UtilsFactory utilsFactory;
    protected String way;

    private EngineFactory factory = new EngineFactory();

    public Car() {
    }

    public Car(String name, Map map) {
        this.name = name;
        this.map = map;
    }

    public abstract void move(String... orders);

    public abstract void move();

    public void move2(String order) {
        EngineFactory factory = new EngineFactory();//可以当做成员变量 节省内存
        Engine engine = factory.getEngine(order);
        engine.work(map);

        System.out.println(name + "坐标[" + map.getPointX() + "," + map.getPointY() + "]");
    }

    public void move(String order) {
        Engine engine = factory.getEngine(order);
//        if (null == engine) {
//            return;
//        }

        if (null == engine) {
            throw new OrderException(order + "是非法指令");
        }

        engine.work(map);
        System.out.println(name + "坐标[" + map.getPointX() + "," + map.getPointY() + "]");


        // 将坐标持久化到文件系统
        if ("database" == way){
            utilsFactory.getUtiles(way).savePoint(map.getPointX(),map.getPointY());
        }
        if ("file" == way){
            utilsFactory.getUtiles(way).savePoint(map.getPointX(),map.getPointY());

        }
    }
}
