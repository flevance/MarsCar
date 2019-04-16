package com.dayuanit.car.engine;

import com.dayuanit.car.map.Map;

public class BackEngine implements Engine {
    public void work(Map map) {
        map.back();
    }
}
