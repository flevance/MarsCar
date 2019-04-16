package com.dayuanit.car.engine;

import com.dayuanit.car.map.Map;

public class ForwardEngine implements Engine {

    public void work(Map map) {
        map.forward();
    }
}
