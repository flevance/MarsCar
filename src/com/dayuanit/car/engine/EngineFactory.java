package com.dayuanit.car.engine;

import java.util.HashMap;
import java.util.Map;

public class EngineFactory {

    private static ForwardEngine forwardEngine = new ForwardEngine();
    private static BackEngine backEngine = new BackEngine();
    private static LeftEngine leftEngine = new LeftEngine();
    private static RightEngine rightEngine = new RightEngine();
    private static RollbackEngine rollbackEngine = new RollbackEngine();

    private static final Map<String, Engine> engineMap = new HashMap<>();

    static {
        engineMap.put("a", leftEngine);
        engineMap.put("w", forwardEngine);
        engineMap.put("s", backEngine);
        engineMap.put("d", rightEngine);
        engineMap.put("r", rollbackEngine);
    }

    public Engine getEngine(String order) {
        return engineMap.get(order);
    }

}
