package com.dayuanit.car.engine;

import com.dayuanit.car.map.Map;

public class RightEngine implements Engine {
    public void work(Map map) {
        map.right();
    }
}
